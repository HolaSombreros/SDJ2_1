package view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.util.converter.NumberStringConverter;
import viewmodel.SettingsViewModel;




public class SettingsViewController
{
    //private instance variables
    private Region root;
    private ViewHandler viewHandler;
    private SettingsViewModel viewModel;
    @FXML private TextField highValueField;
    @FXML private TextField lowValueField;
    @FXML private Label highValueLabel;
    @FXML private Label lowValueLabel;
    @FXML private Label errorLabel;
    @FXML private Label radiatorStateLabel;

    public SettingsViewController() {
    }


    public void init(ViewHandler viewHandler, SettingsViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
        Bindings.bindBidirectional(highValueField.textProperty(), viewModel.highValueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(lowValueField.textProperty(), viewModel.lowValueProperty(), new NumberStringConverter());
        errorLabel.textProperty().bind(viewModel.errorProperty());
        radiatorStateLabel.textProperty().bind(viewModel.radiatorStateProperty());
        highValueLabel.textProperty().bind(new SimpleStringProperty(viewModel.highValueLabelProperty().toString()));
        lowValueLabel.textProperty().bind(new SimpleStringProperty(viewModel.lowValueLabelProperty().toString()));
        reset();
    }

    public void reset(){
        viewModel.clear();
    }

    public Region getRoot() {
        return root;
    }

    @FXML public void turnUp(){

    }

    @FXML public void turnDown(){

    }

    @FXML public void cancel(){
        viewHandler.openView("thermometers");
    }

    @FXML public void set(){

    }


}
