import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FirstUI extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Label lable1 = new Label("Enter number 1:");
		TextField txt1 = new TextField();
		Label lable2 = new Label("Enter number 2:");
		TextField txt2 = new TextField();
		HBox hb = new HBox();
		hb.getChildren().addAll(lable1,txt1,lable2,txt2);
		hb.setSpacing(10);
		Button btn1 = new Button("+");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				int sum = Integer.parseInt(txt1.getText()) + Integer.parseInt(txt2.getText());
				System.out.println("Sum is: "+  sum);
			}
		});
		
		StackPane root = new StackPane();
		root.getChildren().add(btn1);	
		Scene scene = new Scene(root,600,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("First JavaFX Application");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
