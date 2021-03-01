package model;

public class MediumState extends HeatState
{
  @Override public void turnUp(Radiator radiator)
  {
    radiator.setState(new HighState());
    radiator.timeout();
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setState(new LowState());
  }

  @Override public String getState()
  {
    return "Medium";
  }
}
