package Observer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WeatherObservable subject = new WeatherObservable();

        Observer weather1 = new ConcreteWeatherObserver(1, subject);
        Observer weather2 = new ConcreteWeatherObserver(2, subject);
        Observer weather5 = new ConcreteWeatherObserver(5, subject);

        Thread weatherThread = new Thread(subject);
        weatherThread.start();

        Thread.sleep(8000);
        subject.removeObserver(weather2);
    }
}
