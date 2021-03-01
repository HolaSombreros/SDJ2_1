package viewmodel;

public class ViewModelFactory {

    private ThermometersViewModel firstWindowThermometerViewModel;

    public ViewModelFactory(Model model){
        firstWindowThermometerViewModel = new ThermometersViewModel(model);
    }
    public ThermometersViewModel getFirstWindowThermometerViewModel(){
        return firstWindowThermometerViewModel;
    }
}
