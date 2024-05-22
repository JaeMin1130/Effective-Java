package chapter2.item5.singleton;

import java.util.*;

// 코드 5-2 싱글턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
public class SpellChecker {
    private final Object dictionary = new Object();

    private SpellChecker() {}
    public static final SpellChecker INSTANCE = new SpellChecker();

    public static boolean isValid(String word) {return true;}
    public List<String> suggestions(String typo) {return new ArrayList<>();}
}

