hideAllDivs = function(){
    $(".secondChoice, .temp, .weight, .currency, .length").hide();
};

showSecondChoice = function(divID){
    $(".secondChoice").show();
    
    $(divID).show();

}


handleNewSelection = function () {

    hideAllDivs();

    switch ($(this).val()) {
        case 'temp':
            showSecondChoice('.temp');
            
        break;
        case 'weight':
            showSecondChoice(".weight");
        break;
        case 'currency':
            showSecondChoice(".currency");
        break;
        case 'length':
            showSecondChoice(".length");
        break;
    }
};


    
    


$(document).ready(function() {

    $("#firstChoice").change(handleNewSelection);
    

    // Run the event handler once now to ensure everything is as it should be
    handleNewSelection.apply($("#firstChoice"));
   
});
