package chapter3.item14;

import java.util.*;

// Comparable 구현 시의 이점
public class WordList {

    // // 코드 14-4 해쉬코드 값의 차를 기준으로 하는 비교자 - 추이성 위배
    // static Comparator<Object> hashCodeOrder = new Comparator<>() {
    //     public int compare(Object o1, Object o2){
    //         return o1.hashCode() - o2.hashCode();
    //     }
    // };

    // // 코드 14-5 정적 comapre 메서드를 활용한 비교자
    // static Comparator<Object> hashCodeOrder = new Comparator<>(){
    //     public int compare(Object o1, Object o2){
    //         return Integer.compare(o1.hashCode(), o2.hashCode());
    //     }
    // }

    // 코드 14-6 비교자 생성 메서드를 활용한 비교자
    static Comparator<Object> hashCodeOrder = Comparator.comparingInt(o -> o.hashCode());
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}