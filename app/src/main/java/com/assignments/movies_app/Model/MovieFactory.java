package com.assignments.movies_app.Model;

public class MovieFactory {

    public IMovieDa getModel(){

        return new MovieDa();
    }
}
