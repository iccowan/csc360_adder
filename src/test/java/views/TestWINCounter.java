package views;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import controllers.Main;
import controllers.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.CounterModel;

@ExtendWith(ApplicationExtension.class)
public class TestWINCounter
{
	@Start // Before
	private void start(Stage stage)
	{
		CounterModel model = new CounterModel();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/CounterView.fxml"));
		BorderPane view;
		try
		{
			view = loader.load();
			MainController cont = loader.getController();
			cont.setModel(model);
			
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void testAdd(FxRobot robot, String amount1, String amount2, String sum)
	{
		robot.clickOn("#textField1");
		robot.write(amount1);
		robot.clickOn("#textField2");
		robot.write(amount2);
		
		robot.clickOn("#calcButton");
		Assertions.assertThat(robot.lookup("#sumLabel").
				queryAs(Label.class)).hasText(sum);
	}
	
	@Test
	public void testAdds(FxRobot robot)
	{
		testAdd(robot, "17", "31", "48");
		testAdd(robot, "17", "31", "48");
		testAdd(robot, "44", "0", "44");
		testAdd(robot, "17", "-21","-4");
		testAdd(robot, "-14", "-90", "-104");
		testAdd(robot, "-17", "21", "4");
		testAdd(robot, "AAAAAA", "2", "4");
	}
}
