package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static at.ac.fhcampuswien.fhmdb.HomeController.*;

import static org.junit.Assert.assertEquals;

public class HomeControllerTest {


    public ObservableList<Movie> dummyData() {
        ObservableList<Movie> movies = FXCollections.observableArrayList(
                new Movie("Ahe Shawshank Redemption", "Two imprisoned men bond over a number of years...", "ACTION"),
                new Movie("Bhe Knight", "The aging patriarch of an organized crime dynasty transfers control...", "ACTION"),
                new Movie("Zhe Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham...", "ACTION")
        );
        return movies;

    }


    @Test
    public void testSearchMovies() {

        assertEquals(2, searchMovies(dummyData(), "Knight").size());

    }

    @Test
    public void descendingTest() {


        // Given
        ObservableList<Movie> movies = dummyData();

        sortMoviesByTitleDescending(movies);
        assertEquals("Zhe Dark Knight",movies.get(0).getTitle());


    }

    @Test
    public void ascendingTest() {
        ObservableList<Movie> movies = dummyData();

        sortMoviesByTitleAscending(movies);
        assertEquals("Ahe Shawshank Redemption",movies.get(0).getTitle());



    }
}