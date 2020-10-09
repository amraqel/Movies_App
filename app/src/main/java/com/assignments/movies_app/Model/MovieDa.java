package com.assignments.movies_app.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class MovieDa implements IMovieDa {

    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieDa(){

        movies.add( new Movie("The Godfather",1972,"Drama","the_godfather") );
        movies.add( new Movie("The Dark Knight",2008,"Action","the_dark_knight") );
        movies.add( new Movie("Toy Story",1995,"Animation","toy_story") );
        movies.add( new Movie("The Shawshank Redumption",1994,"Drama","shawshank_redumption") );

    }

    @Override
    public List<Movie> getMovies(String genre) {

        ArrayList<Movie> data = new ArrayList<>();

        for(Movie movie : movies){

            if(movie.getGenre().equals(genre))
                data.add(movie);

        }

        return data;
    }

    @Override
    public ArrayList<String> getGenres() {

        ArrayList<String> genres = new ArrayList<>();

        for (Movie movie : movies){

            if(!genres.contains(movie.getGenre()))
                genres.add(movie.getGenre());

        }

        return genres;
    }

    @Override
    public List<Movie> searchForMovie(String title, int year, String genre) {

        ArrayList<Movie> data = new ArrayList<>();

        for(Movie movie : movies){

            if( ( title.length()>1 && containsTitle(title,movie.getTitle()) ) ||
                    (genre.length() != 0 && movie.getGenre().equals(genre) )||
                    (year!=-1 && movie.getYear() == year) )
                data.add(movie);
        }

        return data;

    }

    private boolean containsTitle(String input, String movieTitle) {
        input = input.toLowerCase();
        movieTitle = movieTitle.toLowerCase();

        if(movieTitle.contains(input))
            return true;

        return false;

    }

}
