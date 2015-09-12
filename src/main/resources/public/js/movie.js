angular.module('movie', []).controller('home', function($scope, $http) {
    $http.get('movie/1').success(function(data) {
        $scope.movie = data;
    })
});
