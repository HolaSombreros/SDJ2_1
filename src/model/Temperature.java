package model;

public class Temperature
{

  private double highValue;
  private double lowValue;

  public Temperature(double highValue, double lowValue)
  {
    this.highValue = highValue;
    this.lowValue = lowValue;
  }

  public double getHighValue()
  {
    return highValue;
  }

  public double getLowValue()
  {
    return lowValue;
  }

  public void setValues(double highValue, double lowValue)
  {
    if (highValue < lowValue)
      throw new IllegalArgumentException("High temperature can not be lower than the low temperature");
    this.highValue = highValue;
    this.lowValue = lowValue;
  }
}
