package model;

public class Radiator
{
  private HeatState heatState;
  private double highTemperature;
  private double lowTemperature;

  public Radiator()
  {
    heatState = new OffState();
  }

  public void turnUp()
  {
    heatState.turnUp(this);
  }

  public void turnDown()
  {
    heatState.turnDown(this);
  }

  public void timeout()
  {
    heatState.timeOut(this);
  }

  public void setState(HeatState heatState)
  {
    this.heatState = heatState;
  }

  public String getStatus()
  {
    return heatState.getState();
  }

  public void setHighTemperature(double highTemperature)
  {
    this.highTemperature = highTemperature;
  }

  public double getHighTemperature()
  {
    return highTemperature;
  }

  public void setLowTemperature(double lowTemperature)
  {
    this.lowTemperature = lowTemperature;
  }

  public double getLowTemperature()
  {
    return lowTemperature;
  }
}
