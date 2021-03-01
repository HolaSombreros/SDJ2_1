package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class FirstWindowThermometerController
{
    @FXML private Label thermometer0;
    @FXML private Label thermometer1;
    @FXML private Label thermometer2;
    @FXML private Label errorLabel;

    private Region root;
    private ViewHandler viewHandler;

    public FirstWindowThermometerController(){

    }
    public void init(ViewHandler viewHandler, Region root){
        this.viewHandler = viewHandler;
    }
    public Region getRoot(){
        return root;
    }
    @FXML private void settingsClicked(){

    }


}
