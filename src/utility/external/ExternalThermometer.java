package utility.external;

import mediator.Model;

public class ExternalThermometer implements Runnable
{
  private double lastTemperature;
  private Model model;
  private static final int MIN = -8;
  private static final int MAX = 20;
  private static final int STARTING_TEMPERATURE = 5;
  private static final int SLEEP_TIME = 10000;

  public ExternalThermometer(Model model)
  {
    this.model = model;
    lastTemperature = STARTING_TEMPERATURE;
  }

  public double externalTemperature(double lastTemperature, double min, double max)
  {
    double left = lastTemperature - min;
    double right = max - lastTemperature;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    lastTemperature += sign * Math.random();
    this.lastTemperature = lastTemperature;
    return lastTemperature;
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        Thread.sleep(SLEEP_TIME);
        model.updateOutsideTemperature(Math.round(externalTemperature(lastTemperature, MIN, MAX) * 100.0) / 100.0);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

}
