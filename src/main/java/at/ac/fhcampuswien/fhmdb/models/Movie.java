package at.ac.fhcampuswien.fhmdb.models;

import java.util.Arrays;
import java.util.List;


public class Movie {

    public String title;
    private String description;
    private List<String> genreList;
    // private String genre;





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


    public List<String> getGenreList(){
        return genreList;
    }

    public String getGenreStrings(){
        return getGenreList().toString();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }
}
