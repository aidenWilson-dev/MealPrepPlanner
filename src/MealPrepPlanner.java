import au.edu.uts.ap.javafx.*;
import controller.PrepPlannerController;
import javafx.stage.*;
import javafx.application.Application;
import javafx.scene.image.Image;
import model.*;

public class MealPrepPlanner extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        primaryStage.getIcons().add(new Image("/view/images/prepIcon.jpeg"));
        primaryStage.setX(ViewLoader.X);
        primaryStage.setY(ViewLoader.Y);
        ViewLoader.showStage(new PrepPlannerController(), "/view/MainView.fxml", "Prep Planner", primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }   
}
    