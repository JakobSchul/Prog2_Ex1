package at.ac.fhcampuswien.fhmdb.models;

import java.util.Arrays;
import java.util.List;


public class Movie {

    public String title;
    private final String description;

    // private String genre;

    public List<String> genreList = Arrays.asList("Action", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY",
            "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR",
            "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR",
            "WESTERN");

//    public List<String> getGenreList() {
//        return genreList;
//    }

    public Movie(String title, String description, List genreList) {
        this.title = title;
        this.description = description;


    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


}
