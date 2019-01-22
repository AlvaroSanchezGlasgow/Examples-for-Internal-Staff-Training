/**
 * 
 * @param sUrl
 * @returns
 */
 function deleteSelectedCheckboxes(){
	
	// alert($("input:checkbox:not(:checked)").val());
		 var ids = [];
		 var i = 0;

		 $("input:checkbox:checked").each(function() {
			 ids[i] = $(this).val();
			 i++;
			
		 });
		 
		 if (ids.length == 0){
				
			 $.alert('Please, select any checkbox');
		 }else{
			 
			 
			 this.window.open("/Everis/delete/"+ids, "_self");
			 //setAjaxDelete(ids,sUrl);
		 }
 }
 