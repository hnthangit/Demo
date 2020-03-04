$(document).ready(function($) {
	
	//Index page cant save when init
	$("#submit").attr('disabled', 'true');

	// Required input
	$('input.required').on('input', function() {
		var fields = $('input.required');
		var warnings = $('small.warning');
		for (var i = 0; i < fields.length; i++) {
			if ($(fields[i]).val() === '')
				$(warnings[i]).html("Fill in the blank");
			else
				$(warnings[i]).html("");
		}
	})

	// Validate date func
	function isValidDate(dateString) {
		var regEx = /^\d{4}-\d{2}-\d{2}$/;

		// Invalid format
		if (!dateString.match(regEx))
			return false;
		var d = new Date(dateString);
		var dNum = d.getTime();

		// NaN value, Invalid date
		if (!dNum && dNum !== 0)
			return false;
		return d.toISOString().slice(0, 10) === dateString;
	}

	//Only lettter for lastname, firstname
	$('input.string').bind('keyup blur',function(){ 
	    var node = $(this);
	    node.val(node.val().replace(/[^A-Za-z]/g,'') ); }
	);
	
	// Check number in firstname, lastname field
	$('input.date').on('input', function() {
		if ($(this).val() !== '') {
			if (isValidDate($(this).val()) == false)
				$(".datewarning").html("Date yyyy-mm-dd pls");
			else
				$(".datewarning").html("");
		} else
			$(".datewarning").html("");
	})

	
	//Allow update when no warning
	$('input').on('input', function() {
		var count = 0;
		var warnings = $('small.warning');

		for (var i = 0; i < warnings.length; i++) {
			if (!$(warnings[i]).is(':empty'))
				count++;
		}

		if (!$(".datewarning").is(':empty'))
			count++;
		console.log(count);
		if (count > 0)
			$(".submit").attr('disabled', 'true');
		else
			$(".submit").removeAttr('disabled');
	})
	
	

});
