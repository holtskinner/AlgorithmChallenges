// Input:
// rev 1 <- good
// rev 2 <- good
//
// rev ? <- bad
// ...
// rev 499 <- bad
// rev 500 <- bad

function isBadRev(int rev){}//Returns true if it has a bug (expensive)
//Good-bad range of revisions
//bad > good initially
// int firstBadRev(int good, int bad) {
// }

//return index of first bad revision
function firstBadRev(good, bad) {

  var currentIndex = Math.floor((good + bad)/2);
  var highIndex = bad;
  var lowIndex = good;

  while (lowIndex == highIndex || lowIndex == (highIndex -1)) {

    if(isBadRev(currentIndex)) { //If current is bad, decrease index
      highIndex = currentIndex;
      currentIndex = Math.floor((lowIndex + currentIndex)/2);
    } else { //If current is good, go forward
      lowIndex = currentIndex;
      currentIndex = Math.floor((currentIndex + highIndex)/2);
    }
  }

  return highIndex;

}

//Binary search
//Find midway point between good and bad
//Plug in midway index into isBad
//if index is bad, repeat with floor of (good + index)/2
//else (bad + index)/2

//Base case ? bad == good??? return index
//O(log(n))
