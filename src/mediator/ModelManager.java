package mediator;

import model.Radiator;

public class ModelManager implements Model
{

  private Radiator radiator;

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

}
