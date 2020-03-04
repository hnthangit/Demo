$(document).ready(function($) {
	
	//Link in table
    $(".table-row").click(function() {
        window.document.location = $(this).data("href");
    });
    
    
});
