package test;

// 1번 문제
/*
* 1) 기본 자료형
* 자바에서 기본적으로 제공해주는 자료형이며, int, double, char, boolean 이 대표적이다. 데이터를 담는 그릇이다.
* 각 기본 자료형은 타입 변환이 가능하다.
* 예시: int value = 8;
*
* - 값이 직접 저장됨
* - 값 자체를 저장하는 타입
*
* 2) 참조 자료형
* String, Integer 등이 있으며, 데이터 자체를 담는 그릇이 아닌, 데이터를 담는 주소를 할당받는다.
* 예시: String str = "Hello!";
*
* - 메모리의 주소를 저장하는 타입
* - 추가 메서드와 기능 제공
*
* */
//===================================================================================================//

// 6번 문제
// : Object

// 자바의 모든 클래스는 암시적으로 Object 클래스를 상속받음
// Object 클래스가 가진 toString(), equals() 등의 메서드를 기본적으로 가짐
//===================================================================================================//

// 7번 문제
// : size

// size() : 리스트에 저장된 요소의 개수를 반환
//===================================================================================================//

// 8번 문제
// : 이름은 기억 안나는데... 조건문 ? (참이면 실행될 문장) : (거짓이면 실행될 문장)

// 삼항 연산자 ( ? : )
// - 조건식 ? 참일 때 값 : 거짓일 때 값
// ex) int result = (a > b) ? a : b;
//===================================================================================================//

// 9번 문제
// : 3, 4

// 인터페이스에서 사용할 수 없는 것 : 생성자(4번)
// => 객체를 직접 생성할 수 없기 때문에 생성자와 같이 객체를 직접적으로 생성하는 요소 존재 불가
// 인터페이스에서 사용할 수 있는 것들:
//      추상 메서드, default 메서드, static 메서드
//      private 메서드 또한 가능
//      => 자바 8 버전 이후부터
//      접근 제어자가 생략된 메서드의 경우 기본으로 public abstract 으로만 선언
//      default 도 가능하나, static 메서드에서 private 접근 제어자 사용이 가능
//      단, private 메서드는 인터페이스 내부에서만 호출 가능!
//===================================================================================================//

// 10번 문제
// : 2

// @FunctionalInterface
//      람다식과 같이 사용됨
//      단 하나의 추상 메서드만 허용 / default 와 static 메서드에 대한 추가 정의 불가
//===================================================================================================//

// 11번 문제
// : Child

// 업캐스팅을 하면 Parent 타입의 참조 변수이지만 실제로 참조하는 객체는 Child
// >> 즉, Child 클래스에서 재정의된 메서드가 호출됨
// Child 클래스에서 display() 메서드를 재정의했기 때문에 실행 시점에 실제 객체의 메서드가 호출됨
//  >> " 동적 바인딩 "
// 단, Child 클래스 고유의 메서드는 참조 변수의 타입을 Child 타입으로 다운캐스팅 해야 호출 가능

// 업캐스팅에서 자식 메서드 실행 가능 여부
// 1) 오버라이딩 된 메서드:
//     - 부모 클래스에서 정의된 메서드를 자식 클래스에서 오버라이딩한 경우, 자식 클래스의 메서드가 호출
//     - 업캐스팅과 상관없이 실제 객체(Child)의 메서드가 실행
// 2) 자식만이 가진 고유 메서드:
//     - 업캐스팅 된 상태에서는 부모 객체 변수로 자식 클래스의 고유 메서드 호출이 불가
//     - 자식 메서드 호출 시 다운 캐스팅이 필요
//===================================================================================================//

// 12번 문제
// : 2

// 싱글톤 패턴을 구현할 때 가장 일반적으로 사용되는 메서드 : public static 메서드(1번)
//===================================================================================================//

// 13번 문제
// : 2

// 추상 클래스는 "직접적으로" 객체를 생성할 수 없음
// '자식 클래스'가 추상 메서드를 모두 구현한 후에 객체 생성 가능
//===================================================================================================//

// 14번 문제
// : class Dog extends Animal 즉, Dog 클래스가 Animal 클래스를 상속받은 상태여야 한다.

// instanceof 사용해서 다운 캐스팅이 가능한지 확인
//===================================================================================================//

// 15번 문제
// : 2

// 필드가 많거나 생성자 매개변수가 복잡한 객체를 쉽게 생성하도록 도와줌
//===================================================================================================//

// 16번 문제
// : 2

// 입력을 "처리" >> Controller(3번)
//      - 사용자 입력을 처리하고, Model 과 View 를 연결하는 역할
//===================================================================================================//

// 17번 문제
// : public abstract

// 어떤 "접근 제어자"
// >> public (abstract 또한 생략이 되어있으나, 접근 제어자 를 작성해야 하므로 abstract 는 제외)

// 자바 9 부터 private 메서드를 인터페이스 내부에서 사용 가능
//===================================================================================================//

// 18번 문제
// : 3(상수는 필드가 아닌가..?), 4

// 추상 클래스 - 생성자 O , 정적 메서드 O
// 추상 클래스와 인터페이스 둘 다 static 메서드 포함 가능
// 인터페이스는 필드 X (상수는 필드가 아님)
//===================================================================================================//

// 19번
// : 답안지를 작성하다 보니... 전부 다 다시 공부해야 할 것 같습니다..... 복습 열심히 하겠습니다!
//   특히 최근에 배운 것들은 제게는 조금 어려운 것 같습니다. MVC 모델부터 다시 열심히 공부해야겠습니다..
//   잘 할 수 있겠죠? 화이팅!! 해내겠습니다!!!



// 20번
// : 하나부터 열까지 꼼꼼하게, 게다가 정말 쉽게 설명해주셔서 정말 감사합니다!
//   질문에 대해 쉽게 알아들을 수 있도록 설명해주시는 것도 정말 감사합니다!!!
//   정말 열심히 공부하겠습니다..!!!!!!


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// @AllArgsConstructor
class Student {
    private String name;
    private int score;

    Student (String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
}

public class Test_김영경 {
    public static void main(String[] args) {
        // 2번 문제
        int num1 = 10;
        double num2 = 3.5;
        double result = num1 + num2;
        System.out.println(result);

        // 3번 문제
        Scanner scanner = new Scanner(System.in);
        int userNumber = scanner.nextInt();
        if (userNumber % 2 == 0) {
            System.out.println("입력하신 숫자는 짝수입니다.");
        } else {
            System.out.println("입력하신 숫자는 홀수입니다.");
        }

//      scanner.close()

        // 4번 문제
        int[] numbers = {1, 2, 3, 4, 5};
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 5번 문제
        // : class Test 바로 위에 클래스를 작성하고 main 메서드 내부에서 객체를 생성하세요.
        Student student1 = new Student("John", 85);
        Student student2 = new Student("Jane", 92);
        Student student3 = new Student("Tom", 78);
        Student student4 = new Student("Emily", 88);
        Student student5 = new Student("Alex", 95);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

//      Student[] student = {                   위의 코드보다 더 간결하게 작성 가능
//              new Student("John", 85),        학생의 수가 5명으로 정해져있으므로, 일반 배열을 사용
//              new Student("Jane", 92),
//              new Student("Tom", 78),
//              new Student("Emily", 88),
//              new Student("Alex", 95)
//      }

        for (Student student : students) {
            if(student.getScore() > 90) { // >= 90
                System.out.println(student.getName());
            }
        }

    }
}
