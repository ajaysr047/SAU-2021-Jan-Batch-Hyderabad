// Implement a custom reduce function

const intArray = [1, 2, 3, 4, 5, 6];

let customReduce = (array, reduceFunc, initialValue) => {
    let result = initialValue || 0;
    for(let e of array)
        result = reduceFunc(result, e);
    return result;
}

let result = customReduce(intArray, (acc, value) => acc + value, 0);

console.log(result);

let t = intArray.reduce((acc, value) => acc + value, 0);
console.log(t);
