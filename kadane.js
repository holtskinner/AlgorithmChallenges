function kadane(array) {
  
  var maxCurrent = array[0];
  var maxGlobal = array[0];

  for (var i = 1; i < array.length; i++) {
    maxCurrent = Math.max(array[i], (maxCurrent + array[i]));
    maxCurrent = Math.max(maxCurrent, maxGlobal);
  }

  return maxGlobal;
}
