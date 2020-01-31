//VARIABLES -------------------------------------------------------------
//Money entered thus far
var moneyIn = 0;

//Amount of change due
var numQ = 0;
var numD = 0;
var numN = 0;
var numP = 0;

//information about the item that is displayed in the selection box
var itemToPurchaseID;
var itemToPurchasePrice;
var itemToPurchaseIndex;

//parameter useful for calculating change
var didUserMakePurchase;



//BUISNESS LOGIC FUNCTIONS ------------------------------------------------
function displayMoney() {
	if (moneyIn == 0) {
		$("#form1text").text("0.00");
	}
	else {
		moneyToDisplay = parseFloat(moneyIn/100).toFixed(2);
		$("#form1text").text(moneyToDisplay);
	}
}

function concatenateAndPublishChange() {
	var stringToPrint = "";
			
	if (numQ > 1) {
		stringToPrint += numQ + " Quarters";
		if (numD > 1) {
			stringToPrint += ", " + numD + " Dimes";
		}
		if (numD == 1) {
			stringToPrint += ", " + numD + " Dime";
		}
		if (numN > 1) {
			stringToPrint += ", " + numN + " Nickels";
		}
		if (numN == 1) {
			stringToPrint += ", " + numN + " Nickel";
		}
		if (numP > 1) {
			stringToPrint += ", " + numP + " Pennies";
		}
		if (numP == 1) {
			stringToPrint += ", " + numP + " Penny";
		}
	}
	else if (numQ == 1) {
		stringToPrint += numQ + " Quarters";
		if (numD > 1) {
			stringToPrint += ", " + numD + " Dimes";
		}
		if (numD == 1) {
			stringToPrint += ", " + numD + " Dime";
		}
		if (numN > 1) {
			stringToPrint += ", " + numN + " Nickels";
		}
		if (numN == 1) {
			stringToPrint += ", " + numN + " Nickel";
		}
		if (numP > 1) {
			stringToPrint += ", " + numP + " Pennies";
		}
		if (numP == 1) {
			stringToPrint += ", " + numP + " Penny";
		}
	} 
	else {
		if (numD > 1) {
			stringToPrint += numD + " Dimes";
			if (numN > 1) {
			stringToPrint += ", " + numN + " Nickels";
			}
			if (numN == 1) {
			stringToPrint += ", " + numN + " Nickel";
			}
			if (numP > 1) {
				stringToPrint += ", " + numP + " Pennies";
			}
			if (numP == 1) {
				stringToPrint += ", " + numP + " Penny";
			}
		}
		else if (numD == 1) {
			stringToPrint += numD + " Dime";
			if (numN > 1) {
			stringToPrint += ", " + numN + " Nickels";
			}
			if (numN == 1) {
			stringToPrint += ", " + numN + " Nickel";
			}
			if (numP > 1) {
				stringToPrint += ", " + numP + " Pennies";
			}
			if (numP == 1) {
				stringToPrint += ", " + numP + " Penny";
			}
		}
		else {
			if (numN > 1) {
				stringToPrint += numN + " Nickels";
				if (numP > 1) {
					stringToPrint += ", " + numP + " Pennies";
				}
				if (numP == 1) {
					stringToPrint += ", " + numP + " Penny";
				}
			}
			else if (numN == 1) {
				stringToPrint += numN + " Nickel";
				if (numP > 1) {
					stringToPrint += ", " + numP + " Pennies";
				}
				if (numP == 1) {
					stringToPrint += ", " + numP + " Penny";
				}
			}
			else {
				if (numP > 1) {
					stringToPrint += numP + " Pennies";
				}
				if (numP == 1) {
					stringToPrint += numP + " Penny";
				}
			}			
		}
	}
			
	$("#form3text").text(stringToPrint);
}

function convertMoneyToCoins() {
	while(moneyIn >= 25) {
		numQ++;
		moneyIn -= 25;
	}
	while(moneyIn >= 10) {
		numD++;
		moneyIn -= 10;
	}
	while(moneyIn >= 5) {
		numN++;
		moneyIn -= 5;
	}
	while(moneyIn >= 1) {
		numP++;
		moneyIn -= 1;
	}
}

function getItem(myName, myId, price, indexToDisplay) {
	$("#form2itemDisplay").text(indexToDisplay);
	$("#form2text").text("");
	$("#form3text").text("");
	itemToPurchaseID = myId;
	itemToPurchasePrice = price;
	itemToPurchaseIndex = indexToDisplay;
}


