import au.edu.uts.ap.javafx.*;
import javafx.stage.*;
import model.PrepPlanner;
import javafx.application.Application;
import javafx.scene.image.Image;

public class MealPrepPlanner extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        primaryStage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
        primaryStage.setX(ViewLoader.X);
        primaryStage.setY(ViewLoader.Y);
        ViewLoader.showStage(new PrepPlanner(), "/view/MainView.fxml", "Prep Planner", primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }   
}
    