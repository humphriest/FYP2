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
                    $scope.showStrategy();
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
            };

            $scope.shippingPrices = [];

            var Shipping = function() {
                this.company = "";
            };

            Shipping.prototype = {
                setStrategy: function(company) {
                    this.company = company;
                },

                calculate: function(purchase) {
                    return this.company.calculate(purchase);
                }
            };

            var UPS = function() {
                var result  = {
                    finalPrice :0,
                    company: "UPS"
                };
                this.calculate = function(pack) {
                    if(pack.price < 1000){
                        result.finalPrice = 50;
                    }else{
                        result.finalPrice = 150;
                    }
                    if(pack.quantity < 5){
                        result.finalPrice += 30;
                    } else{
                        result.finalPrice += 100;
                    }
                    $scope.shippingPrices.push(result);
                    return result;
                }
            };

            var USPS = function() {
                var result  = {
                    finalPrice :0,
                    company: "USPS"
                };
                this.calculate = function(pack) {
                    if(pack.price < 2000){
                        result.finalPrice = 100;
                    }else{
                        result.finalPrice = 200;
                    }
                    if(pack.quantity < 7){
                        result.finalPrice += 50;
                    } else{
                        result.finalPrice += 130;
                    }
                    $scope.shippingPrices.push(result);
                    return result;
                }
            };

            var Fedex = function() {
                var result  = {
                    finalPrice :0,
                    company: "Fedex"
                };
                this.calculate = function(pack) {
                    if(pack.price < 2500){
                        result.finalPrice = 150;
                    }else{
                        result.finalPrice = 250;
                    }
                    if(pack.quantity < 10){
                        result.finalPrice += 120;
                    } else{
                        result.finalPrice += 180;
                    }
                    $scope.shippingPrices.push(result);
                    return result;
                }
            };

            $scope.showStrategy = function () {
                var usps = new USPS();
                var ups = new UPS();
                var fedex = new Fedex();

                var pack = {
                    quantity : $scope.totalQuantity,
                    price : $scope.totalPrice
                };

                var shipping = new Shipping();
                shipping.setStrategy(usps);
                console.log("USPS calculate " + shipping.calculate(pack));
                shipping.setStrategy(ups);
                console.log("ups calculate " + shipping.calculate(pack));
                shipping.setStrategy(fedex);
                console.log("fedex calculate " + shipping.calculate(pack));
            }
        }])
})();