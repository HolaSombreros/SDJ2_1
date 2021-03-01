package viewmodel;

import javafx.beans.property.StringProperty;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometersViewModel implements PropertyChangeListener
{
    private StringProperty thermometer0;
    private StringProperty thermometer1;
    private StringProperty thermometer2;
    private StringProperty errorLabel;

    private Model model;


    public ThermometersViewModel(Model model){
        this.model = model;
    }

    public StringProperty thermometer0Property()
    {
        return thermometer0;
    }

    public StringProperty thermometer1Property()
    {
        return thermometer1;
    }

    public StringProperty thermometer2Property()
    {
        return thermometer2;
    }
    public StringProperty errorLabelProperty()
    {
        return errorLabel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {

    }
}
