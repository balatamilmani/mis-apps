/**
 * 
 */
mainModule.controller("helloController", function($scope, appService) {
	$scope.name = "Hello World AngularJS";
	
	var callMe = function(){
		alert("Within callMe");
		appService.fn();
	} ;
	
	var employees;
	
	employees = [{name:"Bala", age:23, skill:"Programming"}, {name:"Kal", age:33, skill:"Engineering"}];
	$scope.employeeList = employees;
	alert(employees);
	
	
	$scope.callMe = callMe;
});