$(document).ready(function() {
$.ajax({
  url: "http://localhost:8080/api/dashboard/statistics", //dummy server
  method: "GET", //dummy server requires GET not POST
  datatype: "json",
  success: function(data) {
    Morris.Line({
      element: 'bar-example',
      data: [
	  {"y":"Jan","item1":data.count_janSum},
      {"y":"Feb","item1":data.count_febSum},
      {"y":"Mar","item1":data.count_marSum},
      {"y":"Apr","item1":data.count_aprSum},
      {"y":"May","item1":data.count_maySum},
      {"y":"Jun","item1":data.count_junSum},
      {"y":"Jul","item1":data.count_julSum},
      {"y":"Aug","item1":data.count_augSum},
      {"y":"Sep","item1":data.count_sepSum},
      {"y":"Oct","item1":data.count_octSum},
      {"y":"Nov","item1":data.count_novSum},
      {"y":"Dec","item1":data.count_decSum}],
      xkey: 'y',
      ykeys: ['item1'],
      labels: ['Earnings'],
      hideHover: 'auto',
      pointStrokeColors: ['white'],
      lineWidth: '6px',
      parseTime: false,
      lineColors: ['SkyBlue', 'Pink'],
    });
    
    Morris.Line({
      element: 'orders',
      data: [
	  {"y":"Jan","item1":data.janOrder},
      {"y":"Feb","item1":data.febOrder},
      {"y":"Mar","item1":data.marOrder},
      {"y":"Apr","item1":data.aprOrder},
      {"y":"May","item1":data.mayOrder},
      {"y":"Jun","item1":data.junOrder},
      {"y":"Jul","item1":data.julOrder},
      {"y":"Aug","item1":data.augOrder},
      {"y":"Sep","item1":data.sepOrder},
      {"y":"Oct","item1":data.octOrder},
      {"y":"Nov","item1":data.novOrder},
      {"y":"Dec","item1":data.decOrder}],
      xkey: 'y',
      ykeys: ['item1'],
      labels: ['Orders'],
      hideHover: 'auto',
      pointStrokeColors: ['white'],
      lineWidth: '6px',
      parseTime: false,
      lineColors: ['#605ca8', 'Pink'],
    });
  }

});
})