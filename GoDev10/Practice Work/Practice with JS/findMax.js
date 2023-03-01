
var testArray = [900, 42, 311, 5, 9, 10, 28, 7, 6, 31];

/*
max = testArray[0];

for (var arrayPosition = 0; arrayPosition < testArray.length; arrayPosition++) {
	if (testArray[arrayPosition] > max) {
		max = testArray[arrayPosition];
	}
}

console.log(max);
*/




var max2 = Math.max.apply(null, testArray)
console.log(max2)

var whereMax2 = testArray.indexOf(Math.max.apply(null, testArray));
console.log(whereMax2)