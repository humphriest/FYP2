(function(){
    'use strict';
    App.controller('CartController', ['$scope','CartService','$cookieStore','$http',
        function ($scope, CartService, $cookieStore, $http) {

            $scope.currentUser = $cookieStore.get('userCookie');
            $scope.edit = false;

            CartService.getCartByUser(JSON.stringify($scope.currentUser))
                .then(function (res) {
                    $scope.carts = res.data;
                    console.log("res data: " + res.data);
                    $scope.overallQuantity();
                    $scope.overallPrice();
                })
                .catch(function (err) {
                    console.log(err);
                });

            $scope.editObject = function () {
                $scope.overallQuantity();
                $scope.overallPrice();

            };

            $scope.overallQuantity = function () {
                $scope.totalQuantity = null;
                for(var i = 0; i< $scope.carts.length; i++){
                    $scope.totalQuantity += $scope.carts[i].cart.quantity;
                }
            };

            $scope.overallPrice = function () {
                $scope.totalPrice = null;
                for(var i = 0; i< $scope.carts.length; i++){
                    $scope.totalPrice += $scope.carts[i].cart.stockItem.price;
                }
            };


            $scope.purchase = function () {
                console.log("purchase clicked");
                $scope.payForThis = [];
                for (var i = 0 ; i<$scope.carts.length; i++){
                    delete $scope.carts[i]["$$hashKey"];
                    $scope.payForThis.push($scope.carts[i].cart);
                }
                $http.post('/restful-services/cartApi/updatePaid', JSON.stringify($scope.payForThis))
                    .then(function (res) {
                        console.log(res);
                    })
                    .catch(function (err) {
                        console.log(err)
                    })
            }

        }])
})();