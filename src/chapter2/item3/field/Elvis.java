package chapter2.item3.field;

// 코드 3-1 public static final 필드 방식의 싱글턴
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {}

    // 싱글턴임을 보장해주는 readResolve 메서드
    // 이렇게 하지 않으면 직렬화된 인스턴스를 역직렬화할 때마다 새로운 인스턴스가 만들어진다.
    private Object readResolve(){
        // '진짜' Elvis를 반환하고, 가짜 Elvis는 가비지 컬렉터에 맡긴다.
        return INSTANCE;
    }

    public void leaveTheBuilding(){
        System.out.println("Whoa baby, I'm outta here!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다.
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
