package mediator;

import utility.observer.NamedPropertyChangeSubject;

public interface Model extends NamedPropertyChangeSubject
{
  void turnUp();
  void turnDown();
  String getRadiatorStatus();
  int getHeatState();
  void setCriticalValues(double highValues, double lowValues);
  void updateOutsideTemperature(double t);
  void addInternalTemperature(double t);
  double getOutsideTemperature();


}
