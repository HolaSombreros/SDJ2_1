package utility.external;

import mediator.Model;

public class ExternalThermometer implements Runnable
{
    private double lastTemperature;
    private Model model;

    public ExternalThermometer(Model model){
        this.model = model;
        lastTemperature = 0;
    }

    public double externalTemperature(double lastTemperature, double min, double max){
        double left = lastTemperature - min;
        double right = max - lastTemperature;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        lastTemperature += sign * Math.random();
        return lastTemperature;
    }



    @Override
    public void run()
    {
        while(true){
            try{
                Thread.sleep(10000);
                model.updateOutsideTemperature(externalTemperature(lastTemperature, -20, 20));
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
