import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './module/component/users/users.component';
import { UsersModule } from './module/feature/UsersModule';
import { AddUsersFormComponent } from './module/component/add-users-form/add-users-form.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UsersModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      { path: `users`, component: UsersComponent },
      { path: `users/:idUser`, component: UsersComponent },
      {
        path: `users`,
        loadChildren: () =>
          import(`src/app/module/feature/UsersModule`).then(
            (u) => u.UsersModule
          ),
      },
    ]),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
