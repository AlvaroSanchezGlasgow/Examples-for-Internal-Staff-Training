
/**
 * 
 * @param formId
 * @param url
 * @returns
 */
function setAjax(formId,url) {
	//We ActiveLoading
	
	
	activeLoading();
	
	$.ajax({
			type: "POST",
			url : url,
			dataType: "html",
			data :  $("#" + formId).serialize(),
			async:false, // not recommended!!!!!!!!
            cache:false,
            
           success : function(data) {

        	   removeLoading();
        	  
        	   if ((data == "[]") || (data == "[{}]")){
        		   data = "[]";
        		   errorPopUp("Data not found","There are not results for the selected filter");
        	   
        	  // }else if(data.indexOf("ERROR") ){
        		   
        		//   errorPopUp("Error in Ajax response!!- ",data);
        	   }
    		   var jsonData = JSON.parse(data);
    		   
    		   manageAjaxResponse(formId,data);
    	   
			},
	        error: function (err) {

	        	removeLoading();
	
	        	errorPopUp("Server Error",err.responseText);
	    	
	        }
    });

}


/**
 * 
 * @param paramId
 * @param url
 * @returns
 */
function setAjaxDetail(paramId,url) {
	
	activeLoading();
	
	$.ajax({
			type: "POST",
			url : url,
			dataType: "html",
			data:{
				id: paramId
			},
			async:false, // not recommended!!!!!!!!
            cache:false,
            
           success : function(data) {
        	 
        	   removeLoading();
        	   
        	   
        	   if ((data == "[]") || (data == "[{}]")){
           		
        		   errorPopUp("Data not found","There are not results for the selected filter");
        	   
        	   }else{

        		   var jsonData = JSON.parse(data);
        	      	
        		   drawDetailAjaxRexponse(data);
        	   }
        	   
				
			},
	        error: function (err) {
	        	 removeLoading();
	        	 errorPopUp("Server Error",err.responseText);
	    	
	        }
    });
}

/**
 * 
 * @param formId
 * @param url
 * @returns
 */
function setAjaxNewElements(formId,url) {
	
     activeLoading();
    // alert($("#file").val());
     //alert($("#" + formId).serialize());
     var formData = new FormData($("#" + formId));
    // formData.append("file", $("#file").val());
     formData.append("file", $("#file").val());
    // formData.append("policy_title_new", $("#policy_title_new").val());
  //   formData.append("version_new", $("#version_new").val());
   //  formData.append("policy_desc_new", $("#policy_desc_new").val());
    
$.ajax({
	
    		type: "POST",
			url : url,
			//contentType: "multipart/mixed;boundary=XXX;",
			contentType: "multipart/form-data;boundary=------WebKitFormBoundaryDoDKoBlDPlASqOjo",
			//dataType: "text/plain",
			//contentType : 'application/json; charset=UTF-8;boundary=gc0p4Jq0M2Yt08jU534c0p',
			dataType: "html",
			data :  $("#" + formId).serialize(),
			file : $("#file").val(),
			cache: false,
	        processData: false,	
   
           success : function(data) {

        	   removeLoading();
        	  
        	   if ((data == "[]") || (data == "[{}]")){
        		   
        		   errorPopUp("Data not found","There are not results for the selected filter");
        	   
        	  // }else if(data.indexOf("ERROR") ){
        		   
        		//   errorPopUp("Error in Ajax response!!- ",data);
        	   }else{
        		   var jsonData = JSON.parse(data);
        		   
        		   manageAjaxResponse(formId,data);
        	   }
			},
	        error: function (err) {

	        	removeLoading();
	
	        	errorPopUp("Server Error",err.responseText);
	    	
	        }
    });

}

