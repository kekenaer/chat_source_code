var system=(function(parent,$){
	var form = parent.form = parent.form || {};
	function eventHandler(){
		
	}
	
	function getFormData(target){
		var data = $(target).serializeArray();
		return data;
	}
	
		
	form.init = function(){
		eventHandler();
	}
	
})(system || {}, jQuery);