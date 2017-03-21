(function(){
    'use strict';
    App.controller('LoginController', ['$scope','$http',
        function($scope, $http){

            $scope.loginMessage = "login message from loginController";

            $http.get('/restful-services/stockApi/getAllItems')
                .then(function(res){
                    $scope.items = res.data;
                    console.log($scope.items+" items");
                    console.log(res.data+" res.data");
                }, function(err){
                    console.log(err);
                })

        }])
})();