package viewmodel;


import javafx.application.Platform;
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

    public void turnUp(){
        model.turnUp();
    }

    public void turnDown(){
        model.turnDown();
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
        Platform.runLater(() -> {
            switch(evt.getPropertyName()) {
                case "CriticalValues": {
                    highValueLabelProperty.set(evt.getNewValue().toString());
                    lowValueLabelProperty.set(evt.getOldValue().toString());
                    break;
                }
                case "TurnUp":
                    radiatorStateProperty.set("Current state: " + evt.getNewValue());
                    break;

                case "TurnDown":
                    radiatorStateProperty.set("Current state: " + evt.getNewValue());
                    break;
            }
        });




    }
}
