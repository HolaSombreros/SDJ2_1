package model;

public class OffState extends HeatState
{
  @Override public void turnUp(Radiator radiator)
  {
    radiator.setState(new LowState());
  }


  @Override public String getState()
  {
    return "OFF";
  }
}
