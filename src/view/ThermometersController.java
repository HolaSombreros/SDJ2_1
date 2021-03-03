package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.DoubleStringConverter;
import viewmodel.ThermometersViewModel;

public class ThermometersController
{
    @FXML private Label radiatorStateLabel;
    @FXML private Label thermometer0;
    @FXML private Label thermometer1;
    @FXML private Label thermometer2;
    @FXML private Label warningLabel;

    private Region root;
    private ViewHandler viewHandler;
    private ThermometersViewModel thermometersViewModel;

    public ThermometersController(){

    }
    
    public void init(ViewHandler viewHandler, ThermometersViewModel thermometersViewModel, Region root){
        this.viewHandler = viewHandler;
        this.thermometersViewModel = thermometersViewModel;
        this.root= root;

        radiatorStateLabel.textProperty().bind(thermometersViewModel.getRadiatorState());
        Bindings.bindBidirectional(thermometer0.textProperty(), thermometersViewModel.thermometer0Property(), new DoubleStringConverter());
        Bindings.bindBidirectional(thermometer1.textProperty(), thermometersViewModel.thermometer1Property(), new DoubleStringConverter());
        Bindings.bindBidirectional(thermometer2.textProperty(), thermometersViewModel.thermometer2Property(), new DoubleStringConverter());
        warningLabel.textProperty().bind(thermometersViewModel.getWarningProperty());
    }
    
    public Region getRoot(){
        return root;
    }
    
    @FXML private void settingsClicked(){
        viewHandler.openView("settings");
    }
    
    @FXML
    private void temperatures() {
        viewHandler.openView("temperaturesView");
    }
    
    public void reset(){
        thermometersViewModel.reset();
    }
}
