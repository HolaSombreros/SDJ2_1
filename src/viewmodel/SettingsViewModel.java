package viewmodel;

import com.sun.javafx.collections.ImmutableObservableList;
import javafx.beans.property.*;
import mediator.Model;

public class SettingsViewModel {

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
    public SettingsViewModel(Model model) {
        this.model = model;
        highValueProperty = new SimpleDoubleProperty();
        lowValueProperty = new SimpleDoubleProperty();
        radiatorStateProperty = new SimpleStringProperty();
        errorProperty = new SimpleStringProperty(null);
        highValueLabelProperty = new SimpleStringProperty();
        lowValueLabelProperty = new SimpleStringProperty();

    }

    public void clear(){
        errorProperty.set("");
        highValueProperty.set(0);
        lowValueProperty.set(0);

        radiatorStateProperty.set("Current state " + model.getRadiatorStatus());
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
}
