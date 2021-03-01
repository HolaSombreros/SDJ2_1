package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.ThermometersViewModel;

public class ThermometersController
{
    @FXML private Label thermometer0;
    @FXML private Label thermometer1;
    @FXML private Label thermometer2;
    @FXML private Label errorLabel;

    private Region root;
    private ViewHandler viewHandler;
    private ThermometersViewModel thermometersViewModel;

    public ThermometersController(){

    }
    public void init(ViewHandler viewHandler, ThermometersViewModel thermometersViewModel, Region root){
        this.viewHandler = viewHandler;
        this.thermometersViewModel = thermometersViewModel;
        this.root= root;

        thermometer0.textProperty().bind(thermometersViewModel.thermometer0Property());
        thermometer1.textProperty().bind(thermometersViewModel.thermometer1Property());
        thermometer2.textProperty().bind(thermometersViewModel.thermometer2Property());
        errorLabel.textProperty().bind(thermometersViewModel.errorLabelProperty());
    }
    public Region getRoot(){
        return root;
    }
    @FXML private void settingsClicked(){

    }
    public void reset(){
        //dsjhgsds
    }


}
