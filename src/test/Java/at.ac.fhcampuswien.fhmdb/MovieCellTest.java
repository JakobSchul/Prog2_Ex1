package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCellTest extends MovieCell {

    // helper class for tests

    public void makeTestMovie(){

        // constructor erstellt
        Movie movie = new Movie();
        movie.setTitle("First movie");
        movie.setDescription("This description is for tests only!");
    }


}