package Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherObservable implements Observable, Runnable{
    Boolean running = true;
    double temperature = randomTemperature();

    private double randomTemperature() {
        return Math.random() * 120 - 60;
    }

    List<Observer> observers = new ArrayList<>();

    public double getTemperature() {return temperature;};

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            temperature = Math.max(-60.0, Math.min(60.0, temperature + Math.random() * 10 - 5));
            notifyObservers();
            //System.out.println("Observers notified");
            //System.out.println(observers);


        }
    }

    @Override
    public void addObserver(Observer observer) {
        System.out.println(observer);
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
