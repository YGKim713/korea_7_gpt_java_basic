package otherPackage;

// 부모 클래스
public class OtherClass {
    // 같은 패키지 또는 다른 패키지의 하위 클래스에서만 접근 가능
    protected String otherField = "다른 패키지의 필드";

    protected void otherMethod() {
        System.out.println("다른 패키지에 있는 메서드");
    }

    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        System.out.println(publicClass.publicField); // 어디서든지 접근 가능한 필드
        publicClass.publicMethod(); // 어디서든지 접근 가능한 메서드
    }
}
