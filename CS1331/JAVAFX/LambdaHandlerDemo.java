import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class LambdaHandlerDemo extends Application {

  private int x =0;

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Hold two buttons in an HBox
    HBox hBox = new HBox();
    hBox.setSpacing(40);
    hBox.setAlignment(Pos.CENTER);
    Button btNew = new Button("New");
    Button btOpen = new Button("Open");
    Button btSave = new Button("Save");
    Button btPrint = new Button("Print");
    TextArea text = new TextArea("enter a name");
    hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint, text);
  
    // Create and register the handler
    btNew.setOnAction((ActionEvent e) -> sum());

    btOpen.setOnAction((e) -> {String x = text.getText();
      if(x.equals("alonso")) text.setText("A dildo");
      else System.out.println("A cool guy");});

    
    btSave.setOnAction(e -> {
      System.out.println("Process Save");
    });
    
    btPrint.setOnAction(e -> System.out.println("Process Print"));

    // Create a scene and place it in the stage
    Scene scene = new Scene(hBox, 500, 300);
    primaryStage.setTitle("LambdaHandlerDemo"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }

  public void sum() {
    x++;
    if(x==10) System.out.println("go fuck urself");
    else{
    System.out.println(x);}
  }
}
