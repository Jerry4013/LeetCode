package Contest;

public class P5313 {
    public double angleClock(int hour, int minutes) {
        if (hour == 12) {
            hour = 0;
        }
        double h = (minutes / 60.0 + hour) * 30;
        int m = minutes * 6;
        return Math.abs(h - m) > 180 ? (360 - Math.abs(h - m)) : Math.abs(h - m);
    }

    public static void main(String[] args) {
        double v = new P5313().angleClock(3, 15);

    }
}
