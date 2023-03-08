package at.ac.fhcampuswien.fhmdb.ui;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MovieCell extends ListCell<Movie> {
    private final Label titleLayout = new Label();
    private final Label descriptionLayout = new Label();
    private final Label genreLayout = new Label();
    private final VBox layout = new VBox(titleLayout, descriptionLayout, genreLayout);

    @Override
    protected void updateItem(Movie movie, boolean empty) {
        super.updateItem(movie, empty);

        if (empty || movie == null) {
            setText(null);
        } else {
            this.getStyleClass().add("movie-cell");
            titleLayout.setText(movie.getTitle());
            descriptionLayout.setText(
                    movie.getDescription() != null
                            ? movie.getDescription()
                            : "No description available"
            );
            genreLayout.setText(
                    movie.getGenreStrings() != null
                            ? movie.getGenreStrings()
                            : "No description available"
            );


            // color scheme
            titleLayout.getStyleClass().add("text-yellow");
            descriptionLayout.getStyleClass().add("text-white");
            genreLayout.getStyleClass().add("text-brown");
            layout.setBackground(new Background(new BackgroundFill(Color.web("#454545"), null, null)));

            // layout
            titleLayout.fontProperty().set(titleLayout.getFont().font(20));
            descriptionLayout.setMaxWidth(this.getScene().getWidth() - 30);
            descriptionLayout.setWrapText(true);

            genreLayout.setMaxWidth(this.getScene().getWidth() - 30);
            genreLayout.setWrapText(true);

            layout.setPadding(new Insets(10));
            layout.spacingProperty().set(10);
            layout.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);
            setGraphic(layout);
        }
    }
}

