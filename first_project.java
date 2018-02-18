package firstproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class first_project extends Application  {
	
	
	Scene scene;
	Stage window;
	VBox parent_container ;
	HBox upper_window;
	HBox lower_window;
	VBox lower_window_left;
	VBox lower_window_right;
	TextArea t1;
	Button b1;
	Label l1;
	Label l2;
	TextArea t2;
	TextArea t3;
	
	
	public static void main(String[] args)
	{
		launch(args);
		
	}
	
	public void redraw(double w,double h) 
	{
		scene=new Scene(parent_container,w,h);
		parent_container.setPrefSize(w,h);
		upper_window.setMinSize(parent_container.getPrefWidth(), parent_container.getPrefHeight()/3);
		lower_window.setMinSize(parent_container.getPrefWidth(),2* parent_container.getPrefHeight()/3);
		lower_window_left.setMinSize(0.45*lower_window.getMinWidth(), lower_window.getMinHeight());
		lower_window_right.setMinSize(0.45*lower_window.getMinWidth(), lower_window.getMinHeight());
		
		t1.setPrefSize(upper_window.getMinWidth()/2, upper_window.getMinHeight());
		t2.setPrefSize(lower_window_left.getMinWidth(),lower_window_left.getMinHeight()-l1.getHeight()-50);
		t3.setPrefSize(lower_window_right.getMinWidth(),lower_window_right.getMinHeight()-l2.getHeight()-50);
	
		
	}
@Override
public void start(Stage primaryStage) throws Exception
{
	
	window = primaryStage;
	
	window.setTitle("ASSEMBLER");

	VBox parent_container = new VBox(10);
	HBox upper_window=new HBox(25);
	HBox lower_window=new HBox(10);
	VBox lower_window_left=new VBox(5);
	VBox lower_window_right=new VBox(5);
	
	TextArea t1=new TextArea();
	t1.setText("enter MIPS assembly here...");
	Button b1=new Button("ASSEMBLE");
	
	Label l1=new Label("BINARY");
	Label l2=new Label("HEXADECIMAL");
	TextArea t2=new TextArea();
	TextArea t3=new TextArea();
	
	

	
	upper_window.getChildren().addAll(t1,b1);
	lower_window_left.getChildren().addAll(l1,t2);
	lower_window_right.getChildren().addAll(l2,t3);
	lower_window.getChildren().addAll(lower_window_left,lower_window_right);
	parent_container.getChildren().addAll(upper_window,lower_window);
	
	
	Scene scene=new Scene(parent_container,window.getWidth(),window.getHeight());
	
	
		window.heightProperty().addListener(e -> redraw(window.getWidth(),window.getHeight()));
	

		window.widthProperty().addListener(e -> redraw(window.getWidth(),window.getHeight()));
	
	
	
	t1.setEditable(true);
	t2.setEditable(false);
	t3.setEditable(false);
	b1.setOnAction(new EventHandler<ActionEvent>()
	{
		@Override
		public void handle(ActionEvent event)
		{
			t2.setText("Assembled to BINARY");
			t3.setText("Assembled to HEXA");
		}
	}
			);
	
	parent_container.setPadding(new Insets(10));
	
	window.setScene(scene);
	window.sizeToScene();
	window.show();
	
	

	}



}
