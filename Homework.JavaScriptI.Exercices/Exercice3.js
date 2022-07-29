// Write a limit function with 2 params:
// • fn - a function
// • max - number
// and returns another function which behaves just like fn but can be called just max number of times. After that it will return undefined.

let limitAdd = limit(add, 2);

console.log(limitAdd(3, 5)); // 8
console.log(limitAdd(11, 23)); //34
console.log(limitAdd(5, 10)); // undefined

function add(x, y) {
  return x + y;
}

function limit(fn, max) {
  if (typeof fn === "function" && !isNaN(max)) {
    let calls = 0;
    let max_calls = max;
    let current_function = fn;

    return function (x, y) {
      if (calls < max_calls) {
        calls++;
        return current_function(x, y);
      } else {
        return undefined;
      }
    };
  } else {
    return function (value) {
      return `Error. In function limit(fn,max), the parameter 'fn' must be a function
      and the parameter 'max' must be a number!`;
    };
  }
}
