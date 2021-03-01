package mediator;

public interface Model
{
  void turnUpRadiator();
  void turnDownRadiator();
  String getRadiatorStatus();
  void setHighTemperature(double highTemperature);
  double getHighTemperature();
  void setLowTemperature(double lowTemperature);
  double getLowTemperature();
}
