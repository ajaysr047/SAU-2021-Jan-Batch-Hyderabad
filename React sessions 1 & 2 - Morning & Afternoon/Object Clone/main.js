// How to clone Objects in Js

const demoObject = {
  one: '1',
  two: '2',
  three: '3',
  four: '4',
  five: '5'
}

// Won't work - reference is copied
const wontWorkCopy = demoObject;

// Way 1

const way1 = {...demoObject};

// Way 2

const way2 = Object.assign({}, demoObject);

// Way 3

const way3 = JSON.parse(JSON.stringify(demoObject));
