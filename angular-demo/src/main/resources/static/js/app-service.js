/**
 * 
 */
'use strict';

mainModule.service('appService', function applicationService() {
	var fn;
	
	this.fn = function(){
		alert("in fn");
	}
});