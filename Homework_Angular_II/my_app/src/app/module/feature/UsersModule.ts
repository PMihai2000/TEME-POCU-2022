import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddUsersFormComponent } from '../component/add-users-form/add-users-form.component';
import { UsersComponent } from '../component/users/users.component';
import { UsersRoutingModule } from './UsersRoutingModule';

@NgModule({
  declarations: [UsersComponent, AddUsersFormComponent],
  imports: [CommonModule, FormsModule, UsersRoutingModule, ReactiveFormsModule],
  exports: [UsersComponent, AddUsersFormComponent],
})
export class UsersModule {}
