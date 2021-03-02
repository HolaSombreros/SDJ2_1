import javafx.application.Application;
import javafx.stage.Stage;
import mediator.*;
import utility.external.ExternalThermometer;
import utility.external.InternalThermometer;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{

  public void start(Stage primaryStage)
  {
    Model model = new RadiatorModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);

    ExternalThermometer t0 = new ExternalThermometer(model);
    InternalThermometer t1 = new InternalThermometer(model,"t1",0, 1,model.getOutsideTemperature());
    InternalThermometer t2 = new InternalThermometer(model, "t2" ,0, 7, model.getOutsideTemperature());

    Thread thread0 = new Thread(t0);
    Thread thread1  = new Thread(t1);
    Thread thread2 = new Thread(t2);

    thread0.start();
    thread1.start();
    thread2.start();
  }
}

