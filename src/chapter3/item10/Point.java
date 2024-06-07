package chapter3.item10;

// 단순한 불변 2차원 정수 point 클래스
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Point)) return false;

        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    // 잘못된 코드 - 리스코프 치환 원칙(서브타입은 언제나 자신의 기반 타입(base type)으로 교체할 수 있어야 한다.) 위배
    // @Override
    // public boolean equals(Object o){
    //     if(o == null || o.getClass() != this.getClass()) return false;

    //     Point p = (Point) o;
    //     return p.x == x && p.y == y;
    // }

    // 아이템 11 참조
    @Override
    public int hashCode(){
        return 31 * x + y;
    }
}
