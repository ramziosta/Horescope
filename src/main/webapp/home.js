let currentUser = localStorage.getItem("currentUser");
currentUser = JSON.parse(currentUser);
console.log(currentUser);

let welcomeLabel = document.getElementById("welcome-label");
welcomeLabel.innerHTML = `Welcome ${currentUser.firstname}! Submit a new Reimbursiment ticket!`;

let submitButton = document.getElementById("submit-button");

submitButton.addEventListener("click", async (event) => {
  event.preventDefault();

  let amountText = document.getElementById("amount").value;
  let descriptionText = document.getElementById("description").value;
  let employeeId = document.getElementById("employeeId").value;

  // console.log(`amount: ${amountText} - description: ${descriptionText}`)

  let ticketObject = {
    amount: amountText,
    description: descriptionText,
    employee_id: employeeId,
  };

  let json = JSON.stringify(ticketObject);

  try {
    let response = await fetch(`http://localhost:8081/ticket`, {
      method: "POST",
      body: json,
    });

    if (!response.ok) {
      throw new Error(response.status);
    }

    alert("You're ticket was created!");
    let amountBox = document.getElementById("amount");
    amountBox.value = "";
    let descriptionBox = document.getElementById("description");
    descriptionBox.value = "";
  } catch (error) {
    console.log(error);
  }
});

let viewAllButton = document.getElementById("view-all");
viewAllButton.addEventListener("click", async (event) => {
  event.preventDefault();

  try {
    // fetch send a get request by default unless directed to do otherwise
    let response = await fetch(`http://localhost:8081/tickets`);

    if (!response.ok) {
      throw new Error(response.status);
    }

    response.json().then((data) => {
      // create a helper function that will use the json data from the request to manipulate the dom
      // console.log(data); print the array we get back from our http request

      addTicketsToPage(data);
      console.log(data);
    });
  } catch (error) {
    console.log(error);
  }
});

function addTicketsToPage(ticketsArray) {
  let ticketButtonP = document.getElementById("ticket-button");

  let br = document.createElement("br");

  ticketButtonP.append(br);
  ticketButtonP.append(br);

  for (let ticket of ticketsArray) {
    let ticketElement = document.createElement("h3");
    ticketElement.innerHTML = `amount: ${ticket.amount} - description: ${ticket.description}, created by ${ticket.employee_id}`;
    ticketButtonP.appendChild(ticketElement);
  }
}