//DOCUMENT READY -------------------------------------------------------
$(document).ready(function () {
	
	clearAllOutputs();
	
	loadAllItems();	
	
	//calculate/display money in -------------------------------------------		
	$("#addDollar").on("click", function() {
		moneyIn += 100;
		clearForm3text();
		displayMoney();
	});
	
	$("#addQuarter").on("click", function() {
		moneyIn += 25;
		clearForm3text();
		displayMoney();
	});
	
	$("#addDime").on("click", function() {
		moneyIn += 10;
		clearForm3text();
		displayMoney();
	});
		
	$("#addNickel").on("click", function() {
		moneyIn += 5;
		clearForm3text();
		displayMoney();
	});
	
	//calculate/display change -------------------------------------------
	$("#changeReturnButton").on("click", function() {
		clearAllOutputs();
		if (didUserMakePurchase == true) {
			concatenateAndPublishChange();
			
		}
		else {
			if (moneyIn == 0) {
				$("#form3text").text("No Change Due");
			}
			else {
				convertMoneyToCoins();
				concatenateAndPublishChange();
			}	
		}
		numQ = 0;
		numD = 0;
		numN = 0;
		numP = 0;
		displayMoney();
	});
	
	$("#makePurchaseButton").on("click", function(){
		var itemName = $("#form2itemDisplay").text();
		if (itemName === "") {
			$("#form2text").text("Please make a selection");
		}
		else {
			makePurchase(itemToPurchaseID, moneyIn, itemToPurchasePrice);
		}
	});	

}) //End document ready


	

//KNOWN GOOD STATE FUNCTIONS --------------------------------------------
function clearAllOutputs() {
	clearForm1text();
	clearForm2text();
	clearForm3text();
	clearForm2itemDisplay();
}

function clearForm1text() {
	var moneyToDisplay = parseFloat(moneyIn).toFixed(2);
	$("#form1text").text(moneyToDisplay);
}

function clearForm2text() {
	$("#form2text").text("");
}

function clearForm3text() {
	$("#form3text").text("");
}

function clearForm2itemDisplay() {
	$("#form2itemDisplay").text("");
}


//HTTP functions ----------------------------------------------------------------
function loadAllItems() {

	var flexBox = $("#flexBoxForItems");
	flexBox.empty();

	$.ajax ({
		type: "GET",
		url: "http://tsg-vending.herokuapp.com/items",
		success: function (data, status) {
			$.each(data, function (index, item) {
				var indexToDisplay = index + 1;
				var myId = item.id;
				var myName = item.name;
				var price = item.price;
				var priceToDisplay = parseFloat(price).toFixed(2)
				var quantity = item.quantity;

				var itemElement = "<div class='flex-item'>";
					itemElement += "<button onclick='getItem(\"" + myName + "\", " + myId + ", " + price + ", " + indexToDisplay + ")' type='button' class='vendingItem'>";
					itemElement += "<p class='itemIndex'>" + indexToDisplay + "</p>";
					itemElement += "<p class='itemName'>" + myName + "</p>";
					itemElement += "<p class='itemPriceTag'>$" + priceToDisplay + "</p>";
					itemElement += "<p>Quantity Left: " + quantity + "</p>";
					itemElement += "<p class='itemID'>Item ID: " + myId + "</p>";
					itemElement += "</button>";
					itemElement += "</div>";
						
				flexBox.append(itemElement);
				$(".itemID").hide();
			});
		},
		error: function() {
			$("#form2text").text("Error: Unable to call web server");
		}
	});
}

	
function makePurchase(itemID, amountEntered, price) {
	var usersMoney = amountEntered/100;
	$.ajax({
		type: "POST",
		url: "http://tsg-vending.herokuapp.com/money/" + usersMoney + "/item/" + itemID,
		success: function(data, status) {
			numQ += data.quarters;
			numD += data.dimes;
			numN += data.nickels;
			numP += data.pennies;
			$("#form2text").text("Thank You!!");
			moneyIn = 0;
			loadAllItems();
			concatenateAndPublishChange();
			numQ = 0;
			numD = 0;
			numN = 0;
			numP = 0;
			displayMoney();			
		},
		error: function(xhr, status, error) {
			var err = eval("(" + xhr.responseText + ")");
			loadAllItems();			
			$("#form2text").text(err.message);
		}
	});
}


