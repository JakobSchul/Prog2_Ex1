package at.ac.fhcampuswien.fhmdb.models;

import java.util.Arrays;
import java.util.List;


public class Movie {

    public String title;
    private final String description;
    private final List<String> genreList;
    // private String genre;

    public List<String> genresList = Arrays.asList("ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY",
            "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR",
            "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR",
            "WESTERN");



    public Movie(String title, String description, List<String> genreList) {
        this.title = title;
        this.description = description;
        this.genreList = genreList;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public List<String> getGenreList(){
        return genreList;
    }

    public String getGenreStrings(){
        return getGenreList().toString();
    }
}
