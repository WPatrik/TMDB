import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MovieDetailsModel} from "../models/movieDetails.model";
import {ResultsModel} from "../models/results.model";
import {CommentFormDataModel} from "../models/commentFormData.model";
import {Observable} from "rxjs";
const BASE_URL : string = "http://localhost:8080/api/movies"
const COMMENTS_BASE_URL = BASE_URL + '/api/comments';
const POSTS_BASE_URL = BASE_URL + '/api/movieDetails';
@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http : HttpClient) { }


  getMovieById(movieId: number) {
    return this.http.get<MovieDetailsModel>(BASE_URL + "/" + movieId)
  }

  getAllMovies() {
    return this.http.get<ResultsModel>(BASE_URL)
  }

  createComment(commentData: CommentFormDataModel): Observable<any> {
    return this.http.post(COMMENTS_BASE_URL, commentData);
  }

  fetchMovieDetails(id: number): Observable<MovieDetailsModel> {
    return this.http.get<MovieDetailsModel>(`${POSTS_BASE_URL}/${id}`)
  }
}
