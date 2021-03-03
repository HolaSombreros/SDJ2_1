package model;

import mediator.Model;

public class HighState extends HeatState
{
  private Thread timer;

  @Override public synchronized void startTimer(Radiator radiator, Model model)
  {
    this.timer = new Thread(() -> {
      try
      {
        Thread.sleep(40 * 1000);
        radiator.setState(new MediumState());
        model.fireRadiatorStateChange();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    });
    timer.start();
  }

  @Override public void turnDown(Radiator radiator)
  {
    timer.interrupt();
    radiator.setState(new MediumState());
  }

  @Override public String getState()
  {
    return "High";
  }

}
