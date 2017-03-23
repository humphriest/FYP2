(function(){
    'use strict';
    App.controller('LoginController', ['$scope','$http',
        function($scope, $http){

            $scope.loginMessage = "login message from loginController";

            $scope.user = {};

            console.log("user: "+ $scope.user);

            $scope.register = function () {
                console.log("Register Clicked");
                if($scope.user.password == $scope.confirmPassword) {
                    console.log("Inside if statement");
                    $http.post('/restful-services/userApi/', $scope.user)
                        .then(function (res) {
                            $scope.result = res.data;
                            console.log($scope.result);
                            console.log(res + ": res, " + res.data + ": res.data");
                        })
                        .then(function (err) {
                            console.log(err + " error here");
                        })
                }else{
                    console.log("wrong credentials");
                }
            };

            $scope.images = [
                './images/1.jpg',
                '../images/2.jpg',
                '../../images/3.jpg'
            ];

        }])
})();