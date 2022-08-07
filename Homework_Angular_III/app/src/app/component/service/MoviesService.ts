import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: `root` })
export class MoviesService {
  private movieDetails = new Subject<any>();

  constructor(private readonly _http: HttpClient) {}
  getStarWarsMovieDetails(): Observable<any[]> {
    return this._http.get('https://swapi.dev/api/films').pipe(
      map<any, any[]>((response) => {
        return response;
      })
    );
  }
}
