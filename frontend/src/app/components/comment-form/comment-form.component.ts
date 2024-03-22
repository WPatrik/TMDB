import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Input} from "postcss";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MovieService} from "../../services/movie.service";

@Component({
  selector: 'app-comment-form',
  templateUrl: './comment-form.component.html',
  styleUrls: ['./comment-form.component.css']
})
export class CommentFormComponent implements OnInit {

  movieId: number | undefined;
  commentCreated = new EventEmitter();
  commentForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private movieService: MovieService) {
    this.commentForm = formBuilder.group({
        author: [''],
        commentBody: ['', Validators.required]
      }
    )
  }

  ngOnInit() {
  }

  onSubmit() {
    const commentData = {...this.commentForm.value};
    commentData.author = commentData.author == null ? '' : commentData.author;
    commentData.movieId = this.movieId;
    this.movieService.createComment(commentData).subscribe(
      () => {
        this.commentForm.reset();
        this.commentCreated.emit();
      }
    )
  }
}
