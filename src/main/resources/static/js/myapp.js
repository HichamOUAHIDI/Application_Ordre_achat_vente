var app =angular.module("myAPP",[]);
app.controller("myController", function($scope,$http){
	$scope.societe=null;
	$scope.ordre={type:"achat",prix:0,nombre_actions:0,date:new Date()};
	$scope.codeSociete=null;
	$scope.nombreTotalAchat=null;
	$scope.nombreTotalVente=null;
	$scope.moyennePrixAchat=null;
	$scope.moyennePrixVente=null;
	$scope.estimationPrix=null;
	$scope.pageOrders =null;
	$scope.pageCorant=0;
	$scope.size=4;
	$scope.pages=[];
	$scope.chargerSociete=function(){
		
		$http.get("/societe?id="+$scope.codeSociete)
		.then(function(data){
			$scope.societe=data.data;
		});
		$http.get("/totalActionsVente?id="+$scope.codeSociete)
		.then(function(data){
			$scope.nombreTotalVente=data.data;
		});
		$http.get("/totalActionsAchat?id="+$scope.codeSociete)
		.then(function(data){
			$scope.nombreTotalAchat=data.data;
		});
		$http.get("/moyenneAchat?id="+$scope.codeSociete)
		.then(function(data){
			$scope.moyennePrixAchat=data.data;
		});
		$http.get("/moyenneVente?id="+$scope.codeSociete)
		.then(function(data){
			$scope.moyennePrixVente=data.data;
		});
		$http.get("/actionPriceEstimate?id="+$scope.codeSociete)
		.then(function(data){
			$scope.estimationPrix=data.data;
		});
		$scope.chargerOrder();
	}
	$scope.chargerOrder=function(){
			$http.get("/listOrdresSociete?id="+$scope.codeSociete+"&page="
					+$scope.pageCorant+"&size="+$scope.size)
			.then(function(data){
				$scope.pageOrders=data.data;
				console.log($scope.pageOrders);
				$scope.pages=new Array(data.data.totalPages);	
			})
		}
	$scope.goToPage=function(index){
		$scope.pageCorant=index;
		$scope.chargerOrder();
	}

	
})