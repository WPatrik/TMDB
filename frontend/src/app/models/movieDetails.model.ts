import {CommentDetailsModel} from "./commentDetails.model";

export interface MovieDetailsModel{

  id: number
  title: string
  poster_path: string
  actor: string
  release_date: number
  studio: string
  original_language: string
  overview: string
  comments: Array<CommentDetailsModel>;

}
