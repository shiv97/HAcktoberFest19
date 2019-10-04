console.log("i am inside create table")
var testApp = angular.module('testApp', [])
    .config(function($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        $httpProvider.defaults.withCredentials = true;
    });

testApp.controller("testController", function($scope, $http) {
  $scope.home = "This is the homepage";

  //    Our GET request function
  $scope.getRequest = function() {
    console.log("I've been pressed!");
    $http.get("/users").then(
      function successCallback(res) 
	  {
        $scope.response=res.data;
		console.log($scope.response);
	  },
      function errorCallback(response) {
        console.log("Unable to perform get request");
      }
    );
  };

  //    Our POST request function
  $scope.postRequest = function() {
    $http.post("/users", data).then(
      function successCallback(response) {
        console.log("Successfully POST-ed data");
      },
      function errorCallback(response) {
        console.log("POST-ing of data failed");
      }
    );
  };
});