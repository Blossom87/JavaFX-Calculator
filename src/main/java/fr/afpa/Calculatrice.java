package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculatrice extends Application {

  /*
   * TP Calculatrice.
   */

  /**
   * "Flag" permettant d'indiquer s'il s'agit du premier chiffre
   */
  private boolean isFirstNumber = true;

  /**
   * Contient le résultat de la somme
   */
  private int result = 0;

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
    Button ok = new Button("Ok");
    Button no = new Button("Non");

    TextArea inputField = new TextArea();
    inputField.setPromptText("Entrée utilisateur.");
    inputField.setEditable(false);

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
    calculator.add(buttonsRow1, 0, 1, 1, 1);
    calculator.add(buttonsRow2, 0, 2, 1, 1);
    calculator.add(functionButtons, 0, 3, 1, 1);

    scrollPane.setFitToWidth(true);
    scrollPane.setMaxWidth(250);
    scrollPane.setMaxHeight(100);

    // Avec EventHandler
    button0.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        if (isFirstNumber) {
          inputField.setText(inputField.getText() + "0");
          isFirstNumber = false;
        } else {
          inputField.setText(inputField.getText() + " + 0");
        }
      }
    });

    button1.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "1");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 1");
      }

      // A chaque fois que l'utilisateur clique sur un bouton -> ajouter un chiffre
      // dans une variable
      result = result + 1;
    });

    button2.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "2");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 2");
      }

      result = result + 2;
    });

    button3.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "3");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 3");
      }
      result = result + 3;
    });

    button4.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "4");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 4");
      }

      result = result + 4;
    });

    button5.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "5");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 5");
      }

      result = result + 5;
    });

    button6.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "6");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 6");
      }

      result = result + 6;
    });

    button7.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "7");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 7");
      }

      result = result + 7;
    });

    button8.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "8");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 8");
      }
      result = result + 8;
    });

    button9.setOnAction(value -> {
      if (isFirstNumber) {
        inputField.setText(inputField.getText() + "9");
        isFirstNumber = false;
      } else {
        inputField.setText(inputField.getText() + " + 9");
      }
      result = result + 9;
    });

    buttonCalculate.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        // Objectif : afficher la somme dans la zone de texte
        inputField.appendText(" = " + result + " ");
      }
    });

    buttonClear.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {

        Stage stage2 = new Stage();
        stage2.setWidth(300);
        stage2.setHeight(150);

        Label label = new Label("Voulez-vous vraiment éffacer votre calcul?");
        label.setAlignment(Pos.CENTER);

        HBox vbox = new HBox(ok, no);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        GridPane pane = new GridPane();
        
        pane.add(label, 0,0,1,1);
        pane.add(vbox, 0, 3, 1, 1);

        Scene scene2 = new Scene(pane);
        stage2.setScene(scene2);
        stage2.show();
      }
      
    });

    ok.setOnAction(new EventHandler<ActionEvent>() {
      
      @Override
      public void handle(ActionEvent event) {
      inputField.clear();
      result = 0;
      isFirstNumber = true;
      
      }
    });

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    Scene scene = new Scene(calculator, 500, 500);

    stage.setScene(scene);
    stage.show();
  }
}