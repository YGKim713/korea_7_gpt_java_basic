package chapter13;

// Lombok(롬복) 라이브러리
// : 보일러플레이트 코드를 줄여주는 라이브러리
// - 어노테이션을 사용하여 코드를 간결하게 만들어 줌

// cf) 보일러플레이트 코드: 프로그래밍에서 반복되는 작업이나 패턴에 대한 일종의 표준화 된 코드

// 1. @Getter / @Setter 어노테이션
// : 필드에 대한 getter와 setter 메서드를 자동으로 생성

// 2. @ToString 어노테이션
// : 클래스의 toString() 메서드를 자동으로 구현
// - sout에 객체를 출력하는 경우 아래와 같이 출력
// - 클래스명(필드명1=필드값1, 필드명2=필드값2)

// 3. 생성자 어노테이션
// cf) 매개변수 - parameter(복수형: params), 인자(인수) - argument(복수형: args)

// 1) @NoArgsConstructor: 기본 생성자
// 2) @RequiredArgsConstructor: 필수 필드 생성자
// 3) @AllArgsConstructor: 전체 필드 생성자

// 4. @Data 어노테이션
// : @Setter, @Getter, @ToString, @RequiredArgsConstructor, @EqualsAndHashCode 어노테이션을 한번에 적용하는 어노테이션

// 5. @Builder 어노테이션
// : 복잡한 객체를 생성할 때 사용하는 빌더 패턴을 자동으로 구현
// - @Builder 어노테이션을 사용하는 빌더 패턴의 경우
//      필드 값을 모두 메서드 체이닝으로 가져옴
// - 클래스명.builder().build();
//      : 필수 값을 builder() 메서드의 인자로 받지 X
//      : 메서드 체이닝 내에서 누락 시 오류

import lombok.*; // * 는 전체를 의미함, 어노테이션을 많이 할 때 권장 (낭비X)
// import lombok.Getter;
// import lombok.Setter;

// @Getter     // class 위에, 또는 필드 위에 위치함
// @Setter
// @ToString
// @RequiredArgsConstructor
@Data // 위의 4개를 대체
// @NoArgsConstructor >> private final String title에 오류! final 변수가 초기화 되지 않을 가능성이 추가 되었기 때문
@AllArgsConstructor
@Builder
class LombokClass {
    // 필드에 필수값을 지정
    // : null 값이 들어갈 수 없음!

    // cf) (필드) final 키워드 - 참조 데이터 타입의 기본값으로 null이 포함될 수 있음
    @NonNull
    private final String title;
    private String author;

//  public String getTitle() { return title; }
//  public String getAuthor() { return author; }

    // toString 메서드
    // : Object 객체 클래스 내의 메서드
    // - 클래스 내의 데이터의 문자열 출력을 담당

//  @Override
//  public  String toString() {
//      return "Title: " + title + ", Author: " + author;
//  }
//  LombokClass() {} // 기본 생성자와 밑의 생성자가 같이 있으면 위의 private final String title에 오류가 남!
//                      왜? 생성자를 호출했을 때 final 변수가 초기화 될 가능성이 2가지로 나뉘기 때문
//                      즉, 기본 생성자를 호출하면 final 변수가 초기화 X, 밑의 생성자를 호출하면 초기화 O
//                      >> 초기화가 안될 가능성이 있기 때문에 오류 발생!
//  LombokClass(String title) {
//      this.title = title; // 이 줄이 없으면 위의 private final String title에 오류가 남!
// }

    // Builder 클래스
    // : 프로젝트 전역적인 접근이 가능
//  public static class Builder {
//      private final String title;
//      private String author = "작가 미상";
//
//      //빌더 클래스의 인자 - 필수 필드값이어야 함
//      public Builder(String title) {
//          this.title = title;
//      }
//
//      // 선택 필드값 설정을 위한 메서드(메서드 체이닝)
//      public Builder author(String author) {
//          this.author = author;
//          return this;
//      }
//
//      // 만들어진 Builder의 인스턴스를 LombokClass에 전달하는 build 메서드
//      public LombokClass build() {
//          return new LombokClass(this);
//      }
//  }
//
//  // build 메서드 내에서 호출 될 생성자
//  // : Builder 패턴으로 만들어진 필드 값들을 전달 받는 생성자
//  public LombokClass(Builder builder) {
//      this.title = builder.title;
//      this.author = builder.author;
//  }
}

public class H_Lombok {
    public static void main(String[] args) {
        LombokClass lombokClass1 = new LombokClass("Hello LSA", "LSA");
        // @NoArgsConstructor를 주석처리했기 때문에 () 내를 비울 수 X ---------??
        // cf) final 변수값 - 재할당 불가!
        // lombokClass1.setTitle("승아야 안녕");
        lombokClass1.setAuthor("이승아");

        LombokClass lombokClass2 = new LombokClass("Merong LDK", "LDK");
        // lombokClass2.setTitle("이도경 메롱");
        lombokClass2.setAuthor("이도경");

        System.out.println(lombokClass1); // LombokClass(title=Hello LSA, author=이승아)
        System.out.println(lombokClass2); // LombokClass(title=Merong LDK, author=이도경)

     // 정적 내부 클래스: 클래스명.내부클래스() > @Builder를 선언하지 않았을 경우
     // LombokClass lombokClass3 = new LombokClass.Builder("title")
        LombokClass lombokClass3 = LombokClass.builder() // new 연산자 X
                .title("이승아")
                .build();
        System.out.println(lombokClass3.getTitle()); // 이승아

        // @NonNull 어노테이션 필드는 반드시 생성 시 값의 할당이 이루어져야 함!
//        LombokClass lombokClass4 = LombokClass.builder()
//                .author("루피")
//                .build();
//        System.out.println(lombokClass4.getTitle()); // null >> @NonNull 이 있을 경우, null 불가 > 출력 시 Error!
//        System.out.println(lombokClass4.getAuthor()); // 루피
    }
}
