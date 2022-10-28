let backButton = document.getElementById("back-button");

backButton.addEventListener("click", (event) => {
  event.preventDefault();
  window.location.replace("index.html");
});

let registerButton = document.getElementById("register");

registerButton.addEventListener("click", async (event) => {
  event.preventDefault();
  let firstname = document.getElementById("firstname").value;

  let lastname = document.getElementById("lastname").value;

  let email = document.getElementById("email").value;

  let password = document.getElementById("password").value;

  let horoscope = document.getElementById("horoscope").value;

  let birthday = document.getElementById("birthday").value;
  console.log(birthday);


  let registerationInfo = {
    firstname: firstname,
    lastname: lastname,
    email: email,
    password: password,
    horoscope: horoscope,
    birthday: birthday,
  };

  let json = JSON.stringify(registerationInfo);

  try {
    const raw_response = await fetch(`http://localhost:8082/user`, {
      method: "POST",
      body: json,
    });

    if (!raw_response.ok) {
      throw new Error(raw_response.status);
    }

    alert("User was created!");
    let firstname = document.getElementById("firstname");
    firstname.value = "";
    let lastname = document.getElementById("lastname");
    lastname.value = "";
    let email = document.getElementById("email");
    email.value = "";
    let password = document.getElementById("password");
    password.value = "";
    let horoscope = document.getElementById("horoscope");
    horoscope.value = "";
    let birthday = document.getElementById("birthday");
    birthday.value = "";

    setTimeout(() => {
      window.location.replace("index.html");
    }, 1000);
  } catch (err) {
    console.log(err);
  }
});
