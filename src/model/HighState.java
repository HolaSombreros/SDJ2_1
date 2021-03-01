package model;

public class HighState extends HeatState
{

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setState(new MediumState());
  }

  @Override public void timeOut(Radiator radiator)
  {
    try
    {
      Thread.sleep(40000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    radiator.setState(new MediumState());
  }

  @Override public String getState()
  {
    return "High";
  }
}
