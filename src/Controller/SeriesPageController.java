package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class SeriesPageController {

    // ==================== USER INPUT ====================

    @FXML
    private TextField rOneTextField;

    @FXML
    private TextField rTwoTextField;

    @FXML
    private TextField rThreeTextField;

    @FXML
    private TextField vTotalTextField;

    // ==================== R ====================

    @FXML
    private Label rOneLabel;

    @FXML
    private Label rTwoLabel;

    @FXML
    private Label rThreeLabel;

    @FXML
    private Label rTotalLabel;

    // ==================== I ====================

    @FXML 
    private Label iOneLabel;

    @FXML
    private Label iTwoLabel;

    @FXML
    private Label iThreeLabel;

    @FXML
    private Label iTotalLabel;

    // ==================== V ====================

    @FXML
    private Label vOneLabel;

    @FXML
    private Label vTwoLabel;

    @FXML
    private Label vThreeLabel;

    @FXML
    private Label vTotalLabel;

    @FXML
    private Label voltageLabel;

    // ==================== BUTTONS ====================

    @FXML
    private Button calculateButton;

    @FXML
    private Button seriesButton;

    @FXML
    private Button parallelButton;
    
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
    
    @FXML
    private void calculateButtonHandler(ActionEvent event) {
        try {
            double r1 = Double.parseDouble(rOneTextField.getText());
            double r2 = Double.parseDouble(rTwoTextField.getText());
            double r3 = Double.parseDouble(rThreeTextField.getText());
            double vTotal = Double.parseDouble(vTotalTextField.getText());
            
            double rTotal = r1 + r2 + r3;
            
            double iTotal = vTotal / rTotal;
            
            double iOne = iTotal;
            double iTwo = iTotal;
            double iThree = iTotal;
            
            double vOne = iTotal * r1;
            double vTwo = iTotal * r2;
            double vThree = iTotal * r3;
            
            rTotalLabel.setText(String.format("R(t) = %.2f Ω", rTotal));
            iTotalLabel.setText(String.format("I(t) = %.2f A", iTotal));
            
            iOneLabel.setText(String.format("I₁ = %.2f A", iOne));
            iTwoLabel.setText(String.format("I₂ = %.2f A", iTwo));
            iThreeLabel.setText(String.format("I₃ = %.2f A", iThree));
            
            vOneLabel.setText(String.format("V₁ = %.2f V", vOne));
            vTwoLabel.setText(String.format("V₂ = %.2f V", vTwo));
            vThreeLabel.setText(String.format("V₃ = %.2f V", vThree));
            
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Input Error");
            alert.setContentText("Please enter valid numbers for all fields.");
            alert.showAndWait();
        } catch (ArithmeticException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Calculation Error");
            alert.setHeaderText("Division by Zero");
            alert.setContentText("Error: Total resistance cannot be zero.");
            alert.showAndWait();
        }
    }
    
}
