package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LandingPageController {

    @FXML
    private Button seriesButton;

    @FXML
    private Button parallelButton;
    
    @FXML
    private void seriesButtonHandler(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/SeriesPage.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) seriesButton.getScene().getWindow();
            
            Scene scene = new Scene(root, 1000, 600);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void parallelButtonHandler(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ParallelPage.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) parallelButton.getScene().getWindow();
            
            Scene scene = new Scene(root, 1000, 600);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
