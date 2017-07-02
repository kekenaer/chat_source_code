var system=(function(parent,$){
	var login = parent.login = parent.login || {};
	function eventHandler(){
		$("login-button").on("",getFormData);
	}
	
	
	function loginIn(){
		
	}
		
	login.init = function(){
		eventHandler();
	}
	
})(system || {}, jQuery);