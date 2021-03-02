package model;

public class HighState extends HeatState
{
  private Thread timer;

  @Override public synchronized void timeOut(Radiator radiator)
  {
    this.timer = new Thread(() -> {
      try
      {
        Thread.sleep(40 * 1000);
        radiator.setState(new MediumState());
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
