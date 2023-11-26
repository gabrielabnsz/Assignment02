import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    // Referencing UI elements
    @FXML private TextField txtNum;
    @FXML private RadioButton rdoTotal;
    @FXML private RadioButton rdoAvg;
    @FXML private RadioButton rdoMax;
    @FXML private RadioButton rdoMin;
    @FXML private TextField resultOutput;

    private Excel excel; // Instance of Excel class
    private ToggleGroup toggleGroup; // Declare

    @FXML
    private void initialize() {
        toggleGroup = new ToggleGroup(); // Initialize

        // Add buttons
        rdoTotal.setToggleGroup(toggleGroup);
        rdoAvg.setToggleGroup(toggleGroup);
        rdoMax.setToggleGroup(toggleGroup);
        rdoMin.setToggleGroup(toggleGroup);
    }

    // Method to calculate
    @FXML
    private void calculate() {
        String input = txtNum.getText();
        if (!input.isEmpty()) {
            excel = new Excel(input);
            if (rdoTotal.isSelected()) {
                double total = excel.findTotal();
                resultOutput.setText(Double.toString(total));
            } else if (rdoAvg.isSelected()) {
                double avg = excel.findAverage();
                resultOutput.setText(Double.toString(avg));
            } else if (rdoMax.isSelected()) {
                double max = excel.findMaximum();
                resultOutput.setText(Double.toString(max));
            } else if (rdoMin.isSelected()) {
                double min = excel.findMinimum();
                resultOutput.setText(Double.toString(min));
            }
        } else {
            resultOutput.setText("Empty, please insert numbers");
        }
    }
}