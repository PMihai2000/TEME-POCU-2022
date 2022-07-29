// Write the getStats(arr) function which receives an Array as a parameter and prints a message regarding the types of elements found inside it.

var arr = [
  1,
  2,
  "hello",
  NaN,
  {city: "IasI", zip: null},
  [11, 12],
  undefined,
  undefined,
  undefined,
];
getStats(arr); // 2 numbers, 1 string, 1 NaN, 1 Object, 1 Array, 3 undefined

function getStats(array) {
  let stats = [];
  for (const value of arr) {
    if (stats[`${typeof value}`] === undefined) {
      stats[`${typeof value}`] = 0;
    }
    stats[`${typeof value}`] += 1;
  }
  let message = "";
  for (const value in stats) {
    message += `${value} ${stats[value]}, `;
  }

  console.log(message.substring(0, message.length - 2));
}
