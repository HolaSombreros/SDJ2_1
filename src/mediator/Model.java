package mediator;

import model.Temperature;
import utility.observer.NamedPropertyChangeSubject;

public interface Model extends NamedPropertyChangeSubject
{
  void turnUp();
  void turnDown();
  String getRadiatorStatus();
  int getHeatState();
  void setCriticalValues(double highValues, double lowValues);
  void updateOutsideTemperature( double t);
  void addInternalTemperature(String id,double t);
  double getOutsideTemperature();
  void fireRadiatorStateChange();
  Temperature getCriticalValues();

}
