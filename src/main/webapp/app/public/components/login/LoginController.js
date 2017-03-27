(function(){
    'use strict';
    App.controller('LoginController', ['$scope','$http','$state','UserService','$cookies',
        function($scope, $http, $state, UserService, $cookies){

            $scope.loginMessage = "login message from loginController";

            $scope.user = {};

            $scope.loginUser = {};

            console.log("user: "+ $scope.user);


            $scope.login = function () {
                console.log("login clicked");
                console.log($scope.loginUser.username+": username, "+ $scope.loginUser.password+": password");

                if($scope.username != null || $scope.username != ""){
                    if($scope.password != null || $scope.password != ""){
                        UserService.loginUser(JSON.stringify($scope.loginUser))
                            .then(function (res) {
                                $scope.currentUser = res.data.user;
                                $cookies.put('testCookie', $scope.currentUser);
                            }).catch(function (err) {
                            console.log("error: "+err);
                            $scope.currentUser = null;
                        });
                    }else{
                        console.log("inner toastr error");
                    }
                } else{
                    console.log("inner toastr error");
                }
            };

            $scope.register = function () {
                console.log("Register Clicked");
                console.log($scope.user, "Register Function");

                if($scope.user.password == $scope.confirmPassword) {
                    console.log("Inside if statement");
                    UserService.addUser(JSON.stringify($scope.user))
                        .then(function (res) {
                            console.log(res.data);
                        })
                        .catch(function (err) {
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