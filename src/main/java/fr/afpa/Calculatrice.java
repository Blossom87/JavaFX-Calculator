package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Calculatrice extends Application {

    /*
     * TP Calculatrice.
     */
    
    /*
     * currentSum = Initialise le résultat à 0.
     * userFieldAdd = Stock les entrées utilisateurs.
     */
    private int currentSum = 0;
    private String userFieldAdd = "";

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Calculatrice");

        Button buttonCalculate = new Button("Calculer");
        Button buttonClear = new Button("Vider");

        Button button0 = new Button("0");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");

        TextArea inputField = new TextArea();
        inputField.setPromptText("Entrée utilisateur.");

        GridPane calculator = new GridPane();
        calculator.setAlignment(Pos.CENTER);
        calculator.setGridLinesVisible(true);

        HBox buttonsRow1 = new HBox(button0, button1, button2, button3, button4);
        buttonsRow1.setAlignment(Pos.CENTER);

        HBox buttonsRow2 = new HBox(button5, button6, button7, button8, button9);
        buttonsRow2.setAlignment(Pos.CENTER);

        HBox functionButtons = new HBox(buttonCalculate, buttonClear);
        functionButtons.setAlignment(Pos.CENTER);
        functionButtons.setSpacing(125);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(inputField);

        calculator.add(inputField, 0, 0, 1, 1);
        calculator.add(buttonsRow1, 0, 1, 1, 2);
        calculator.add(buttonsRow2, 0, 3, 1, 1);
        calculator.add(functionButtons, 0, 4, 1, 1);

        scrollPane.setFitToWidth(true);
        scrollPane.setMaxWidth(250);
        scrollPane.setMaxHeight(100);

        // Avec EventHandler

        button0.setOnAction(value -> {
            inputField.setText(inputField.getText() + "0 +");
        });

        button1.setOnAction(value -> {
            inputField.setText(inputField.getText() + "1 +");
        });

        button2.setOnAction(value -> {
            inputField.setText(inputField.getText() + "2 +");
        });

        button3.setOnAction(value -> {
            inputField.setText(inputField.getText() + "3 +");
        });

        button4.setOnAction(value -> {
            inputField.setText(inputField.getText() + "4 +");
        });

        button5.setOnAction(value -> {
            inputField.setText(inputField.getText() + "5 +");
        });

        button6.setOnAction(value -> {
            inputField.setText(inputField.getText() + "6 +");
        });

        button7.setOnAction(value -> {
            inputField.setText(inputField.getText() + "7 +");
        });

        button8.setOnAction(value -> {
            inputField.setText(inputField.getText() + "8 +");
        });

        button9.setOnAction(value -> {
            inputField.setText(inputField.getText() + "9 +");
        });

        buttonCalculate.setOnAction(value -> {
            String inputValue = inputField.getText();

            if (inputValue.isEmpty()) {
                inputField.setText("Please press some buttons.");
                return;
            }

            int lastEqualIndex = inputValue.lastIndexOf('=');
            if (lastEqualIndex != -1) {
                inputValue = inputValue.substring(lastEqualIndex + 1).trim();
            }

            if (inputValue.endsWith("+")) {
                inputValue = inputValue.substring(0, inputValue.length() - 1);
            }

            String[] stringTotal = inputValue.split("\\+");
            int sum = 0;
            for (String str : stringTotal) {
                try {
                    sum += Integer.parseInt(str.trim());
                } catch (NumberFormatException e) {
                    inputField.setText("Error");
                    return;
                }
            }

            userFieldAdd += inputValue + "+";
            currentSum = sum;
            inputField.setText(userFieldAdd + "= " + currentSum + " +");
        });

        buttonClear.setOnAction(value -> {
            inputField.clear();
            userFieldAdd = "";
            currentSum = 0;
        });

        // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        Scene scene = new Scene(calculator, 500, 500);

        stage.setScene(scene);
        stage.show();
    }
}