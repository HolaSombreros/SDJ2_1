package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometersViewModel implements PropertyChangeListener
{
    private StringProperty radiatorState;
    private StringProperty thermometer0;
    private StringProperty thermometer1;
    private StringProperty thermometer2;
    private StringProperty errorLabel;

    private Model model;


    public ThermometersViewModel(Model model){
        this.model = model;
        this.thermometer0 = new SimpleStringProperty();
        this.thermometer1 = new SimpleStringProperty();
        this.thermometer2 = new SimpleStringProperty();
        this.errorLabel = new SimpleStringProperty();
        this.radiatorState = new SimpleStringProperty();
        model.addListener(this);
        radiatorState.set(model.getRadiatorStatus());
    }

    public StringProperty getRadiatorState()
    {
        return radiatorState;
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
