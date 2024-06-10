package chapter3.item11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// equals를 재정의하면 hashCode도 재정의해야 함을 보여준다.
public final class PhoneNumber {
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
        if (o == this)
            return true;

        if (!(o instanceof PhoneNumber))
            return false;

        PhoneNumber pn = (PhoneNumber) o;

        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    // // 코드 11-2 전형적인 hashCode 메서드
    // @Override
    // public int hashCode() {
    //     int result = Short.hashCode(areaCode);
    //     result = 31 * result + Short.hashCode(prefix);
    //     result = 31 * result + Short.hashCode(lineNum);

    //     return result;
    // }

    // // 코드 11-3 한 줄짜리 hashCode 메서드(성능 안 좋음)
    // @Override
    // public int hashCode() {
    //     return Objects.hash(lineNum, prefix, areaCode);
    // }

    // 해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야 한다.
    private int hashCode; // 자동으로 0으로 초기화된다.

    @Override
    public int hashCode() {
        int result = hashCode;

        // hashCode가 이미 있으면 초기화X
        if(result == 0){
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }

        return result;
    }

    // hashCode 없이는 제대로 동작하지 않는다.
    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "제니");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
