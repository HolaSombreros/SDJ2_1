package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler {

    private Scene currentScene;
    private Stage primaryStage;
    private ViewModelFactory viewModelFactory;
    private ThermometersController thermometersController;

    public ViewHandler(ViewModelFactory viewModelFactory){
        this.viewModelFactory = viewModelFactory;
        currentScene = new Scene(new Region());
    }
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        openView("thermometers");
    }
    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "thermometers":
                root = loadThermometersView("FirstWindowThermometer.fxml");
        }
        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    public void closeView()
    {
        primaryStage.close();
    }

    public Region loadThermometersView(String fxmlFile){
        if(thermometersController == null){
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                thermometersController = loader.getController();
                thermometersController.init(this, viewModelFactory.getThermometersViewModel(),root);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            thermometersController.reset();
        }
        return thermometersController.getRoot();
    }

}
