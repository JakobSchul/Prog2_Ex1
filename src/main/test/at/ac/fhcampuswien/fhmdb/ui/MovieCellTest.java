package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieCellTest {

    // helper class for tests
    private Movie makeTestMovie(){

        // constructor erstellt
        Movie movie = new Movie();
        movie.setTitle("First movie");
        movie.setDescription("This description is for tests only!");
        return movie;
    }


}