package chapter3.item10.composition;

import chapter3.item10.Color;
import chapter3.item10.Point;

// 코드 10-5 equals 규약을 지키면서 값 추가하기
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color){
        point = new Point(x, y);
        this.color = color;
    }

    // ColorPoint 인스턴스의 Point를 반환한다.
    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ColorPoint)) return false;

        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode(){
        return 31 * point.hashCode() + color.hashCode();
    }
}
