const pageTitle = document.createElement(`h1`);
let body = document.querySelector(`body`);
let pUserDetails = document.createElement(`p`);

let selectedUser = null;

const userDetails = JSON.parse(localStorage.getItem(`selectedUser`));

document.title = userDetails[`name`] + `, welcome to Endava intership 2022`;
pageTitle.innerText = document.title;

body.appendChild(pageTitle);
body.appendChild(pUserDetails);

fetch(`https://jsonplaceholder.typicode.com/users/${userDetails[`id`]}`)
  .then((response) => response.json())
  .then((data) => {
    selectedUser = data;

    pUserDetails.innerText = `- ${selectedUser[`name`]}, ${selectedUser[`username`]}, ${
      selectedUser[`address`][`street`]
    }, ${selectedUser[`address`][`suite`]}, ${selectedUser[`phone`]}, ${
      selectedUser[`company`][`name`]
    }`;
  })
  .catch((err) => {
    let errorMessage = document.createElement(`h2`);
    errorMessage.innerText = "Ooops something went wrong, please try again!";
    errorMessage.style.color = "red";
    body.removeChild(pageTitle);
    body.appendChild(errorMessage);
    console.log("Ooops something went wrong, please try again!");
  });
