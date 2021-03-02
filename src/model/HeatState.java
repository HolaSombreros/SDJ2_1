package model;

public abstract class HeatState
{
  public void turnUp(Radiator radiator)
  {

  }

  public void turnDown(Radiator radiator)
  {

  }

  public synchronized void timeOut(Radiator radiator)
  {

  }

  public abstract String getState();

}
