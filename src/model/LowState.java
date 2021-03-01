package model;

public class LowState extends HeatState
{
  @Override public void turnUp(Radiator radiator)
  {
    radiator.setState(new MediumState());
  }

  @Override public void turnDown(Radiator radiator)
  {
    radiator.setState(new OffState());
  }

  @Override public String getState()
  {
    return "Low";
  }
}
