package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.HomeController;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static at.ac.fhcampuswien.fhmdb.HomeController.*;

import static org.junit.Assert.assertEquals;

public class HomeControllerTest extends HomeController {

    public ObservableList<Movie> dummyData() {

        List<String> genreList = Collections.singletonList("Action");
        ObservableList<Movie> movies = FXCollections.observableArrayList(


                new Movie("Ahe Shawshank Redemption", "Two imprisoned men bond over a number of years...", genreList),
                new Movie("Bhe Knight", "The aging patriarch of an organized crime dynasty transfers control...", genreList),
                new Movie("Zhe Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham...", genreList));
        return movies;
    }

    @Test
    public void checks_If_There_Are_Only_TwentieOne_Movies() {

        int numberMovies = 21;
        assertEquals(numberMovies, allMovies.size());


    }

    @Test
    public void descendingTest() {
        // Given
        ObservableList<Movie> movies = dummyData();

        //When
        sortMoviesByTitleDescending(movies);

        //Then
        assertEquals("Zhe Dark Knight", movies.get(0).getTitle());
    }

    @Test
    public void ascendingTest() {
        //Given
        ObservableList<Movie> movies = dummyData();

        //When
        sortMoviesByTitleAscending(movies);

        //Then
        assertEquals("Ahe Shawshank Redemption", movies.get(0).getTitle());
    }
}