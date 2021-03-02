package viewmodel;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.Model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SettingsViewModel implements PropertyChangeListener {

    //private attributes

    private DoubleProperty highValueProperty;
    private DoubleProperty lowValueProperty;
    private StringProperty radiatorStateProperty;
    private StringProperty errorProperty;
    private StringProperty highValueLabelProperty;
    private StringProperty lowValueLabelProperty;
    private Model model;


    /**
     * @param model
     * */
    public SettingsViewModel(Model model)  {
        this.model = model;
        highValueProperty = new SimpleDoubleProperty();
        lowValueProperty = new SimpleDoubleProperty();
        radiatorStateProperty = new SimpleStringProperty();
        errorProperty = new SimpleStringProperty(null);
        highValueLabelProperty = new SimpleStringProperty();
        lowValueLabelProperty = new SimpleStringProperty();
        model.addListener(this);

    }

    public void clear(){
        errorProperty.set("");
        radiatorStateProperty.set("Current state " + model.getRadiatorStatus());

    }

    public void set(){
       try {
           model.setCriticalValues(highValueProperty.doubleValue(), lowValueProperty.doubleValue());
       }
       catch (Exception e){
           errorProperty.set(e.getMessage());
       }
       //TODO
    }

    public StringProperty highValueLabelProperty() {
        return highValueLabelProperty;
    }


    public StringProperty lowValueLabelProperty() {
        return lowValueLabelProperty;
    }

    public DoubleProperty highValueProperty() {
        return highValueProperty;
    }

    public DoubleProperty lowValueProperty() {
        return lowValueProperty;
    }


    public StringProperty radiatorStateProperty() {
        return radiatorStateProperty;
    }


    public StringProperty errorProperty() {
        return errorProperty;
    }

    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("CriticalValues")){
            highValueLabelProperty.set(evt.getNewValue().toString());
            lowValueLabelProperty.set(evt.getOldValue().toString());
        }

    }
}
