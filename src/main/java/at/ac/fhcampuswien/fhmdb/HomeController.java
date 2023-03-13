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
import javafx.scene.control.Label;
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


    public final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes


    public static void sortMoviesByTitleAscending(ObservableList<Movie> movies) {
        FXCollections.sort(movies, Comparator.comparing(Movie::getTitle));
    }

    public static void sortMoviesByTitleDescending(ObservableList<Movie> movies) {
        FXCollections.sort(movies, Comparator.comparing(Movie::getTitle).reversed());
    }


    public String getComboboxString() {
        String pickedGenre;
        try {
            pickedGenre = genreComboBox.getValue().toString().toLowerCase();


        } catch (Exception e) {
            return " ";
        }
        return pickedGenre;


    }


    public ObservableList<Movie> searchMovies(ObservableList<Movie> movies) {


        ObservableList<Movie> searchResults = FXCollections.observableArrayList();
        for (Movie movie : movies) {
            if (movie.compareGenreStrings(getComboboxString())) {
                if (movie.compareTitle(searchField.getText().toLowerCase()) == true || movie.compareDescription(searchField.getText().toLowerCase()) == true) {
                    searchResults.add(movie);
                }
            }
        }
        return searchResults;
    }


    public void searchFieldAction() {

        movieListView.setItems(searchMovies(observableMovies));
    }

    public ObservableList<Movie> resetBtnAction() {

        movieListView.setItems(observableMovies);
        searchField.clear();

        // setzt auch genre back
        genreComboBox.setValue(" ");

        return observableMovies;
    }

    public void sortBtnAction() {

        if (sortBtn.getText().equals("Sort (asc)")) {

            sortMoviesByTitleAscending(observableMovies);
            searchFieldAction();
            sortBtn.setText("Sort (desc)");

        } else {

            sortMoviesByTitleDescending(observableMovies);
            searchFieldAction();
            sortBtn.setText("Sort (asc)");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        observableMovies.addAll(allMovies);         // add CSV Data data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        genreComboBox.getItems().addAll("Filter", "ACTION", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY", "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR", "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR", "WESTERN");
        genreComboBox.setPromptText("Filter by Genre");


        genreComboBox.setOnAction(event -> {
            searchFieldAction();
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