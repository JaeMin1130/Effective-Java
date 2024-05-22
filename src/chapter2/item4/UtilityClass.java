package chapter2.item4;

// 코드 4-1 인스턴스를 만들 수 없는 유틸리티 클래스
public class UtilityClass {
    // 기본 생성자가 만들어지는 것을 막는다(인스턴스화 방지).
    private UtilityClass() {
        throw new AssertionError(); // 클래스 안에서 실수로라도 생성자를 호출하지 않도록 해준다.
    }
}
