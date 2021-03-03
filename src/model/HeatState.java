package model;

import mediator.Model;

public abstract class HeatState
{
  public void turnUp(Radiator radiator)
  {

  }

  public void turnDown(Radiator radiator)
  {

  }

  public synchronized void startTimer(Radiator radiator, Model model)
  {

  }

  public abstract String getState();

}
