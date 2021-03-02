package mediator;

import utility.observer.NamedPropertyChangeSubject;

public interface Model extends NamedPropertyChangeSubject
{
  void turnUpRadiator();
  void turnDownRadiator();
  String getRadiatorStatus();
  void setHighTemperature(double highTemperature);
  double getHighTemperature();
  void setLowTemperature(double lowTemperature);
  double getLowTemperature();
  String getHeatStateStatus();
  int getHeatState();

}
