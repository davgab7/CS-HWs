// I worked on this assignment alone

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import java.util.Random;
import javafx.scene.control.Alert;

/**
 * This is Slot class that does all the magic.
 * @author Davit
 * @version 1.0
 */

public class Slot extends Application {

    private int balance = 100;
    private Random rand = new Random();

    private Image lineImage = new Image("line.png");
    private Image bellImage = new Image("Bell.png");
    private ImageView imageView1 = new ImageView(bellImage);
    private Image grapeImage = new Image("Grape.png");
    private ImageView imageView2 = new ImageView(bellImage);
    private ImageView imageView3 = new ImageView(bellImage);
    private Image cherryImage = new Image("Cherry.png");

    private Alert alertBozo = new Alert(Alert.AlertType.INFORMATION);

    private TextField textField2 = new TextField("1");

    /**
     * [start The start method that does everything almost]
     * @param s [the stage/window for the view]
     */

    public void start(Stage s) {

        BorderPane mainPane = new BorderPane();
        mainPane.setStyle("-fx-background-color: #000000;");

        Image vegasImage = new Image("las-vegas.gif");
        ImageView vegasImageView = new ImageView(vegasImage);
        vegasImageView.setFitWidth(200);
        vegasImageView.setFitHeight(190);
        mainPane.setAlignment(vegasImageView, Pos.TOP_CENTER);
        mainPane.setMargin(vegasImageView, new Insets(5, 5, 5, 5));
        mainPane.setTop(vegasImageView);

        VBox vBoxLeft = new VBox();
        vBoxLeft.setSpacing(10);
        vBoxLeft.setAlignment(Pos.CENTER);
        //vBoxLeft.setStyle("-fx-border-color: white");
        mainPane.setLeft(vBoxLeft);
        vBoxLeft.setPrefWidth(150);


        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Regular");
        button1.setToggleGroup(group);
        button1.setSelected(true);
        RadioButton button2 = new RadioButton("Test");
        button2.setToggleGroup(group);
        doTheStyle(button1); doTheStyle(button2);
        vBoxLeft.getChildren().addAll(button1, button2);



        // Center

        HBox hBoxCenter = new HBox();
        hBoxCenter.setSpacing(20);
        hBoxCenter.setAlignment(Pos.CENTER);
        mainPane.setCenter(hBoxCenter);


        imageView1.setFitWidth(60);
        imageView1.setFitHeight(80);
        //imageView1.setStyle("-fx-border-color: white; -fx-border-radius: 15.0");


        imageView2.setFitWidth(60);
        imageView2.setFitHeight(80);


        imageView3.setFitWidth(60);
        imageView3.setFitHeight(80);


        hBoxCenter.getChildren().addAll(imageView1, imageView2, imageView3);

        //



        VBox vBoxRight = new VBox();
        vBoxRight.setSpacing(10);
        vBoxRight.setAlignment(Pos.CENTER);
        vBoxRight.setStyle("-fx-border-color: white;");
        mainPane.setRight(vBoxRight);
        vBoxRight.setPrefWidth(200);

        Label label1 = new Label("Current balance: $" + balance);
        vBoxRight.setMargin(label1, new Insets(0, 0, 170, 0));
        label1.setStyle("-fx-font-size: 24; -fx-text-fill: white;");
        label1.setWrapText(true);
        Label label2 = new Label("Gamble for: $");
        label2.setStyle("-fx-font-size: 18; -fx-text-fill: white;");

        textField2.setMaxWidth(55);
        textField2.setShape(new Circle(10));
        Button startButton = new Button("Start");
        vBoxRight.getChildren().addAll(label1, label2, textField2, startButton);


        startButton.setOnAction(e -> {
                if (Integer.parseInt(textField2.getText()) > balance) {
                    alertBozo.setTitle("Alert");
                    alertBozo.setContentText("Hey Bozo, you do not have that"
                        + " much money.");
                    alertBozo.showAndWait();
                } else {
                    if (button1.isSelected()) {
                        runRegular();
                        label1.setText("Current balance: $" + balance);
                    } else {
                        runTest();
                        label1.setText("Current balance: $" + balance);
                    }
                }

                if (balance == 0) {
                    alertBozo.setTitle("Alert");
                    alertBozo.setHeaderText("Oh, bad luck");
                    alertBozo.setHeight(250);
                    alertBozo.setContentText("Hey Bozo, at this point, you"
                        + " are oficially broke. Feel free to come back in the"
                        + " future and lose more money. Bye!");
                    alertBozo.showAndWait();
                    s.close();
                }
            });



        Scene scene = new Scene(mainPane, 1000, 700);
        s.setTitle("Welcome to Vegas"); // Set title
        s.setScene(scene); // Place the scene in the stage
        s.show(); // Display the stage
    }

