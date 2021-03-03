package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometersViewModel implements PropertyChangeListener
{
  private StringProperty radiatorState;
  private DoubleProperty thermometer0;
  private DoubleProperty thermometer1;
  private DoubleProperty thermometer2;
  private StringProperty warningProperty;

  private Model model;

  public ThermometersViewModel(Model model)
  {
    this.model = model;
    this.thermometer0 = new SimpleDoubleProperty(0.0);
    this.thermometer1 = new SimpleDoubleProperty(0.0);
    this.thermometer2 = new SimpleDoubleProperty(0.0);
    this.warningProperty = new SimpleStringProperty(null);
    this.radiatorState = new SimpleStringProperty(model.getRadiatorStatus());
    model.addListener(this);
  }
  
  public void reset() {
  
  }

  public StringProperty getRadiatorState()
  {
    return radiatorState;
  }

  public DoubleProperty thermometer0Property()
  {
    return thermometer0;
  }

  public DoubleProperty thermometer1Property()
  {
    return thermometer1;
  }

  public DoubleProperty thermometer2Property()
  {
    return thermometer2;
  }
  
  public StringProperty getWarningProperty() {
    return warningProperty;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      try {
        switch (evt.getPropertyName()) {
          case "internalTemperature":
            if (evt.getOldValue().equals("t1")) {
              thermometer1.set((Double) evt.getNewValue());
            }
            else {
              thermometer2.set((Double) evt.getNewValue());
            }
            
            // TODO: Check if temperature is above/below critical values, and if so, update the warning property.
            break;
          case "outsideTemperature":
            thermometer0.set((Double) evt.getNewValue());
            break;
          case "Radiator":
            radiatorState.set((String) evt.getNewValue());
            break;
        }
      }
      catch (Exception e) {
        warningProperty.set(e.getMessage());
      }
    });
  }
}
