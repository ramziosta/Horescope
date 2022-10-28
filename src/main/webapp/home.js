let currentUser = localStorage.getItem("currentUser");
currentUser = JSON.parse(currentUser);
console.log(currentUser);

let welcomeLabel = document.getElementById("welcome-label");
welcomeLabel.innerHTML = `Welcome ${currentUser.firstname}! Today holds a new adventure!`;
let username = document.getElementById("name");
username.innerHTML = currentUser.firstname + " " + currentUser.lastname;

const api_url = `http://sandipbgt.com/theastrologer/api/horoscope/${currentUser.horoscope}/today`;

async function getapi(url) {
    
  // Storing response
  const response = await fetch(url);
  
  // Storing data in form of JSON
  var data = await response.json();
  console.log(data);

  if(!response.ok){
    // throw new Error(response.status);
    alert(`Error Status: ${response.status}`)
}
  show(data);
}
// Calling that async function
getapi(api_url);

function show(data) {
  let sign = document.getElementById("sign");
  sign.innerHTML = data.sunsign;
  let mood = document.getElementById("mood");
  mood.innerHTML = data.meta.mood;
  let dailyHoroscope = document.getElementById("horoscope");
  dailyHoroscope.innerHTML = data.horoscope;
}

async function logout(){

  let email1 = currentUser.email;
  let password1 = currentUser.password;
  
  
  // creating an JSON Object using the inout from the user
  // note that the keys for our objects must match the 
  // fields in our Models in the backend
  
  let logoutInfo = {
      email: email1,
      password:password1
  }
  
  // turn our JSON object literal into JSON
  
  let json = JSON.stringify(logoutInfo);
  
  
  try {
  
      const raw_response = await fetch(`http://localhost:8082/logout`,{
          method:"PUT", // we hdd the http to be executed
          body:json
      });
  
      if(!raw_response.ok){
          throw new Error(raw_response.status)
      }
  
      raw_response.json().then( (data) => {
            this.currentUser = null;
            localStorage.clear();
          
      })
  
      setTimeout( ()=>{
          window.location.replace("index.html")
      }, 1000 )
  
  
  }catch(error){
      console.log(error)
  }
}




