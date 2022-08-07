import { Component, OnDestroy, OnInit } from '@angular/core';
import { Data } from '@angular/router';
import { Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { Movie } from 'src/app/model/movie';
import { MoviesService } from '../service/MoviesService';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css'],
})
export class MoviesComponent implements OnInit, OnDestroy {
  movies: any = [];
  unsubscribe$: Subject<void>;
  constructor(private readonly moviesService: MoviesService) {
    this.unsubscribe$ = new Subject<void>();
  }
  ngOnDestroy(): void {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  ngOnInit(): void {
    this.moviesService.getStarWarsMovieDetails().subscribe((movies) => {
      console.log(movies);
      let moviesResults = JSON.parse(JSON.stringify(movies))[`results`];

      for (const movie of moviesResults) {
        this.movies.push({
          title: movie[`title`],
          description: (movie[`opening_crawl`] as string).slice(0, 150) + `...`,
          episodeId: movie[`episode_id`],
        });
      }
    });
  }
}
