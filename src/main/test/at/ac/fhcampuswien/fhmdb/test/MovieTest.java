package at.ac.fhcampuswien.fhmdb.test;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void getTitle() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void getGenreList() {
    }

    @Test
    void getGenreStrings() {
    }

    @Test
    void test_to_get_Title(){

        // given
        Movie movie = new Movie("The best movie","This is the synapse of the best movie ever.", Arrays.asList("Drama"));

        // then
        assertEquals("The best movie", movie.getTitle());
    }

    @Test
    void test_for_wrong_Title(){

        // given
        Movie movie = new Movie("The best movie","This is the synapse of the best movie ever.", Arrays.asList("Drama"));

        //then
        assertNotEquals("The beast movie",movie.getTitle());

        // eigentlich der gleiche Test wie oben, schaut nur, dass es genau nicht matcht.
    }

    @Test
    void test_to_get_Description(){

        // given
        Movie movie = new Movie("The second best movie","This is the second best movie ever made!",Arrays.asList("Action"));

        // then
        assertEquals("This is the second best movie ever made!",movie.getDescription());

    }

    @Test
    void test_to_get_Genre_List(){

        // given
        List<String> genreList = Arrays.asList("Adventure");
        Movie movie = new Movie("Short movie title","What am I doing with my life?",genreList);

        // then
        assertEquals(genreList,movie.getGenreList());
    }


}