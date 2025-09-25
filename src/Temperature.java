public class Temperature {
    float min;
    float max;
    float afternoon;
    float night;
    float evening;
    float morning;

    public Temperature(float min, float max, float afternoon, float night, float evening, float morning) {
        this.min = min;
        this.max = max;
        this.afternoon = afternoon;
        this.night = night;
        this.evening = evening;
        this.morning = morning;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(float afternoon) {
        this.afternoon = afternoon;
    }

    public float getNight() {
        return night;
    }

    public void setNight(float night) {
        this.night = night;
    }

    public float getEvening() {
        return evening;
    }

    public void setEvening(float evening) {
        this.evening = evening;
    }

    public float getMorning() {
        return morning;
    }

    public void setMorning(float morning) {
        this.morning = morning;
    }

}
