package chapter3.item14;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import static java.util.Comparator.*;

// PhoneNumber를 비교할 수 있게 만든다.
public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof chapter3.item11.PhoneNumber)) return false;
       
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override 
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    @Override 
    public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    // 코드 14-2 기본 타입 필드가 여럿일 때의 비교자
    // @Override
    // public int compareTo(PhoneNumber pn) {
    //     int result = Short.compare(areaCode, pn.areaCode);
    //     if(result == 0){
    //         result = Short.compare(prefix, pn.prefix);
    //         if(result == 0){
    //             result = Short.compare(lineNum, pn.lineNum);
    //         }
    //     }
    //     return result;
    // }

    // 코드 14-3 비교자 생성 
    // 자바의 정적 임포트 기능을 이용하면 정적 비교자 생성 메서드들을 그 이름만으로 사용할 수 있어 코드가 훨씬 깔끔해진다.
    private static final Comparator<PhoneNumber> COMPARATOR = 
            comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn ->  pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);
    
    @Override
    public int compareTo(PhoneNumber pn){
        return COMPARATOR.compare(this, pn);
    }

    private static PhoneNumber randomPhoneNumber() {
        Random rnd = ThreadLocalRandom.current();
        return new PhoneNumber((short) rnd.nextInt(1000),
                               (short) rnd.nextInt(1000),
                               (short) rnd.nextInt(10000));
    }

    public static void main(String[] args) {
        NavigableSet<PhoneNumber> s = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            s.add(randomPhoneNumber());
        }
        System.out.println(s);
    }
}
