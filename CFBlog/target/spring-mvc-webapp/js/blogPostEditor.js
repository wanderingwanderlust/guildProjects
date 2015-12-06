/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function blogPostEditor() {

    tinymce.init({
        plugins: [
            "advlist autolink link image lists preview hr anchor spellchecker",
            "searchreplace visualblocks code fullscreen media nonbreaking",
            "save table textcolor emoticons "
        ],
        toolbar: "undo redo | bold italic | emoticons |" +
                "alignleft aligncenter alignright alignjustify | " +
                "bullist numlist outdent indent | link image | " +
                "media fullpage preview ",
        
        selector: "#mytextarea"
        

    });
    
    
 $('#add-button').on('click', function () {
                            var $btn = $(this).button('loading');
                            tinymce.triggerSave();
                            $btn.button('reset');
                        });
                        
                        
    $('#draftButton').on('click', function () {
                            var $btn = $(this).button('loading');
                            // business logic...
                            $btn.button('reset');
                        });
}

blogPostEditor();



$(document).ready(function () {
    
    loadBlogPost();

    $('#add-button').click(function (event) {
        
        event.preventDefault();
        
        var d = new Date();
        d.toJSON();
        
        tinymce.triggerSave();
        
        $.ajax({
            type: 'POST',
            url: 'blogPost',
            data: JSON.stringify({
                user_id: 1,
                post_status_id: 1,
                title: $('#add-title').val(),
                blogText: tinymce.activeEditor.getContent(),
                blogDate: d
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
            //$('#add-title').val('');
           // $('#mytextarea').val('');
            //$('#validationErrors').empty();
                        
            loadBlogPost();

            //window.location.href = "../";
            

        }).error(function(jqXHR, textStatus, errorThrown) {
    alert(jqXHR.status);
    alert(textStatus);
    alert(errorThrown);
 //$.each(data.responseJSON.validationErrors, function(index, validationError){
                //var errorDiv = $('#validationErrors');
                //errorDiv.append(validationError.message).append($('<br>'));
            
            //});
        });
    });


function fillBlogTable(blogPostTable, status) {
    clearBlogTable();
    var bTable = $('#contentRows');

    $.each(blogPostTable, function (index, blogPost) {
        bTable.append($('<tr>')
                .append($('<td>').append(
                        $('<a>')
                        .attr(
                                {
                                    'data-blog-id': blogPost.blogPostId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                }
                        )
                                   .text(blogPost.title))
                                   .append($('<td>').html(blogPost.blogText))
                    
                            )
                    
                    );
        });
    }
    
function loadBlogPost() {
        

    $.ajax({
            type: 'GET',
            url: 'blogPost',
            data: JSON.stringify({
                blogText: $('#mytextarea').val()  
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function (data, status) {
        fillBlogTable(data,status);
       
    });
}

});

function clearBlogTable() {
    $('#contentRows').empty();
}

$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var blogPostId = element.data('blog-post-id');

    var modal = $(this);

    $.ajax({
        type: 'GET',
        url: 'blogPost/' + blogPostId
    }).success(function (blogPost) {

        modal.find('#blog-post-id').text(blogPost.blogPostId);
        modal.find('#blog-title').text(blogPost.title);
        modal.find('#blog-text').html(blogPost.blogText);
        
    });
});

