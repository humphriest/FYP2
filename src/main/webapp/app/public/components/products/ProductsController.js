(function(){
    'use strict';
    App.controller('ProductsController', ['$scope','$http','$state',
        function($scope, $http, $state){

            $scope.productsMessage = "products";

            $scope.title = "";

            $http.get('/restful-services/stockApi/getAllItems')
                .then(function(res){
                    $scope.items = res.data;
                    console.log($scope.items+" items");
                    console.log(res.data+" res.data");
                }, function(err){
                    console.log(err);
                });

           /* $scope.saveItem = function () {
                $http.get('/restful-services/stockApi/createItem/'+JSON.stringify($scope.itemId)+'/'+
                    JSON.stringify($scope.title)+'/'+JSON.stringify($scope.manuf)+'/'+
                    JSON.stringify($scope.category)+'/'+JSON.stringify($scope.image)+'/'+
                    JSON.stringify($scope.price))
                    .then(function (res) {
                        console.log(res+" was a success");
                    })
                    .then(function (err) {
                        console.log("error here: "+err);
                    })
            };*/
            $scope.saveItemNotStringify = function () {
                $http.get('/restful-services/stockApi/createItem/'+$scope.itemId+'/'+
                    $scope.title+'/'+$scope.manuf+'/'+
                    $scope.category+'/'+$scope.image+'/'+
                    $scope.price)
                    .then(function (res) {
                        console.log(res+" was a success");
                    })
                    .then(function (err) {
                        console.log("error here: "+err);
                    })
            };

            $scope.create = function(){
                $state.go('app.createProduct');
            }
        }])
})();