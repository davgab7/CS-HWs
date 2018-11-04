import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class Exam3 extends Application {

	public void start(Stage s) {
		VBox vBox = new VBox();
		vBox.setSpacing(10);
    	vBox.setAlignment(Pos.CENTER);

    	TextField t = new TextField("Enter t, r, c");

    	vBox.getChildren().add(t);

    	t.setOnAction(e -> {
    		if (t.getText().equals("t")) {
    			Text text = new Text("LOL");
    			vBox.getChildren().add(text);

    		} else if (t.getText().equals("c")) {
    			Circle c = new Circle(50);
    			vBox.getChildren().add(c);
    			c.setStroke(Color.RED);
    			c.setFill(Color.BLACK);

    		} else if (t.getText().equals("r")) {
    			Rectangle r = new Rectangle(50,50);
    			r.setStroke(Color.WHITE);
    			r.setFill(Color.BLACK);
    			vBox.getChildren().add(r);
    		} else System.out.println("sfsdafda");

    	});


    	Scene scene = new Scene(vBox, 500, 300);
	    s.setTitle("LambdaHandlerDemo"); // Set title
	    s.setScene(scene); // Place the scene in the stage
	    s.show(); // Display the stage 
	}
}