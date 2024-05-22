package chapter2.item5.dependencyinjection;

import java.util.*;

// 코드 5-3 의존 객체 주입은 유연성과 테스트 용이성을 높여준다.
public class SpellChecker {
    private final Object dictionary;

    public SpellChecker(Object dictionary){
        this.dictionary = Objects.requireNonNull(dictionary);
    }
    
    public static boolean isValid(String word) {return true;}
    public List<String> suggestions(String typo) {return new ArrayList<>();}
}
