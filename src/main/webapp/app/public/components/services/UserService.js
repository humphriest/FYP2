(function(){
    'use strict';
    App.service('UserService',['$http',
        function($http){

            var baseUrl = '/restful-services/userApi';

            this.getUsers = function(){
                return $http.get(baseUrl + '/getUsers');
            };

            this.getUserById = function(id){
                return $http.get(baseUrl + '/current' + id);
            };

            this.addUser = function(user){
                return $http.post(baseUrl + '/createUser', user);
            };

            this.updateUser = function(user){
                return $http.put(baseUrl, + '/' + user.id, user);
            };
            this.loginUser = function(user){
                return $http.post(baseUrl, + '/loginUser', user);
            };

            this.deleteUser = function(id){
                return $http.delete(baseUrl + '/deleteUser');
            };
        }])
})();