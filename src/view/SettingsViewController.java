package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
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
            //TODO: bind labels and textFields
    }

    public void reset(){

    }

    public Region getRoot() {
        return root;
    }

    @FXML public void turnUp(){

    }

    @FXML public void turnDown(){

    }

    @FXML public void cancel(){

    }

    @FXML public void set(){

    }


}
