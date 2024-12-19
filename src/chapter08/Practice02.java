package chapter08;

// === 인터페이스 === //
// Fruit 과일 인터페이스 정의
// - color: 추상 메서드
// - describe: 디폴트 메서드
// - printType: 정적 메서드

interface Fruit {
    // 인터페이스의 추상 메서드
    // : public abstract 이 생략 되어 있음 (cf. 추상 클래스의 추상 메서드와 다름 !)
    String color(); // 추상 메서드

    // 디폴트 메서드: 재정의(오버라이딩) 가능
    default void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 모양은 동그랗습니다.");
    }

    // 정적 메서드: 재정의(오버라이딩) 불가능
    static void printType() {
        System.out.println("과일(Fruit)의 타입입니다.");
    }
}

class Apple implements Fruit {
    public String color() {
        return "red";
    }
}

class Orange implements Fruit {
    public String color() {
        return "orange";
    }
}

class Banana implements Fruit {
    public String color() {
        return "yellow";
    }
    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 모양은 깁니다.");
    }
}

// === 또 다른 인터페이스 === //
interface TropicalFruit extends Fruit {
    // extends (상속 - 확장하다)
    // : 클래스 간에, 인터페이스 간에 가능 (class <-> class , interface <-> interface)

    // cf) implements (구현 - 구현하다)
    // : 인터페이스를 클래스로 구현 (class <- interface)
    default void tropicalFeature() {
        // 열대 과일의 특징
        System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
    }
}

class Mango implements TropicalFruit {
    public String color() {
        return "golden";
    }

    @Override
    public void describe() {
        System.out.println("과일의 색상은 " + color() + "이며, 모양은 타원형입니다.");
    }
}

public class Practice02 {
    public static void main(String[] args) {
        // 다형성 적용
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        Fruit banana = new Banana();
        TropicalFruit mango = new Mango();

        // == 다형성 예제 == //
        // mango가 Fruit로 형 변환 (업캐스팅) - TropicalFruit 은 Fruit 을 상속받기 때문에 자동 형 변환이 됨
        Fruit[] fruits = { apple, orange, banana, mango };

        for (Fruit fruit : fruits) {
            fruit.describe();

            if (fruit instanceof TropicalFruit) { // mango 에서만 실행됨
                TropicalFruit tropicalFruit = (TropicalFruit) fruit; // 다운 캐스팅
                tropicalFruit.tropicalFeature(); // 열대 과일은 후숙하면 더 맛있습니다.
            }
        }



        if (mango instanceof Fruit) {
            Fruit mangoAsFruit = (Fruit) mango;
            mangoAsFruit.describe(); // 과일의 색상은 golden이며, 모양은 타원형입니다.
        }

        if (banana instanceof TropicalFruit) { // banana는 TropicalFruit에 해당되지 않기 때문에 false 값을 가짐
            TropicalFruit bananaAsTropical = (TropicalFruit) banana;
            bananaAsTropical.tropicalFeature();                         // 실행이 되지 않는다
        } else {
            System.out.println("바나나는 열대 과일이 아닙니다."); // 바나나는 열대 과일이 아닙니다.
        }

        Fruit.printType(); // 과일(Fruit)의 타입입니다.
    }
}
