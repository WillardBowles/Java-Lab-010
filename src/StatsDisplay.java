/**
 *
 * @author Trevor Hartman
 * @author Willard B
 *
 * @since Version 1.0
 *
 */

class StatsDisplay implements Display {
    private WeatherStation weatherStation;
    private float temperatureMin;
    private float temperatureMax;
    private float tempRunningTotal;
    private int numReadings;

    public StatsDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
    }

    public void update() {
        float temperature = weatherStation.getTemperature();
        if (numReadings == 0 || temperature < temperatureMin) {
            temperatureMin = temperature;
        }
        if (numReadings == 0 || temperature > temperatureMax) {
            temperatureMax = temperature;
        }
        tempRunningTotal += temperature;
        numReadings++;
        display();
    }

    public void display() {
        System.out.printf("Temperature statistics: Min=%.1f°F, Max=%.1f°F, Avg=%.1f°F\n", temperatureMin, temperatureMax, tempRunningTotal / numReadings);
    }
}