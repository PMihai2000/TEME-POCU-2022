import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { MoviesComponent } from './component/movies/movies.component';
import { MovieComponent } from './component/movie/movie.component';
import { MoviesService } from './component/service/MoviesService';

@NgModule({
  declarations: [AppComponent, MoviesComponent, MovieComponent],
  imports: [BrowserModule, HttpClientModule],
  providers: [MoviesService],
  bootstrap: [AppComponent],
})
export class AppModule {}
