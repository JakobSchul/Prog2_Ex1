package at.ac.fhcampuswien.fhmdb.models;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Movie {

    public String title;
    private String description;

    private String genre;

    public List<String> genreList = Arrays.asList("Action", "ADVENTURE", "ANIMATION", "BIOGRAPHY", "COMEDY",
            "CRIME", "DRAMA", "DOCUMENTARY", "FAMILY", "FANTASY", "HISTORY", "HORROR",
            "MUSICAL", "MYSTERY", "ROMANCE", "SCIENCE_FICTION", "SPORT", "THRILLER", "WAR",
            "WESTERN");

    public List<String> getGenreList() {
        return genreList;
    }

    public Movie(String title, String description, String genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public static List<Movie> readCSV() throws IOException {


        String csvPath = "src/main/resources/at/ac/fhcampuswien/fhmdb/Top_10000_Movies_firstTwentyEntries.csv";
        Reader in = new FileReader(csvPath);

        List<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in).getRecords();
        List<Movie> movies = new ArrayList<>();

        // Create new Movie Object with parsed Info
        for (CSVRecord record : records) {
            String title = record.get("original_title");
            String overview = record.get("overview");
            String genre = record.get("genre");
            System.out.println(genre);
            movies.add(new Movie(title, overview, genre));
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
        return movies;


    }
//    public static List<Movie> changeSorting(String asc_desc){
//        List<Movie> sorted;
//
//
//
//        return sorted;
//    }


}
