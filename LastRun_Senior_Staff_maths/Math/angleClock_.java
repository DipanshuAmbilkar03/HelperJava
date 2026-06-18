package LastRun_Senior_Staff_maths.Math;

class angleClock_ {
    public double angleClock(int hour, int minutes) {

        double minuteAngle = minutes * 6.0;
        double hourAngle = (hour % 12) * 30.0 + (minutes * 0.5);

        double diff = Math.abs(hourAngle - minuteAngle);

        return diff > 180 ? 360 - diff : diff;
    }
}