/**
 *
 * @author Trevor Hartman
 * @author Willard B
 *
 * @since Version 1.0
 *
 */


class CurrentConditions implements Display {
    private WeatherStation weatherStation;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditions(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
    }

    public void update() {
        temperature = weatherStation.getTemperature();
        humidity = weatherStation.getHumidity();
        pressure = weatherStation.getPressure();
        display();
    }

    public void display() {
        System.out.printf("Current: %.1f°F, %.1f%% humidity, %.2f inHg pressure\n", temperature, humidity, pressure);
    }
}
