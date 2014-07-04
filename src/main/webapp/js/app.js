var app = angular.module('geektic',['ngRoute']);



app.controller('GeekCtrl', function($scope, $http) {    
    
	$scope.constructionCombo = function()
	{
		$http.get('/api/geek/interets').success(function(interets) {
            $scope.interets = interets;
        });
	}
	
	$scope.constructionCombo();
	
	$scope.chercher = function(sexe,interet)
    {
		//alert($interet);
		//alert($sexe);
		
	
		if ($scope.interet == null )
		{
			interet = 'Tous';
			
		}
		//alert(interet);
		$http.get('/api/geek/geeks/' + sexe + '/' + interet).success(function(geeks) {
            $scope.geeksbysex = geeks;
            
        });
    };    
});