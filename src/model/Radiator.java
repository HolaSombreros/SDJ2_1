package model;

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

  public void timeout()
  {
    heatState.timeOut(this);
  }

  public void setState(HeatState heatState)
  {
    this.heatState = heatState;
  }

  public String status()
  {
    return heatState.getState();
  }
}
