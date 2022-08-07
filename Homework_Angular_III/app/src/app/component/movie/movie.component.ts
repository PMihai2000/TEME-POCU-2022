import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css'],
})
export class MovieComponent implements OnInit {
  @Input() title: string = ``;
  @Input() description: string = ``;
  @Input() episodeId: number = 0;
  constructor() {}

  ngOnInit(): void {}

  routeToMoreDetails() {
    document.location = `https://swapi.dev/api/films/${this.episodeId}`;
  }
}
