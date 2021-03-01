package viewmodel;

import mediator.Model;

public class ViewModelFactory
{

  private ThermometersViewModel thermometersViewModel;
  private SettingsViewModel settingsViewModel;

  public ViewModelFactory(Model model)
  {
    thermometersViewModel = new ThermometersViewModel(model);
    settingsViewModel = new SettingsViewModel(model);
  }

  public ThermometersViewModel getThermometersViewModel()
  {
    return thermometersViewModel;
  }

  public SettingsViewModel getSettingsViewModel()
  {
    return settingsViewModel;
  }
}
