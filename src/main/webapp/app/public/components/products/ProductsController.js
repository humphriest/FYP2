(function(){
    'use strict';
    App.controller('ProductsController', ['$scope','$http',
        function($scope, $http){

            $scope.productsMessage = "products";

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