package chapter2.item5.staticutility;

import java.util.*;

// 코드 5-1 정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
public class SpellChecker {
    private static final Object dictionary = new Object();

    private SpellChecker() {} // 인스턴스화 방지

    public static boolean isValid(String word) {return true;}
    public List<String> suggestions(String typo) {return new ArrayList<>();}
}
