import {Component, OnInit} from '@angular/core';
import {MovieService} from "../services/movie.service";
import {Router} from "@angular/router";
import {ResultsModel} from "../models/results.model";


@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit{

  movies!: ResultsModel


  constructor(private movieService: MovieService,
              private router : Router) {

  }

  ngOnInit(): void {

    this.loadMovies();
  }

  showMovieDetails(movieId: number) {
    console.warn(movieId);
    this.router.navigate(["/movieDetails/" , movieId])
  }

     loadMovies() {
      this.movieService.getAllMovies().subscribe({
        next: value => this.movies = value
      })
    }

}
