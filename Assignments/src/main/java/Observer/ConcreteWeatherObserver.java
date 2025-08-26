package Observer;

public class ConcreteWeatherObserver extends Observer {
    private final int id;

    private WeatherObservable subject;

    public ConcreteWeatherObserver(int id, WeatherObservable observable) {
        this.id = id;
        this.subject = observable;
        subject.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Weather "+ id +" temp: " + subject.getTemperature());
    }
}
