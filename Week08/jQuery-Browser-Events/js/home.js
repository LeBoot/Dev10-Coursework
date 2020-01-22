$(document).ready(function () {
	$("#akronInfoDiv").hide();
	$("#minneapolisInfoDiv").hide();
	$("#louisvilleInfoDiv").hide();
});

$("#akronButton").on("click", function() {
	$("#mainInfoDiv").hide();
	$("#minneapolisInfoDiv").hide();
	$("#louisvilleInfoDiv").hide();
	$("#akronInfoDiv").show();
	$("#akronWeather").hide();
});

$("#minneapolisButton").on("click", function() {
	$("#mainInfoDiv").hide();
	$("#akronInfoDiv").hide();
	$("#louisvilleInfoDiv").hide();
	$("#minneapolisInfoDiv").show();
	$("#minneapolisWeather").hide();
});

$("#louisvilleButton").on("click", function() {
	$("#mainInfoDiv").hide();
	$("#akronInfoDiv").hide();
	$("#minneapolisInfoDiv").hide();
	$("#louisvilleInfoDiv").show();
	$("#louisvilleWeather").hide();
});

$("#mainButton").on("click", function() {
	$("#mainInfoDiv").show();
	$("#akronInfoDiv").hide();
	$("#minneapolisInfoDiv").hide();
	$("#louisvilleInfoDiv").hide();
});

$("#akronWeatherButton").on("click", function() {
	$("#akronWeather").toggle();
});

$("#minneapolisWeatherButton").on("click", function() {
	$("#minneapolisWeather").toggle();
});

$("#louisvilleWeatherButton").on("click", function() {
	$("#louisvilleWeather").toggle();
});

$("tr").hover(
	function() {
		$(this).css("background-color", "whiteSmoke");
	},
	function() {
		$(this).css("background-color", "");
	}
);

$("tr:first-Child").hover(
	function() {
		$(this).css("background-color", "");
	},
	function() {
		$(this).css("background-color", "");
	}
);





