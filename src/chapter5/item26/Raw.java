package chapter5.item26;

import java.util.*;

// 코드 26-4 런타임에 실패한다(unsafeAdd 메서드가 로 타입(List)을 사용).
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, "iru");
        unsafeAdd(strings, Integer.valueOf(3989)); // 컴파일러가 자동으로 형변환 코드를 넣어준다.
        String s = strings.get(0); 
        System.out.println(s);
    }

    private static void unsafeAdd(List list, Object o){
        list.add(o);
    }
}
