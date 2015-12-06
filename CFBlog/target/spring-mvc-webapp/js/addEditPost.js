/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*   $('#add-Button').on('click', function () {
                            var $btn = $(this).button('loading');
                            tinyMCE.triggerSave();
                            $btn.button('reset');
                        });
                        
                        
    $('#draftButton').on('click', function () {
                            var $btn = $(this).button('loading');
                            // business logic...
                            $btn.button('reset');
                        });
 */
                                 
   $(document).ready(function () {
       
    loadCategories();

    $('#add-category-button').click(function (event) {

        event.preventDefault();

        $.ajax({
            type: 'POST',
            url: 'categories',
            data: JSON.stringify({
                category: $('#category').val()
                
            }),
            headers:
                    {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
            'dataType': 'json'
        }).success(function (data, status) {
            $('#category').val('');
       
            loadCategories();

         });
     });
 });
 


 
function loadCategories()
{
   
    $.ajax({
        type:'GET'
        url: 'addEditBlogPost'
    }).success(function (data, status) {
        fillCategoryList(data,status);
    });
}

function fillCategoryList(categoryList, status) //TODO: update to take a category map parameter
{
    clearCategoryList();

    var catList = $('#category-list');
 
        $.each(categoryList, function (index, category) {
            catList.append($('<a>')
                            .attr(
                                    {
                                        'data-category-id': category.id, //create category DTO?
                                        'data-toggle': 'modal',
                                        'data-target': '#detailsModal'
                                    })
                            .attr(
                                    {
                                        'data-dvd-id': dvd.id,
                                        'data-toggle': 'modal',
                                        'data-target': '#editModal'
                                    })
                            .text('Edit')))
                    .append($('<td>')
                            .append($('<a>')
                                    .attr({'onClick': 'deleteDvd(' + dvd.id + ')'}).text('Delete')))
                    );
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
