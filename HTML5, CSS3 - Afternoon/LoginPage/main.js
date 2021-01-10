let loginButton = document.getElementById("login");

let loginFunc = () => {
    let email = document.getElementById("email").value;
    let pass = document.getElementById("pass").value;

    if(email === "demo@gmail.com" && pass == "123")
    {
        localStorage.setItem("email", email);
        alert("Dummy Login success!!, Email stored locally");
    }
    else
        alert("Dummy Login failed!!");
  }