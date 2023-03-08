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

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable{


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


    private ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes


    public static void sortMoviesByTitleAscending(ObservableList<Movie> movies) {
        FXCollections.sort(movies, Comparator.comparing(Movie::getTitle));
    }

    public static void sortMoviesByTitleDescending(ObservableList<Movie> movies) {
        FXCollections.sort(movies, Comparator.comparing(Movie::getTitle).reversed());
    }


    public ObservableList<Movie> searchMovies(ObservableList<Movie> movies, String searchTerm) {

        // search within list, compare String with getter, add found to new list, return new list
        ObservableList<Movie> searchResults = FXCollections.observableArrayList();
        for (Movie movie : movies) {
            if (movie.getTitle().contains(searchTerm) || movie.getDescription().contains(searchTerm)) {
                searchResults.add(movie);
            }
        }
        return searchResults;
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

        // Takes search Term and searches
        searchField.setOnAction(event -> {
            String searchTerm = searchField.getText();
            movieListView.setItems(searchMovies(observableMovies, searchTerm));
        });
        //This reset button doesnt do much but its nice.
        resetBtn.setOnAction(actionEvent -> {
            movieListView.setItems(observableMovies);   // set data of observable list to list view
        });

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
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


        );
    }
}