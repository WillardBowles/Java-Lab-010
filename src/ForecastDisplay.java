class ForecastDisplay implements Display {
    private WeatherStation weatherStation;
    private float currentPressure;
    private float lastPressure = Float.NaN;

    public ForecastDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
    }

    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherStation.getPressure();
        display();
    }

    public void display() {
        System.out.println("Current pressure: " + currentPressure);
    }
}