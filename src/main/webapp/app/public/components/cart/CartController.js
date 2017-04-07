(function(){
    'use strict';
    App.controller('CartController', ['$scope','CartService','$cookieStore',
        function ($scope, CartService, $cookieStore) {

            $scope.currentUser = $cookieStore.get('userCookie');
            $scope.edit = false;

            CartService.getCartByUser($scope.currentUser)
                .then(function (res) {
                    $scope.carts = res.data;
                    console.log("res data:" + res.data);
                    $scope.overallQuantity();
                    $scope.overallPrice();
                })
                .catch(function (err) {
                    console.log(err);
                });

            $scope.editObject = function () {

            };

            $scope.overallQuantity = function () {
                $scope.totalQuantity = null;
                for(var i = 0; i< $scope.carts.length; i++){
                    $scope.totalQuantity += i.cart.quantity;
                }
            };

            $scope.overallPrice = function () {
                $scope.totalPrice = null;
                for(var i = 0; i< $scope.carts.length; i++){
                    $scope.totalPrice += i.cart.price;
                }
            };

            $scope.purchase = function () {
                $http.post('/restful-services/cartApi/updatePaid', $scope.carts)
                    .then(function (res) {
                        console.log(res);
                    })
                    .catch(function (err) {
                        console.log(err)
                    })
            }

        }])
})();