angular
    .module('library', ['ngRoute'])

    .config(function ($routeProvider, $httpProvider) {
        $routeProvider
            .when("/", {
                templateUrl: 'home.html',
                controller: 'home',
                controllerAs: 'controller'
            })
            .otherwise('/');

        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    })

    .controller('home', function ($http) {
        var self = this;
        $http.get('library/catalog').then(function (response) {
            self.catalog = response.data;
        });
    })

    .controller('navigation', function ($rootScope, $scope, $http, $location) {

        $http.get('user').then(
            function (response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
            },
            function () {
                $rootScope.authenticated = false;
            }
        );

        this.logout = function () {
            $http.post('logout', {}).success(function () {
                $rootScope.authenticated = false;
                $location.path("/");
            }).error(function (data) {
                $rootScope.authenticated = false;
            });
        };
    });