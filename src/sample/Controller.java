package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.utils.CalculatorValidator;

import javax.script.ScriptEngineManager;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    private CalculatorValidator executor = new CalculatorValidator();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField calcWindow;

    @FXML
    private Button barkOpen;

    @FXML
    private Button barkClose;

    @FXML
    private Button delete;

    @FXML
    private Button cleanAll;

    @FXML
    private Button num7;

    @FXML
    private Button num8;

    @FXML
    private Button num9;

    @FXML
    private Button div;

    @FXML
    private Button num4;

    @FXML
    private Button num5;

    @FXML
    private Button num6;

    @FXML
    private Button mult;

    @FXML
    private Button num1;

    @FXML
    private Button num2;

    @FXML
    private Button num3;

    @FXML
    private Button mns;

    @FXML
    private Button num0;

    @FXML
    private Button dot;

    @FXML
    private Button pls;

    @FXML
    private Button eqls;

    @FXML
    void initialize() {
        delete.setOnAction(event -> {
            String value = calcWindow.getText();
            if (calcWindow.getText().length() == 0) {
                return;
            }
            calcWindow.setText(calcWindow.getText(0, value.length()-1));
        });
        cleanAll.setOnAction(event -> {
            executor.setOpenedBark(0);
            calcWindow.setText("");
        });
        dot.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText()) && executor.canAddOperator(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + ".");
            }
        });
        div.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText()) && executor.canAddOperator(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "/");
            }
        });
        mult.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText()) && executor.canAddOperator(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "*");
            }
        });
        mns.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText()) && executor.canAddMines(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "-");
            }
        });
        pls.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText()) && executor.canAddOperator(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "+");
            }
        });
        num1.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "1");
            }
        });
        num2.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "2");
            }
        });
        num3.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "3");
            }
        });
        num4.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "4");
            }
        });
        num5.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "5");
            }
        });
        num6.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "6");
            }
        });
        num7.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "7");
            }
        });
        num8.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "8");
            }
        });
        num9.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "9");
            }
        });
        num0.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "0");
            }
        });
        barkOpen.setOnAction(event -> {
            if (executor.isCanAdd(calcWindow.getText()) && executor.canAddOpenBark(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + "(");
            }
        });
        barkClose.setOnAction(event -> {
            if (executor.canAddCloseBark(calcWindow.getText())){
                calcWindow.setText(calcWindow.getText() + ")");
            }
        });
        eqls.setOnAction(event -> {
            if(calcWindow.getText().length()!=0) {
                calcWindow.setText(calc(calcWindow.getText()));
            }
        });
    }

    private static String calc(String equation) {
        String res;
        try {
            res = new ScriptEngineManager().getEngineByName("JavaScript").eval(equation).toString();
        } catch (Exception ignore) {
            res = "Not correct equation";
            ignore.printStackTrace();
        }
        return res;
    }


}
