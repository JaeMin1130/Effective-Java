package chapter2.item6;

import java.util.regex.Pattern;

// 값비싼 객체를 재사용해 성능을 개선한다.
public class RomanNumerals {

    // 코드 6-1 성능을 더 끌어올릴 수 있다.
    static boolean isRomanNumeralSlow(String s) {
        // String.matches()가 내부에서 만드는 정규표현식용 Pattern 인스턴스는 한 번 쓰고 버려져서 곧바로 카비지 컬렉션 대상이
        // 된다.
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // 코드 6-2 값비싼 객체를 재사용해 성능을 개선한다.
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = 1;
        int numReps = 1;
        boolean b = false;
        long start = 0;
        long end = 0;

        for (int i = 0; i < numSets; i++) {
            for (int j = 0; j < numReps; j++) {
                start = System.nanoTime();
                b ^= isRomanNumeralSlow("MCMLXXVI"); // ^ : 둘 중 하나가 true일 경우에만 true
                end = System.nanoTime();
                System.out.println(((end - start) / (1_000. * numReps)) + " μs.");

                start = System.nanoTime();
                b ^= isRomanNumeralFast("MCMLXXVI");
                end = System.nanoTime();
                System.out.println(((end - start) / (1_000. * numReps)) + " μs.");
            }
        }

        // VM이 최적화하지 못하게 막는 코드
        if (!b)
            System.out.println();
    }
}
