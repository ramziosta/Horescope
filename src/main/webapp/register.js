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

  let birthday = document.getElementById("birthday").value;
  console.log(birthday);
  let horoscope = document.getElementById("horoscope").value;

  let registerationInfo = {
    firstname: firstname,
    lastname: lastname,
    email: email,
    password: password,
    birthday: birthday,
    horoscope: horoscope,
  };

  let json = JSON.stringify(registerationInfo);

  try {
    const raw_response = await fetch(`http://localhost:8082/horoscope`, {
      method: "POST",
      body: json,
    });

    if (!raw_response.ok) {
      throw new Error(raw_response.status);
    }

    alert("User was created!");
    let firstnameBox = document.getElementById("firstname");
    firstnameBox.value = "";
    let lastnameBox = document.getElementById("lastname");
    lastnameBox.value = "";
    let emailBox = document.getElementById("email");
    emailBox.value = "";
    let passwordBox = document.getElementById("password");
    passwordBox.value = "";
    let birthdayBox = document.getElementById("birthday");
    birthdayBox.value = "";
    let horoscopeBox = document.getElementById("horoscope");
    horoscopeBox.value = "";

    setTimeout(() => {
      window.location.replace("home.html");
    }, 3000);
  } catch (err) {
    console.log(err);
  }
});
