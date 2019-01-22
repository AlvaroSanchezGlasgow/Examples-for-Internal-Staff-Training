function deleteConfirm(){
		
	$.confirm({
	    title: 'Delete',
	    content: 'Do you want to delete the selected record/s?',
	    buttons: {
	        confirm: function () {
	        	deleteSelectedCheckboxes();
	        },
	        cancel: function () {
	            //$.alert('Canceled!');
	        },
	
	    }
	});
}

function newUserPopUp(){
	
	
	$.confirm({
	    title: 'New User',
	    content: '' +
	    '<form id="FormNewUser" method="POST" value="/Everis/save" action="/Everis/save" class="formName">' +
	    '<div class="row" style="text-align: center;">' +
		'<div class="col">' +
		'	<input type="text" name="userID" maxlength="3" type="number" step="any" class="form-control" placeholder="User ID" required>' +
		
		'	<input type="text" name="userName" maxlength="50" class="form-control" placeholder="User name" required>' +
		'</div>' +
		'<div class="col">' +
		'	<input type="text" name="userSurname"  maxlength="50" class="form-control" placeholder="User Surname" required>' +
		
		'	<input type="text" name="userRole"  maxlength="50" class="form-control" placeholder="User Role" required>' +
		'</div>' +
	    '</form>',
	    buttons: {
	        formSubmit: {
	            text: 'Submit',
	            btnClass: 'btn-blue',
	            action: function () {
	            	document.getElementById('FormNewUser').submit();
	               // $.alert('Your name is ' + name);
	            }
	        },
	        cancel: function () {
	            //close
	        },
	    }

	});
}