package mediator;

import model.HeatState;
import model.Radiator;
import model.Temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RadiatorModelManager implements Model
{

  private Radiator radiator;
  private PropertyChangeSupport property;
  private Temperature temperature;

  public RadiatorModelManager()
  {
    this.radiator = new Radiator();
    property = new PropertyChangeSupport(this);
    temperature = new Temperature(30,15);
  }

  @Override public void turnUp()
  {
    radiator.turnUp();
  }

  @Override public void turnDown()
  {
    radiator.turnDown();
  }


  @Override public String getRadiatorStatus()
  {
    return radiator.getStatus();
  }

  @Override public String getHeatStateStatus(){
    return  radiator.getStatus();
  }

  @Override public int getHeatState(){
      return radiator.getPower();
  }


  public void setCriticalValues(double highValue, double lowValue){
    temperature.setValues(highValue,lowValue);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }


}
