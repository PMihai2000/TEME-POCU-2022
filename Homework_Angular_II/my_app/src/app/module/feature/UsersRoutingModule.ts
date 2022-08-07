import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { AddUsersFormComponent } from '../component/add-users-form/add-users-form.component';
import { UsersComponent } from '../component/users/users.component';

const routes: Routes = [
  { path: `add-new-user`, component: AddUsersFormComponent },
  { path: `edit-user/:idUser`, component: AddUsersFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UsersRoutingModule {}
