import java.util.Date;

public class WeatherByDay {
    double latitude;
    double longitude;
    String timezone;
    String date;
    String units;
    CloudCover cloudcover;
    Humidity humidity;
    Precipitation precipitation;
    Temperature temperature;
    Pressure pressure;
    Wind wind;

    public WeatherByDay(String timezone, double latitude, double longitude, String date, String units, CloudCover cloudcover, Humidity humidity, Precipitation precipitation, Temperature temperature, Pressure pressure, Wind wind) {
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.units = units;
        this.cloudcover = cloudcover;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.temperature = temperature;
        this.pressure = pressure;
        this.wind = wind;
    }
    public WeatherByDay(){}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public CloudCover getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(CloudCover cloudcover) {
        this.cloudcover = cloudcover;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Precipitation getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Precipitation precipitation) {
        this.precipitation = precipitation;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
