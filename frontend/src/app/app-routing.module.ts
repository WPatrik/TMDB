import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NgClass, NgIf} from "@angular/common";
import {MovieListComponent} from "./movie-list/movie-list.component";
import {MovieDetailsComponent} from "./components/movie-details/movie-details.component";

const routes: Routes = [
  {path:'', component:MovieListComponent},
  {path: 'movieList', component: MovieListComponent},
  {path:'movieDetails/:id', component: MovieDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), NgClass, NgIf],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
