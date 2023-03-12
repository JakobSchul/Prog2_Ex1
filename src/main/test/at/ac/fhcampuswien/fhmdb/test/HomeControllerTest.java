package at.ac.fhcampuswien.fhmdb.test;
import at.ac.fhcampuswien.fhmdb.HomeController;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import javax.swing.text.html.ListView;
import java.util.Collections;
import java.util.List;

import static at.ac.fhcampuswien.fhmdb.HomeController.*;

import static org.junit.Assert.assertEquals;

public class HomeControllerTest {


    private JFXButton resetBtn;
    public ObservableList<Movie> dummyData() {

        List<String> genreList = Collections.singletonList("Action");
        ObservableList<Movie> movies = FXCollections.observableArrayList(


                new Movie("Ahe Shawshank Redemption", "Two imprisoned men bond over a number of years...", genreList),
                new Movie("Bhe Knight", "The aging patriarch of an organized crime dynasty transfers control...", genreList),
                new Movie("Zhe Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham...", genreList));
        return movies;

    }

//    @Test
//    public void if_search_field_empty_all_movies_are_shown(){
//        //Given
//        ObservableList<Movie> movies = dummyData();
//        //When
//        searchMovies(movies,"");
//        //Then
//        assertEquals(3,searchMovies(dummyData(),"").size());
//    }
//
//    @Test
//    public void search_finds_in_description_the_and_returns_2(){
//        //Given
//        ObservableList<Movie> movies = dummyData();
//        //When
//        searchMovies(movies,"the");
//        //Then
//        assertEquals(2,searchMovies(dummyData(),"the").size());
//
//    }

//    @Test
//    public void knight_searchMovies_returns_2() {
//
//        // given
//        // Observable list at the top -
//        ObservableList<Movie> movies = dummyData();
//        // when
//        // knight can be found in list -
//        searchMovies(movies,"Knight");
//        // then
//        assertEquals(2, searchMovies(dummyData(), "Knight").size());
//
//    }


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