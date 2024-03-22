import {Component, OnInit} from '@angular/core';
import {MovieDetailsModel} from "../../models/movieDetails.model";
import {ActivatedRoute} from "@angular/router";
import {MovieService} from "../../services/movie.service";
import {FormGroup} from "@angular/forms";
import {CommentFormDataModel} from "../../models/commentFormData.model";


@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  movie!: MovieDetailsModel
  movieId!: number
  commentForm!: FormGroup;

  constructor(private route : ActivatedRoute, private movieService: MovieService) {
    this.route.paramMap.subscribe({next :value =>
      {this.movieId = Number(value.get("id")
      )
      }
    }
    )
  }

  ngOnInit(): void {
    this.movieService.getMovieById(this.movieId).subscribe({
      next : value => {
        this.movie = value;
      }
    })
  }

  createComment() {
    const data: CommentFormDataModel = {
      commentBody: this.commentForm.value.commentBody,
      postId: this.movieId}
    console.log(data);
    this.movieService.createComment(data).subscribe({
      next: () => {
        this.loadMovieDetails();
        this.commentForm.reset();
      },
      error: error => console.warn(error)
    })
  }

  loadMovieDetails() {
    this.movieService.fetchMovieDetails(this.movieId).subscribe({
      next: (data: MovieDetailsModel) => this.movie = data,
      error: error => console.warn(error)
    });
  }
}
