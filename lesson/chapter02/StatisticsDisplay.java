import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
  
  private float maxTemp = 0.0f;
  private float minTemp = 200;
  private float tempSum = 0.0f;
  private int numReadings;

  public StatisticsDisplay(Observable observable) {
    observable.addObserver(this);
  }
  
  public void update(Observable observable, Object arg) {
    if (observable instanceof WeatherData) {
      WeatherData weatherData =(WeatherData)observable;
      float temperature = weatherData.getTempreature();
      tempSum += temperature;
      numReadings++;

      if (temperature > maxTemp) {
        maxTemp = temperature;
      }

      if (temperature < minTemp) {
        minTemp = temperature;
      }
      
      display();
    }
  }

  public void display() {
    System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
        + "/" + maxTemp + "/" + minTemp);
  }
}

