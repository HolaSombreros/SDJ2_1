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
  private Temperature criticalValues;
  private double outsideTemp;
  private double internalTemp;

  public RadiatorModelManager()
  {
    this.radiator = new Radiator();
    property = new PropertyChangeSupport(this);
    criticalValues = new Temperature(25, 15);
  }

  @Override public void turnUp()
  {
    radiator.turnUp();
    if (getHeatState() == 3) {
      radiator.startTimer(this);
    }
    fireRadiatorStateChange();
  }

  @Override public void turnDown()
  {
    radiator.turnDown();
    fireRadiatorStateChange();
  }
  
  @Override
  public void fireRadiatorStateChange() {
    property.firePropertyChange("Radiator", null, getRadiatorStatus());
  }
  
  @Override
  public Temperature getCriticalValues() {
    return criticalValues;
  }
  
  @Override public String getRadiatorStatus()
  {
    return radiator.getStatus();
  }

  @Override synchronized public int getHeatState()
  {
    return radiator.getPower();
  }

  @Override public void updateOutsideTemperature(double t)
  {
    outsideTemp = t;
    property.firePropertyChange("outsideTemperature", null, outsideTemp);
  }

  @Override public synchronized void addInternalTemperature(String id, double t)
  {
    internalTemp = t;
    property.firePropertyChange("internalTemperature", id, internalTemp);
    if (internalTemp > criticalValues.getHighValue() ||
        internalTemp < criticalValues.getLowValue()) {
      property.firePropertyChange("criticalValues", null, internalTemp);
    }
  }

  @Override public synchronized double getOutsideTemperature()
  {
    return outsideTemp;
  }
  
  @Override public void setCriticalValues(double highValue, double lowValue)
  {
    criticalValues.setValues(highValue, lowValue);
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
