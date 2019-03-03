<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//cdn.muicss.com/mui-0.9.41/css/mui.min.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.7.2/css/all.css">
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Raleway" />
<style>
.weather-app {
	font-family: Raleway !important;
}

.weather-app .header .app-logo img {
	height: 80px;
	width: 80px;
}

.weather-app .header .app-logo label {
	font-size: 30px;
	position: relative;
	top: 10px;
	left: 10px;
}

.weather-app .header .search {
	text-align: right;
	position: relative;
	top: 10px;
}

.weather-app .header input {
	width: 200px;
	height: 40px;
	border: none;
	border-bottom: 1px solid #d2d2d2;
	outline: none;
}

.weather-app .header button {
	background: linear-gradient(40deg, #45cafc, #303f9f) !important;
	color: #fff;
}

.weather-app .current-weather {
	text-align: center;
}

.weather-app .current-weather label {
	font-weight: 600;
	font-size: 12px;
	margin-bottom: 0px !important;
}

.weather-app .current-weather .values {
	font-size: 18px;
}

.weather-app .current-weather .name {
	font-size: 30px;
	color: #303f9f;
}

.weather-app #daily-chart, #hourly-chart {
	margin-top: 20px;
	text-align: center;
	box-shadow: 0 3px 5px -1px rgba(0, 0, 0, .2), 0 6px 10px 0
		rgba(0, 0, 0, .14), 0 1px 18px 0 rgba(0, 0, 0, .12) !important;
}

/* width */
::-webkit-scrollbar {
	width: 5px;
	height: 5px;
}

/* Track */
::-webkit-scrollbar-track {
	background: #f1f1f1;
}

/* Handle */
::-webkit-scrollbar-thumb {
	background: #888;
	border-radius: 40px;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
	background: #555;
}

.weather-app .footer {
	height: 50px;
}
</style>
</head>
<body bgcolor="black" class="weather-app">
	<div class="mui-container">
		<div class="row header">
			<div class="col-md-6">
				<div class="app-logo"></div>
			</div>
			<div class="col-md-6 search">
				<form action="/weather/controller/weatherDetails/city" method="get">
					<span>
					<input type="text" name="city">
					</span> 
					<span>
					<button type="submit" class="mui-btn"><i class="fa fa-search"></i>
						</button></span>
				</form>
			</div>
			<div class="error-message" style="height:25px; width: 100%">
				
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="current-weather"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div id="daily-chart"></div>
			</div>
			<div class="col-md-6">
				<div id="hourly-chart"></div>
			</div>
		</div>
		<div class="footer" id="footer"></div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="//cdn.muicss.com/mui-0.9.41/js/mui.min.js"></script>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/series-label.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script>
			var weatherData;
			var $Applogo = $('.app-logo'),
				$currentWeather = $('.current-weather');
			
			var $errorDiv = $('.error-message');
			
			var weather = {
				loadAppLogo: function(){
					let content = '';
					content += '<span><img style="width: 111px" src="http://estatecloud.co.ke/wp-content/uploads/2017/01/vector-clouds-png-KinejMzkT.png" /></span>'
					content += '<span><label>Weather</label></span>';
					$Applogo.append(content);
				},
				loadCurrentTemp: function(data){
					
					if(data.error)
					{
						var errorContent = '<div class="mui--bg-danger mui--text-white" align="center" >Error in fetching data, now displaying Current/Default Location</div>';
						$errorDiv.append(errorContent)
					}

					let content = '';
					content += '<div class="mui-container-fluid">';
					content += '<div class="mui-row">';
						content += '<div class="mui-col-md-3">';
					content += '<div class="name" align="left"">'+data.name+'</div>';
					content += '<div class="curTemp" align="center" style="margin-right:127px; font-size:30px">'+data.curTemp+'&#8457;</div>';
					content += '</div>';
					content += '<div class="mui-col-md-4"></div>';
					content += '<div class="mui-col-md-5">';
					
						content += '<div class="mui-row">';
							content += '<div class="mui-col-md-5">';
							var weather = data.weather;
							for (var i=0;i<weather.length;i++){
								var url = ''
								content += '<h5><img src="http://openweathermap.org/img/w/' + weather[i].icon + '.png">' + weather[i].main + '</h5>';
							}
					//content += '<div class="description">'+data.name+'</div>';
					content += '</div>';
						content += '<div class="mui-col-md-7">';
					content += '<div class="key"><label>Low - High</label></div>';
					content += '<div class="values">'+data.minTemp+'&#8457; - '+data.minTemp+'&#8457;</div>';
					content += '<div class="humidity"><label>Humidity: &nbsp;&nbsp;</label><span>'+data.humidity+'%</span></div>';
					content += '<div class="windSpeed"><label>Wind Speed: &nbsp;&nbsp;</label><span>'+data.windSpeed+'%</span></div>';
					content += '</div>';
					content += '</div>';
							content += '</div>';
								content += '</div>';
									content += '</div>';
					$currentWeather.append(content);
				},
				loadChart(id, name, data){
					let temperature = [],
						time = [];
					data.forEach(element => {
						temperature.push(element.temperature);
						time.push(element.time);
					});
					$(id).highcharts({
						chart: {
							type: 'spline'
						},
						title: {
							text: name+' Temperature'
						},
						subtitle: {
							text: 'Source: WorldClimate.com'
						},
						xAxis:{
							categories: time,
							title: {
								text: 'Time'
							}
						},
						yAxis: {
							title: {
								text: 'Temperature'
							},
							labels: {
								formatter: function () {
									return this.value + '°';
								}
							}
						},
						tooltip: {
							crosshairs: true,
							shared: true
						},
						plotOptions: {
							spline: {
								marker: {
									radius: 4,
									lineColor: '#666666',
									lineWidth: 1
								}
							}
						},
						series: [{
							marker: {
								symbol: 'square'
							},
							data: temperature

						}]
					});
				},
				async loadWeather(){
					var city = "<%=request.getAttribute("city")%>"
					
					return $.getJSON('/weather/rest/v1/weather?city='+city, function(data, textStatus, jqXHR){
						weatherData = data;
					})
				}
			}
			$(document).ready(function(){
				weather.loadAppLogo();
				weather.loadWeather().then(data =>{
					console.log('-----------------: ', data);
					weather.loadCurrentTemp(data);
					weather.loadChart('#daily-chart', 'Daily', data.daily);
					weather.loadChart('#hourly-chart', 'Hourly',data.hourly);
				})
			})
		</script>
</body>
</html>