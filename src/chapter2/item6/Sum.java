package chapter2.item6;

// 코드 6-3 불필요한 객체를 만들어내는 예 : 오토박싱(Auto Boxing)
public class Sum {
    private static long sum() {
        // sum 변수를 long이 아닌 Long으로 선언해서 불필요한 Long 인스턴스가 만들어진다.
        Long sum = 0L;

        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;

        return sum;
    }

    public static void main(String[] args) {
        long x = 0;
        long start = System.nanoTime();
        x += sum();
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000. + " ms.");

        // VM이 최적화하지 못하게 막는 코드
        if (x == 42)
            System.out.println();
    }
}
