// Write a unary function addF which accepts 1 param:
// • x - number
// and returns another unary function with which, when called, returns the sum between it's param and x.

let add = addF(13);
console.log(add(10)); // 23
console.log(add(-5)); // 8

function addF(x) {
  if (!isNaN(x)) {
    const NUMBER = x;

    return function (value) {
      return NUMBER + value;
    };
  } else {
    return function (value) {
      return `Error. In function addF(x), the parameter 'x' must be a number!`;
    };
  }
}
