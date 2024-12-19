package chapter08;

// instanceof 연산자 - A instanceof B
// : "A 객체가 B 클래스(종류)와 같은지 확인해줘" 도구
// > 확인의 결괏값을 boolean 으로 반환

class 동물 {}

class 고양이 extends 동물 {}

class 강아지 extends 동물 {}

public class Instanceof {
    public static void main(String[] args) {
        동물 애니멀 = new 동물();
        동물 나비 = new 고양이();
        동물 멍멍이 = new 강아지();

        if (애니멀 instanceof 고양이) {
            System.out.println("실행 되지 않음! 부모 객체를 자식 객체에 자동으로 담을 수 없음"); // 실행이 되지 않는다
        }

        // 고양이 고양이로바꿈 = (고양이) 애니멀;
        // : 형 변환을 시킬 수 없는 상황

        if (나비 instanceof 고양이 && 나비 instanceof 동물) {
            System.out.println("성공");  // 성공
        }

        if (멍멍이 instanceof 고양이){
            System.out.println("성공?");  // 실행이 되지 않는다
        }
    }
}
