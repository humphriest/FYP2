(function(){
    "use strict";

    window.App = angular.module('electricStore', [
        'ngAnimate',
        'ngResource',
        'ui.router'
    ])
        .config(['$stateProvider', '$locationProvider', '$urlRouterProvider', function ($stateProvider, $locationProvider, $urlRouterProvider) {
            $locationProvider.html5Mode(false);

            $urlRouterProvider.otherwise( function($injector) {
                var $state = $injector.get("$state");
                $state.go('app.home');
            });
            $stateProvider
                .state('app', {
                    url: '/app',
                    abstract: true,
                    templateUrl: 'build/app/views/app.html',
                    controller: 'appController'
                })
                .state('app.home', {
                    url: '/home',
                    templateUrl: 'build/app/views/home.html',
                    controller: 'MainMenuController'
                })
                .state('login',{
                    url: '/login',
                    templateUrl: 'build/app/views/login.html',
                    controller: 'LoginController'
                })
                .state('app.products',{
                    url: '/products',
                    templateUrl: 'build/app/views/products.html',
                    controller: 'ProductsController'
                });
            /*.state('signup',{
             url: '/signup',
             controller: 'SignupController',
             templateUrl: 'build/app/views/signup.html'
             })*/
        }]);
    /*

     var injector = angular.injector(['ng']);
     var $http = injector.get("$http");*/

})();