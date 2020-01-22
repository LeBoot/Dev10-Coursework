$(document).ready(function () {
    $("h1, h2").css('text-align', 'center');
	$(".myBannerHeading").addClass('page-header'); /*IDK if this is correct*/
	$("#yellowHeading").text("Yellow Team");
	$("#orangeTeamList").css('background-color', 'orange');
	$("#blueTeamList").css('background-color', 'blue');
	$("#redTeamList").css('background-color', 'red');
	$("#yellowTeamList").css('background-color', 'yellow');
	$("#yellowTeamList").append("<li>Joseph Banks</li><li>Simon Jones</li>");
	$("#oops").hide();
	$("#footer").remove();
	
	$("body").append('<footer id="footer"></footer>');
	$("#footer").html("<p>Ben LeBoot | brlebout@email.com</p>");
	$("#footer").css({"font-family" : "courier" , "height" : "24px"})
	
});