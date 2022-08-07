import { JSDocComment } from '@angular/compiler';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {
  ActivatedRoute,
  NavigationStart,
  Router,
  Routes,
} from '@angular/router';
import { User } from '../../model/user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent implements OnInit {
  users: User[] = [];

  constructor(private router: Router) {}

  ngOnInit(): void {
    let users = localStorage.getItem(`users`);

    if (users === null) {
      fetch('https://jsonplaceholder.typicode.com/users')
        .then((response) => response.json())
        .then((data) => {
          users = data;
          if (users != null) {
            for (const user of users) {
              let fullname: string[] = JSON.parse(JSON.stringify(user))[
                `name`
              ].split(` `);

              this.users.push({
                id: JSON.parse(JSON.stringify(user))[`id`],
                nume: fullname[0],
                prenume: fullname[1],
                varsta: Math.floor(Math.random() * 18 + 18),
              });
            }
          }
          localStorage.setItem(`users`, JSON.stringify(this.users));
        })
        .catch((err) => {
          console.log('Error. ' + err);
        });
    } else {
      this.users = JSON.parse(users);
    }
  }

  addNewUser(event: Event) {
    this.router.navigate(['add-new-user']);
  }

  editUser(event: Event) {
    const strId: string = (
      event.target as HTMLElement
    ).parentElement?.parentElement?.getElementsByTagName(`td`)[0]
      .innerText as string;

    if (strId !== undefined) {
      const id: Number = Number.parseInt(strId);
      this.router.navigate(['edit-user', id]);
    }
  }

  deleteUser(event: Event) {
    const strId: string = (
      event.target as HTMLElement
    ).parentElement?.parentElement?.getElementsByTagName(`td`)[0]
      .innerText as string;

    if (strId !== undefined) {
      const id: Number = Number.parseInt(strId);
      this.users = this.users.filter((u) => u.id !== id);
      this.updateUsersLocalStorage();
    }
  }

  updateUsersLocalStorage() {
    localStorage.setItem('users', JSON.stringify(this.users));
    if (this.users.length === 0) {
      localStorage.removeItem(`users`);
    }
  }
}
