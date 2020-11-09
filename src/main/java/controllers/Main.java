package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.CounterModel;


public class Main extends Application
{

	@Override
	public void start(Stage stage) throws Exception
	{
		CounterModel model = new CounterModel();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/CounterView.fxml"));
		BorderPane view = loader.load();
		MainController cont = loader.getController();
		cont.setModel(model);
		
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
