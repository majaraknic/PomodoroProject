var app = angular.module("Pomodoro", ["ngRoute"]);

app.controller("ctrl", function($scope){
	$scope.message("POCETNA");
});

app.controller("editUserCtrl", function($scope, $routeParams, $http, $location){

	//console.log($routeParams);
	var userId = $routeParams.aid;
	var baseUrl = "/user";

	$scope.user = {};
	$scope.user.email = "";
	$scope.user.password = "";
	$scope.user.passwordConfirmation = "";
	$scope.user.fullName = "";


	var getUser = function(){

		$http.get(baseUrl + "/" + userId).then(
			function success(res){
				$scope.user = res.data;
			},
			function error(res){
				console.log("Something went wrong!");
			}
		);
	}

	getUser();

    $scope.edit = function(){
    	$http.put(baseUrl + "/" + userId, $scope.user).then(
    		function success(res){
    			//alert("Uspeh");
    			$location.path("/user");
    		},
    		function error(res){
    			alert("Something went wrong");
    		}
    	);
    }

});

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
    	.when('/', {
    		templateUrl : '/app/html/partial/home.html',
    		controller: 'ctrl'
    	})
    	.when('/user', {
    		templateUrl : '/app/html/partial/edit-User.html'
    	})
    	.otherwise({
    		redirectTo: '/'
   		});
}]);