    private void doTheStyle(RadioButton button) {
        button.setStyle("-fx-font-size: 20; -fx-text-fill: white;");

    }


    private void runRegular() {
        int x = 1 + rand.nextInt(8);
        int y = 1 + rand.nextInt(8);
        int z = 1 + rand.nextInt(8);

        if (x == 1) {
            imageView1.setImage(grapeImage);
        } else if (x == 2) {
            imageView1.setImage(cherryImage);
        } else if (x == 3) {
            imageView1.setImage(bellImage);
        } else {
            imageView1.setImage(lineImage);
        }

        if (y == 1) {
            imageView2.setImage(grapeImage);
        } else if (y == 2) {
            imageView2.setImage(cherryImage);
        } else if (y == 3) {
            imageView2.setImage(bellImage);
        } else {
            imageView2.setImage(lineImage);
        }

        if (z == 1) {
            imageView3.setImage(grapeImage);
        } else if (z == 2) {
            imageView3.setImage(cherryImage);
        } else if (z == 3) {
            imageView3.setImage(bellImage);
        } else {
            imageView3.setImage(lineImage);
        }

        if (x == 3 && y == 3 && z == 3) {
            balance += (10 * Integer.parseInt(textField2.getText()));
        } else if (x == 1 && y == 1 && z == 1) {
            balance += (7 * Integer.parseInt(textField2.getText()));
        } else if (x == 2 && y == 2 && z == 2) {
            balance += (5 * Integer.parseInt(textField2.getText()));
        } else if (x == 2 && y == 2) {
            balance += (3 * Integer.parseInt(textField2.getText()));
        } else if (x == 2 && z == 2) {
            balance += (3 * Integer.parseInt(textField2.getText()));
        } else if (y == 2 && z == 2) {
            balance += (3 * Integer.parseInt(textField2.getText()));
        } else if (x == 2) {
            balance += Integer.parseInt(textField2.getText());
        } else if (y == 2) {
            balance += Integer.parseInt(textField2.getText());
        } else if (z == 2) {
            balance += Integer.parseInt(textField2.getText());
        } else {
            balance -= Integer.parseInt(textField2.getText());
        }

    }

    private void runTest() {
        int x = 1 + rand.nextInt(3);
        int y = 1 + rand.nextInt(3);
        int z = 1 + rand.nextInt(3);

        if (x == 1) {
            imageView1.setImage(grapeImage);
        } else if (x == 2) {
            imageView1.setImage(cherryImage);
        } else {
            imageView1.setImage(bellImage);
        }

        if (y == 1) {
            imageView2.setImage(grapeImage);
        } else if (y == 2) {
            imageView2.setImage(cherryImage);
        } else {
            imageView2.setImage(bellImage);
        }

        if (z == 1) {
            imageView3.setImage(grapeImage);
        } else if (z == 2) {
            imageView3.setImage(cherryImage);
        } else {
            imageView3.setImage(bellImage);
        }

        if (x == 3 && y == 3 && z == 3) {
            balance += (10 * Integer.parseInt(textField2.getText()));
        } else if (x == 1 && y == 1 && z == 1) {
            balance += (7 * Integer.parseInt(textField2.getText()));
        } else if (x == 2 && y == 2 && z == 2) {
            balance += (5 * Integer.parseInt(textField2.getText()));
        } else if (x == 2 && y == 2) {
            balance += (3 * Integer.parseInt(textField2.getText()));
        } else if (x == 2 && z == 2) {
            balance += (3 * Integer.parseInt(textField2.getText()));
        } else if (y == 2 && z == 2) {
            balance += (3 * Integer.parseInt(textField2.getText()));
        } else if (x == 2) {
            balance += Integer.parseInt(textField2.getText());
        } else if (y == 2) {
            balance += Integer.parseInt(textField2.getText());
        } else if (z == 2) {
            balance += Integer.parseInt(textField2.getText());
        } else {
            balance -= Integer.parseInt(textField2.getText());
        }

    }

    /**
     * [main the mian method]
     * @param args [takes an args array]
     */

    public static void main(String[] args) {
        launch(args);
    }

}