package at.ac.fhcampuswien.fhmdb.models;

import java.util.Arrays;

import java.util.ArrayList;


import java.util.List;


public class Movie {

    public String title;
    private String description;
    private List<String> genreList;

    public Movie(String title, String description, List<String> genreList) {
        this.title = title;
        this.description = description;
        this.genreList = genreList;
    }

    public Movie() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }




    public static List<Movie> initializeMovies() {
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here

        return movies;
    }
    public List<String> getGenreList () {
        return genreList;
    }

    public String getGenreStrings () {
        return getGenreList().toString();
    }

    public void setTitle (String title){
        this.title = title;
    }




    public boolean compareTitle (String ser){
        return title.toLowerCase().contains(ser);
    }
    public boolean compareDescription (String ser){
        return description.toLowerCase().contains(ser);

    }
    public boolean compareGenreStrings (String ser){
        return getGenreStrings().toLowerCase().contains(ser);
//                description.toLowerCase().contains(ser);

//        System.out.println(ser);
    }
    public void setDescription(String description) {
        this.description = description;
    }



}
