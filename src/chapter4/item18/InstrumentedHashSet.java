package chapter4.item18;

import java.util.*;

// 코드 18-1 잘못된 예 - 상속을 잘못 사용했다.
public class InstrumentedHashSet<E> extends HashSet<E> {
    // 추가된 원소의 수
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탁탁", "펑"));

        // HashSet의 addAll()이 add()를 호출하기 때문에, 의도하지 않은 addCount++이 실행된다(3이 아닌 6이 출력된다).
        System.out.println(s.getAddCount());
    }
}
