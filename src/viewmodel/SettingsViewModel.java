package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.Model;

public class SettingsViewModel {

    //private attributes

    private IntegerProperty highValueProperty;
    private IntegerProperty lowValueProperty;
    private StringProperty radiatorStateProperty;
    private StringProperty errorProperty;
    private Model model;


    /**
     * @param model
     * */
    public SettingsViewModel(Model model) {
        this.model = model;
        highValueProperty = new SimpleIntegerProperty();
        lowValueProperty = new SimpleIntegerProperty();
        radiatorStateProperty = new SimpleStringProperty();
        errorProperty = new SimpleStringProperty();
    }


    public IntegerProperty highValueProperty() {
        return highValueProperty;
    }

    public IntegerProperty lowValueProperty() {
        return lowValueProperty;
    }


    public StringProperty radiatorStateProperty() {
        return radiatorStateProperty;
    }


    public StringProperty errorProperty() {
        return errorProperty;
    }
}
