package controllers;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import models.CounterModel;

public class MainController
{
	CounterModel counterModel;
	
	@FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Label sumLabel;

    @FXML
    private Button calcButton;

    @FXML
    void onCalcClick(ActionEvent event) 
    {
    	counterModel.addNums(Integer.valueOf(textField1.getText()), 
    			Integer.valueOf(textField2.getText()));
    }
    
    public void setModel(CounterModel newModel)
    {
    	counterModel = newModel;
    	
    	// bind label
    	StringConverter<Number> formatter = new NumberStringConverter();
    			
    	Bindings.bindBidirectional(sumLabel.textProperty(),
    			counterModel.getSum(),formatter);
    }
}
