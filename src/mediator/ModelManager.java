package mediator;

import model.Radiator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{

  private Radiator radiator;
  PropertyChangeSupport property;

  public ModelManager()
  {
    this.radiator = new Radiator();
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

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }
}
