(function(){
    'use strict';
    App.controller('PurchaseController',['$scope','$http','$cookieStore','CartService',
    function ($scope, $http, $cookieStore, CartService) {
        $scope.currentUser = $cookieStore.get('userCookie');

            CartService.getPurchasedByUser(JSON.stringify($scope.currentUser))
            .then(function (res) {
                $scope.purchases = res.data;
                console.log("res.data:" + res.data);
                $scope.overallPrice();
                $scope.overallQuantity();
            })
            .catch(function (err) {
                console.log("error getting purchase history"+err);
            });


        $scope.overallQuantity = function () {
            $scope.totalQuantity = null;
            for(var i = 0; i< $scope.purchases.length; i++){
                $scope.totalQuantity += $scope.purchases[i].cart.quantity;
            }
        };

        $scope.overallPrice = function () {
            $scope.totalPrice = null;
            for(var i = 0; i< $scope.purchases.length; i++){
                $scope.totalPrice += $scope.purchases[i].cart.stockItem.price;
            }
        };
    }])
})();