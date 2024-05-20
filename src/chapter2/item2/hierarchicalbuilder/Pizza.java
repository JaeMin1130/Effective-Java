package chapter2.item2.hierarchicalbuilder;

import java.util.*;

// 코드 2-4 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴

// 여기서 사용한 '시뮬레이트한 셀프 타입(Simulated Self-Type)' 관용구는 빌더뿐 아니라 임의의 유동적인 계층 구조를 허용한다.
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    // 재귀적 타입 한정(아이템 30)을 이용하는 제네릭 타입
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(Overriding)하여 "this"를 반환하도록 해야 한다.
        protected abstract T self();
    }   
    
    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }
}
