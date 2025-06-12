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

public class ParallelPageController {

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
    private void calculateButtonHandler(ActionEvent event) {
        try {
            double r1 = Double.parseDouble(rOneTextField.getText());
            double r2 = Double.parseDouble(rTwoTextField.getText());
            double r3 = Double.parseDouble(rThreeTextField.getText());
            double vTotal = Double.parseDouble(vTotalTextField.getText());
            
            double reciprocalSum = (1.0 / r1) + (1.0 / r2) + (1.0 / r3);
            double rTotal = 1.0 / reciprocalSum;
            
            double vOne = vTotal;
            double vTwo = vTotal;
            double vThree = vTotal;
            
            double iOne = vTotal / r1;
            double iTwo = vTotal / r2;
            double iThree = vTotal / r3;
            
            double iTotal = iOne + iTwo + iThree;
            
            rTotalLabel.setText(String.format("R(t) = %.2f Ω", rTotal));
            iTotalLabel.setText(String.format("I(t) = %.2f A", iTotal));
            
            vOneLabel.setText(String.format("V₁ = %.2f V", vOne));
            vTwoLabel.setText(String.format("V₂ = %.2f V", vTwo));
            vThreeLabel.setText(String.format("V₃ = %.2f V", vThree));
            
            iOneLabel.setText(String.format("I₁ = %.2f A", iOne));
            iTwoLabel.setText(String.format("I₂ = %.2f A", iTwo));
            iThreeLabel.setText(String.format("I₃ = %.2f A", iThree));
            
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
            alert.setContentText("Error: One or more resistance values cannot be zero.");
            alert.showAndWait();
        }
    }
    
}
