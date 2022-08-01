let pageTitle = document.createElement(`h1`);
let users = localStorage.getItem(`users`);

let body = document.querySelector("body");

let ul = document.createElement(`ul`);

let divUserDetails = document.createElement(`div`);
let labelDivUserDetails = document.createElement(`label`);
let inputDivUserDetails = document.createElement(`input`);
let buttonDivUserDetails = document.createElement(`button`);

let lastUserSelected = null;
let oldName = null;

document.title = `Welcome to Endava Intership 2022`;
pageTitle.innerText = document.title;

labelDivUserDetails.innerText = `Edit your name: `;
buttonDivUserDetails.innerText = `apply`;
divUserDetails.hidden = true;

buttonDivUserDetails.addEventListener(`click`, onClickApplyButton);

body.appendChild(pageTitle);
body.appendChild(ul);
body.appendChild(divUserDetails);
divUserDetails.appendChild(labelDivUserDetails);
divUserDetails.appendChild(inputDivUserDetails);
divUserDetails.appendChild(buttonDivUserDetails);

if (users === null) {
  fetch("https://jsonplaceholder.typicode.com/users")
    .then((response) => response.json())
    .then((data) => {
      localStorage.setItem(`users`, JSON.stringify(data));
    })
    .catch((err) => {
      console.log("Error");
    });
} else {
  users = JSON.parse(users);
  loadUsers();
}

function loadUsers() {
  for (const user of users) {
    ul.appendChild(createLi(user));
  }
}

function clearUsers() {
  while (ul.firstChild) {
    ul.removeChild(ul.firstChild);
  }
}

function createLi(user) {
  let li = document.createElement(`li`);
  let buttonDetails = document.createElement(`button`);

  li.innerHTML = `${user["id"] * 2}, ${user["username"]} (${user["name"]}) ${user["email"]} `;
  li.appendChild(buttonDetails);

  buttonDetails.innerText = `${user["username"]} Details`;

  buttonDetails.addEventListener(`click`, onClickOnUserButtonDetails);

  li.addEventListener(`click`, onClickOnUser);

  return li;
}

function onClickOnUserButtonDetails(event) {
  event.stopPropagation();
  let target = event.target.parentElement;
  let idUser = Number.parseInt(target.innerText.split(`,`)[0]) / 2;
  oldName = target.innerText.split(`(`)[1].split(`)`)[0].trim();

  localStorage.setItem(`selectedUser`, JSON.stringify({id: idUser, name: oldName}));
  document.location = `/page2.html`;
}

function onClickOnUser(event) {
  let target = event.target;
  oldName = target.innerText.split(`(`)[1].split(`)`)[0].trim();
  inputDivUserDetails.value = `${oldName}`;
  lastUserSelected = target;
  divUserDetails.hidden = false;
}

function onClickApplyButton(event) {
  const newName = inputDivUserDetails.value;
  for (const user of users) {
    if (user[`name`] === oldName) {
      user[`name`] = newName;
      clearUsers();
      loadUsers();
      updateUsers();
      divUserDetails.hidden = true;
      break;
    }
  }
}

function updateUsers() {
  localStorage.setItem(`users`, JSON.stringify(users));
}
