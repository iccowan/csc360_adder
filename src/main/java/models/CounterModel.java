package models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CounterModel
{
	IntegerProperty sum = new SimpleIntegerProperty();
	
	public CounterModel()
	{
		
	}

	public IntegerProperty getSum()
	{
		return sum;
	}

	public void addNums(int int1, int int2)
	{
		sum.set(int1 + int2);
	}
}
