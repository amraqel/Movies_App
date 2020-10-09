package com.assignments.movies_app.Model;

import java.io.File;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String img;

    public Movie() {
    }

    public Movie(String title, int year, String genre, String img) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.img = img;
    }

    public void setImg(String imgPath) {
        this.img = imgPath;
    }

    public String getImg() {
        return img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }


}
