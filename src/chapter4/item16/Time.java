package chapter4.item16;

// 코드 16-3 불변 필드를 노출한 public 클래스 - 불변식은 보장할 수 있다.
public class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUT = 60;

    public final int hour;
    public final int minute;

    public Time(int hour, int minute){
        if(hour < 0 || hour >= HOURS_PER_DAY)
            throw new IllegalArgumentException("Hour: " + hour);
        if(minute < 0 || minute >= MINUTES_PER_HOUT)
            throw new IllegalArgumentException("Min: " + minute);
        this.hour = hour;
        this.minute = minute;
    }
}
