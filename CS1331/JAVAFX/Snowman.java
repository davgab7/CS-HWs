import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;




public class Snowman extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {       
      final int MID = 150;
      final int TOP = 50;

      Rectangle bgd = new Rectangle(0,0,300,300);
      bgd.setFill(Color.CYAN);

      Text text = new Text(MID+100,20,"Frosty");
      text.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
      
      Rectangle ground = new Rectangle(0, 175, 300, 50);  // ground
      ground.setFill(Color.BLUE);

      Circle sun = new Circle(0, 0, 60);  // sun
      sun.setFill(Color.YELLOW);    

      Ellipse head = new Ellipse(MID, TOP+20, 20, 20);      // head
      head.setFill(Color.WHITE);    
      Ellipse upper_torso = new Ellipse(MID, TOP+60, 35, 25);   // upper torso
      upper_torso.setFill(Color.WHITE);    
      Ellipse lower_torso = new Ellipse(MID, TOP+110, 50, 30);  // lower torso
      lower_torso.setFill(Color.WHITE);    

      //page.setColor (Color.black);
      Ellipse lefteye = new Ellipse(MID-8, TOP+12, 3, 3);   // left eye
      Ellipse righteye = new Ellipse(MID+8, TOP+12, 3, 3);    // right eye

      Arc smile = new Arc(MID, TOP+25, 10, 5, 190, 160);   // smile
      smile.setType(ArcType.OPEN);

      Line leftarm = new Line(MID-25, TOP+60, MID-50, TOP+40);  // left arm
      Line rightarm = new Line(MID+25, TOP+60, MID+55, TOP+60);  // right arm

      Line hat_brim = new Line(MID-20, TOP+5, MID+20, TOP+5);  // brim of hat
      Rectangle hat_top = new Rectangle(MID-15, TOP-20, 30, 25);        // top of hat

    // Create a scene and place it in the stage
    Pane pane = new Pane();
    pane.getChildren().add(bgd);
    pane.getChildren().add(text);
    pane.getChildren().add(ground);
    pane.getChildren().add(sun);
    pane.getChildren().add(head);
    pane.getChildren().add(upper_torso);
    pane.getChildren().add(lower_torso);
    pane.getChildren().add(lefteye);
    pane.getChildren().add(righteye);
    pane.getChildren().add(leftarm);
    pane.getChildren().add(rightarm);
    pane.getChildren().add(smile);
    pane.getChildren().add(hat_brim);
    pane.getChildren().add(hat_top);
    
    Scene scene = new Scene(pane, 300, 200);
    primaryStage.setTitle("Snowman"); // Set the stage title
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
}
