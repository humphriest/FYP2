(function(){
    "use strict";

    window.App = angular.module('electricStore', [
        'ngAnimate',
        'ngResource',
        'ui.bootstrap',
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
                    templateUrl: 'views/app.html',
                    controller: 'appController'
                })
                .state('app.home', {
                    url: '/home',
                    templateUrl: 'views/home.html',
                    controller: 'MainMenuController'
                })
                .state('login',{
                    url: '/login',
                    controller: 'LoginController',
                    templateUrl: 'views/login.html'
                })
                .state('signup',{
                    url: '/signup',
                    controller: 'SignupController',
                    templateUrl: 'views/signup.html'
                })


        }]);


    var injector = angular.injector(['ng']);
    var $http = injector.get("$http");

})();