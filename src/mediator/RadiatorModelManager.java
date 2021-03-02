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


  public RadiatorModelManager()
  {
    this.radiator = new Radiator();
    property = new PropertyChangeSupport(this);
    criticalValues = new Temperature(30,15);
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

  @Override
  public void updateOutsideTemperature(double t) {

  }

  @Override
  public void addInternalTemperature(double t) {

  }

  @Override
  public double getOutsideTemperature() {
     return  0;
  }

  @Override public void setCriticalValues(double highValue, double lowValue){
    criticalValues.setValues(highValue,lowValue);
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
