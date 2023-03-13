package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FhmdbApplication extends Application {


    public static List<Movie> readCSV() throws IOException {
        String csvPath = "src/main/resources/at/ac/fhcampuswien/fhmdb/Top_10000_Movies_firstTwentyEntries.csv";
        List<Movie> movies = new ArrayList<>();

        try (Reader in = new FileReader(csvPath)) {
            List<CSVRecord> records = CSVFormat.RFC4180.withHeader().parse(in).getRecords();

            for (CSVRecord record : records) {
                String title = record.get("original_title");
                String overview = record.get("overview");
                String genreString = record.get("genre") + "Filter";
                List<String> genreList = Arrays.asList(genreString.split(" \\s* ,\\s*"));
                movies.add(new Movie(title, overview, genreList));
            }
            System.out.println("readCSV loaded");
        }
        return movies;
    }

    public static List<Movie> initializeMovies() {
        // Uses readCSV Method to initialize
        List<Movie> movies;
        try {
            movies = readCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("initializedMovies");
        return movies;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FhmdbApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 890, 620);
        scene.getStylesheets().add(Objects.requireNonNull(FhmdbApplication.class.getResource("styles.css")).toExternalForm());
        stage.setTitle("FHMDb");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


        launch();
    }
}