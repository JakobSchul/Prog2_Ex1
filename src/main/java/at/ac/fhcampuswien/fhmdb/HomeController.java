package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {


    public JFXButton resetBtn;

    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public final List<Movie> allMovies = FhmdbApplication.initializeMovies();


    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes


    public static void sortMoviesByTitleAscending(ObservableList<Movie> movies) {
        FXCollections.sort(movies, Comparator.comparing(Movie::getTitle));
    }

    public static void sortMoviesByTitleDescending(ObservableList<Movie> movies) {
        FXCollections.sort(movies, Comparator.comparing(Movie::getTitle).reversed());
    }

    public void genreBox() {

//genreComboBox
    }


    public ObservableList<Movie> searchMovies(ObservableList<Movie> movies) {


        String searchTerm = searchField.getText();


        List<String> genresList = Arrays.asList("ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY",
                "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR",
                "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR",
                "WESTERN");

        System.out.println("searchMovies Methode");

        // search within list, compare String with getter, add found to new list, return new list
        ObservableList<Movie> searchResults = FXCollections.observableArrayList();

        for (Movie movie : movies) {
            String pickedGenre;
            if (genreComboBox.getValue()== null){
                pickedGenre = " ";
            }else{
                pickedGenre = genreComboBox.getValue().toString().toLowerCase();

            }


            if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) || movie.getDescription().toLowerCase().contains(searchTerm.toLowerCase())) {
//                System.out.println(movie.getGenreStrings().toLowerCase());
//                System.out.println("Hurraa");
//                System.out.println(pickedGenre);
//                System.out.println(movie.getGenreList().stream().toString().toLowerCase().compareTo(pickedGenre.toString().toLowerCase()));
                for (int i = 0; i < movie.getGenreList().size(); i++) {
//                    System.out.println(movie.getGenreList().get(i).toString().toLowerCase());
                    if ((movie.getGenreList().get(i).toString().toLowerCase().contains(pickedGenre.toString().toLowerCase()))) {

//                        System.out.println("ENDLKICSHHHCSC");
                        searchResults.add(movie);




                    }

//

                }

//                System.out.println(movie.getTitle().toLowerCase());
//                System.out.println(searchTerm.toLowerCase());
//                System.out.println(movie.getDescription().toLowerCase());


//              movie.getGenreList().toString().toLowerCase().equals(genreComboBox.getValue().toString().toLowerCase())){
//                    System.out.println("movie.getGenreList().toString().toLowerCase(): " + movie.getGenreList().toString().toLowerCase());

//                    System.out.println("genreComboBox.getValue().toString().toLowerCase(): " + genreComboBox.getValue().toString().toLowerCase());
            }




    }
        return searchResults;
    }


    public void searchFieldAction() {
        System.out.println("searchFieldAction Methode");

        String searchTerm = searchField.getText();


        movieListView.setItems(searchMovies(observableMovies));


    }

    public ObservableList<Movie> resetBtnAction() {

        movieListView.setItems(observableMovies);

        return observableMovies;

    }

    public void sortBtnAction() {
        if (sortBtn.getText().equals("Sort (asc)")) {

            sortMoviesByTitleAscending(observableMovies);
            movieListView.setItems(observableMovies);
            sortBtn.setText("Sort (desc)");


        } else {

            sortMoviesByTitleDescending(observableMovies);
            movieListView.setItems(observableMovies);
            sortBtn.setText("Sort (asc)");


        }

    }

    public void getGenre() {
        String allGenres = genreComboBox.getItems().toString();

        System.out.println(allGenres);


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        observableMovies.addAll(allMovies);         // add CSV Data data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.getItems().addAll("ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY", "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR", "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR", "WESTERN");
        genreComboBox.setPromptText("Filter by Genre");


        genreComboBox.setOnAction(event -> {
            genreBox();
        });


        // Takes search Term and searches
        searchField.setOnAction(event -> {
            searchFieldAction();


        });
        searchBtn.setOnAction(event -> {
            searchFieldAction();

        });
        //This reset button doesnt do much but its nice.
        resetBtn.setOnAction(actionEvent -> {
            resetBtnAction();   // set data of observable list to list view
        });

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
                    sortBtnAction();

                }


        );
    }
}