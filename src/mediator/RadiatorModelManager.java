package mediator;

import model.Radiator;

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
  }

  @Override public void turnUpRadiator()
  {
    radiator.turnUp();
  }

  @Override public void turnDownRadiator()
  {
    radiator.turnDown();
  }

  @Override public String getRadiatorStatus()
  {
    return radiator.getStatus();
  }

  @Override public void setHighTemperature(double highTemperature)
  {
    radiator.setHighTemperature(highTemperature);
  }

  @Override public double getHighTemperature()
  {
    return radiator.getHighTemperature();
  }

  @Override public void setLowTemperature(double lowTemperature)
  {
    radiator.setLowTemperature(lowTemperature);
  }

  @Override public double getLowTemperature()
  {
    return radiator.getLowTemperature();
  }

  @Override public String getHeatStateStatus(){
    return  radiator.getStatus();
  }

  @Override public int getHeatState(){
      return 0;
  }
  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }

  public void setCriticalValues(double highValue, double lowValue){
    temperature.setValues(highValue,lowValue);
  }
}
