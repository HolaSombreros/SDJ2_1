package view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.DoubleStringConverter;
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
        Bindings.bindBidirectional(highValueField.textProperty(), viewModel.highValueProperty(), new DoubleStringConverter());
        Bindings.bindBidirectional(lowValueField.textProperty(), viewModel.lowValueProperty(), new DoubleStringConverter());
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
        viewModel.turnUp();
    }

    @FXML public void turnDown(){
        viewModel.turnDown();
    }

    @FXML public void cancel(){
        viewHandler.openView("thermometers");
    }

    @FXML public void set(){
        viewModel.set();
    }


}
