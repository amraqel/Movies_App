package com.assignments.movies_app.Model;

import java.util.ArrayList;
import java.util.List;

public interface IMovieDa {

    List<Movie> getMovies(String genre);

    ArrayList<String> getGenres();

    List<Movie> searchForMovie(String title, int year , String genre);

}
