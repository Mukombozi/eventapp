(function(){
eventapp.
component("eventList",{
	templateUrl: 'resources/js/eventList.html'  , 
	
	controller : ['$http', function inlist($http){
		var self = this;
		$http({
		method:'GET',
		url:'http://localhost:8080/eventapp/eventlist.json'
			}).then(function (response){
			self.events = response.data;
		});
			
	}]	
});


eventapp.
component("eventDetails",{
		templateUrl:'resources/js/eventDetails.html', 	
	controller : function detail(){
		this.event = sample;			
	}	
});


eventapp.
config(['$routeProvider',  function config($routeProvider){
		 
		$routeProvider.when('/',{
			template:'<event-list></event-list>'
				
		}).when('/events/:eventId',{
			template:'<event-details></event-details>'
		});
	}]);
	

	var sample={
			title:"Vaccination",
			place:"Bordeaux",
			date:"08/04/2017",
			hrDebut:"18h00",
			hrFin:"20h00"
		};
		
})();