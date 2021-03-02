package mediator;

import utility.observer.NamedPropertyChangeSubject;

public interface Model extends NamedPropertyChangeSubject
{
  void turnUp();
  void turnDown();
  String getRadiatorStatus();
  String getHeatStateStatus();
  int getHeatState();
  void setCriticalValues(double highValues, double lowValues);

}
