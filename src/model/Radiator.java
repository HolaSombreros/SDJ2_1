package model;

import mediator.Model;

public class Radiator
{
  private HeatState heatState;

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

  public void startTimer(Model model)
  {
    heatState.startTimer(this, model);
  }

  public void setState(HeatState heatState)
  {
    this.heatState = heatState;
  }

  public String getStatus()
  {
    return heatState.getState();
  }

  public int getPower()
  {
    switch (getStatus())
    {
      case "Off":
        return 0;
      case "Low":
        return 1;
      case "Medium":
        return 2;
      case "High":
        return 3;
      default:
        return -1;
    }
  }
}
