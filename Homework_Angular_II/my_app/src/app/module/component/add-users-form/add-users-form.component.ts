import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../model/user';

@Component({
  selector: 'app-add-users-form',
  templateUrl: './add-users-form.component.html',
  styleUrls: ['./add-users-form.component.css'],
})
export class AddUsersFormComponent implements OnInit {
  idUser: number = -1;
  users: User[] = [];
  userToBeUpdated: User | undefined;

  userForm = new FormGroup({
    nume: new FormControl(``, [Validators.required, Validators.minLength(3)]),
    prenume: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
    ]),
    varsta: new FormControl('', [
      Validators.required,
      Validators.min(1),
      Validators.max(100),
    ]),
  });

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.route.paramMap.forEach((p) => {
      this.idUser = Number.parseInt(p.get(`idUser`)!);
    });

    let usersString = localStorage.getItem(`users`);
    if (usersString !== undefined) {
      this.users = JSON.parse(usersString!);
    }

    if (!Number.isNaN(this.idUser)) {
      this.users
        .filter((user) => user.id === this.idUser)
        .forEach((user) => {
          this.userToBeUpdated = {
            id: user.id,
            nume: user.nume,
            prenume: user.prenume,
            varsta: user.varsta,
          };
        });

      if (this.userToBeUpdated !== undefined) {
        this.userForm.get([`id`])?.setValue(this.userToBeUpdated.id);
        this.userForm.get([`nume`])?.setValue(this.userToBeUpdated.nume);
        this.userForm.get([`prenume`])?.setValue(this.userToBeUpdated.prenume);
        this.userForm.get([`varsta`])?.setValue(this.userToBeUpdated.varsta);
      }
    }
  }
  submitData() {
    if (this.userForm.valid) {
      if (Number.isNaN(this.idUser)) {
        this.addUser();
      } else {
        this.editUser();
      }
      this.router.navigate(['users']);
    }
  }

  addUser() {
    this.idUser = -1;
    this.users.forEach((u) => {
      if (this.idUser < u.id) {
        this.idUser = u.id;
      }
    });
    this.idUser++;

    const newUser: User = {
      id: this.idUser,
      nume: this.userForm.get([`nume`])?.value,
      prenume: this.userForm.get([`prenume`])?.value,
      varsta: this.userForm.get([`varsta`])!.value,
    };
    this.users.push(newUser);
    localStorage.setItem(`users`, JSON.stringify(this.users));
    console.log(newUser);
  }

  editUser() {
    for (const user of this.users) {
      if (user.id === this.idUser) {
        user.nume = this.userForm.get([`nume`])?.value;
        user.prenume = this.userForm.get([`prenume`])?.value;
        user.varsta = this.userForm.get([`varsta`])?.value;
      }
    }

    localStorage.setItem(`users`, JSON.stringify(this.users));
  }
  cancelRequest() {
    this.router.navigate(['users']);
  }
}
