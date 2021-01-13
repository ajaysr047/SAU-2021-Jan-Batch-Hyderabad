
let result = document.getElementById("num3");
result.disabled = true;

let add = () =>{
    let firstNumber = parseFloat(document.getElementById("num1").value);
    let secondNumber = parseFloat(document.getElementById("num2").value);
    
    console.log(firstNumber)
    if(Number.isNaN(firstNumber) || Number.isNaN(secondNumber) )
    {
        alert('Enter valid number');
        return;
    }

    // result.disabled = false;
    result.value = firstNumber + secondNumber;
    
}