$(document).ready(function () {

	// Set up home page -------------------------------------------
	
		//Load DVDs from storage
		loadDVDs();
		
		//configure dropdown box
		configureDropDown();
	
	// Set up create page -----------------------------------------
	
		//Click createBtn to switch view
		$("#createBtn").on("click", viewCreateDVD)
		
		//Create button handler
		$("#createDVDButton").on("click", createDvd)
		
		//Cancel button
		$("#createCancelButton").on("click", cancelCreate)
	
})

function cancelCreate() {
	//clear form
	clearCreateForm();
		
	//return appearence to when page first loads
	$("#pageTopHome").show();
	
	loadDVDs();
	$("#pageBottomList").show();
	
	$("#pageTopCreateANDEdit").hide();

	$("#pageBottomCreateAndEdit").hide();	
	
}

function createDvd() {
	//check for form errors
    var haveValidationErrors = checkAndDisplayValidationErrors($('#add-form').find('input'));  //this

    //if errors, kill function
    if (haveValidationErrors) {
        return false;
    }
	
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/dvd",
		data: JSON.stringify({
			title: $("#inputCreateTitle").val(),
			releaseYear: $("#inputCreateYear").val(),
			director: $("#inputCreateDirector").val(),
			rating: $("#inputCreateRating").val(),
			notes: $("#inputCreateNotes").val()
		}),
		headers: {
			"Accept": "application/json",
			"Content-Type": "application/json"
		}, "dataType": "json",
		success: function(data, status) {
			//clear any error messages
			$("#errorMessages").empty();
			//clear form
			clearCreateForm();
					
			//return appearence to when page first loads
			$("#pageTopHome").show();
			
			loadDVDs();
			$("#pageBottomList").show();
			
			$("#pageTopCreateANDEdit").hide();

			$("#pageBottomCreateAndEdit").hide();
		},
		error: function() {
			$('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service.  Please try again later.'));
		}
	});
}

function clearCreateForm() {
	$("#inputCreateTitle").val("");
	$("#inputCreateYear").val("");
	$("#inputCreateDirector").val("");
	$("#inputCreateRating").val("");
	$("#inputCreateNotes").val("");
}

function loadDVDs() {
	//clear any contacts that are in the table
	clearTable();
	
	//grab the element to be modified
	var contentRows = $("#contentRows");
	
	$.ajax ({
		type: "GET",
		url: "http://localhost:8080/dvds",
		success: function (data, status) {
			$.each(data, function (index, dvd) {
				var dvdId = dvd.dvdId;
				var title = dvd.title;
				var releaseDate = dvd.releaseYear;
				var director = dvd.director;
				var rating = dvd.rating;
				
				var row = "<tr>";
				row += "<td>" + title + "</td>";
				row += "<td>" + releaseDate + "</td>";
				row += "<td>" + director + "</td>";
				row += "<td>" + rating + "</td>";
				row += "<td><a onclick='editDVD(" + dvdId + ")'>Edit</a> | <a onclick='deleteDVD(" + dvdId + ")'>Delete</a></td>";
				row += "</tr";
				
				contentRows.append(row);
			});
		},
		error: function () {
			$('#errorMessages')
                .append($('<li>')
                .attr({class: 'list-group-item list-group-item-danger'})
                .text('Error calling web service.  Please try again later.'));
		}
	});	
}

function clearTable() {
    $("#contentRows").empty();
}

function configureDropDown() {
	
	//clear whatever is in the dropdown box
	$("#searchDropdown").empty();
	
	//place default selection
	var defaultOption = '<option value="Default" disabled selected hidden>Search Category</option>';
	$("#searchDropdown").append(defaultOption);
	
	//place selections
	var dropdownSelections = '<option value="title">Title</option>';
		dropdownSelections += '<option value="releaseDate">Release Date</option>';
		dropdownSelections += '<option value="director">Director</option>';
		dropdownSelections += '<option value="rating">Rating</option>';

	$("#searchDropdown").append(dropdownSelections);	
}

function viewCreateDVD() {
	$("#pageTopHome").hide();
	$("#pageBottomList").hide();
	
	$("#pageTopCreateANDEdit").html(
		"<h1>Create DVD</h1>"
	);
	
	$("#inputCreateRating").
	$("#pageTopCreateANDEdit").removeClass("hidden");
	$("#pageTopCreateANDEdit").show();
	
	$("#createDVDButton").text("Create DVD");
	$("#pageBottomCreateAndEdit").removeClass("hidden");
	$("#pageBottomCreateAndEdit").show();
}

function checkAndDisplayValidationErrors(input) {
    //clear any error messages
    $('#errorMessages').empty();
	//create an array in which to hold errors
    var errorMessages = [];

    //loop through each input and check for validation errors
    input.each(function() {
        // Use the HTML5 validation API to find the validation errors
        if(!this.validity.valid)
        {
            var errorField = $('label[for='+this.id+']').text();
            errorMessages.push(errorField + ' ' + this.validationMessage);
        }
    });

    // put any error messages in the errorMessages div
    if (errorMessages.length > 0){
        $.each(errorMessages,function(index,message){
            $('#errorMessages').append($('<li>').attr({class: 'list-group-item list-group-item-danger'}).text(message));
        });
        // return true, indicating that there were errors
        return true;
    } else {
        // return false, indicating that there were no errors
        return false;
    }
}

function deleteDVD(movieId) {
    $.ajax ({
        type: 'DELETE',
        url: "http://localhost:8080/dvd/" + movieId,
        success: function (status) {
            loadDVDs();
        }
    });
}

function editDVD(movieID) {

}

