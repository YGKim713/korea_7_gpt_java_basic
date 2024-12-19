package chapter04;

// 클래스 생성 Book
// - 속성 3개, 메서드 1개

class Book {
    // 클래스 내부의 데이터(속성, 필드)
    String title; // 책 제목
    String publisher; // 출판사
    int pageNumber; // 책 페이지 수

    // 클래스 내부의 동작(행동, 메서드)
    void displayInfo() {
        System.out.println(title + " - " + publisher);
        // 반환 타입이 void이기 때문에 return 이 없어도 됨
        return;
        // System.out.println("안녕하세요"); - return으로 무조건 끝나기 때문에 Unreachable statement 오류 발생
        //                                      즉, 해당 코드는 읽히지 않음
    }

    int returnPageNumber () {
        return this.pageNumber;
    }

    // === 생성자 함수 === //
    // : new 연산자 사용 시 호출 될 메서드
    // > 생략 시 속성에 기본값이 할당
    //      - 기본 타입: int(0), boolean(false), char(' ')
    //      - 참조 타입: null

    // +) 사용자 정의 생성자 함수 생략 시
    //      클래스명과 동일하면서 매개변수가 없는 메서드가 생략
    Book() {

    }

    Book(String title, String publisher, int pageNumber) {
        this.title = title;
        this.publisher = publisher;
        this.pageNumber = pageNumber;
    }
}

public class Object04 {
    public static void main(String[] args) {
        Book myBook = new Book(); // 위에 Book(){} 이 없어도 오류가 안남 >> 선언 시 기본적으로 제공 (생략되어있음)
                                    // 하지만, Book(String...)이 생겼기 때문에 Book()이 또 있어야 인식 가능.
                                    // 어떤 Book인지 알고 싶으면, ctrl + Book클릭
        System.out.println(myBook.title); // null
        System.out.println(myBook.publisher); // null
        System.out.println(myBook.pageNumber); // 0

        Book anotherBook = new Book("백설공주", "코리아IT아카데미", 50);
        Book thirdBook = new Book("신데렐라", "에이원플라자", 100);

        System.out.println(anotherBook.title); // 백설공주
        System.out.println(anotherBook.pageNumber); // 50

        System.out.println(thirdBook.publisher); // 에이원플라자
        System.out.println(thirdBook.title); // 신데렐라

        // 메서드 호출
        anotherBook.displayInfo(); // 백설공주 - 코리아IT아카데미
        int thirdBookPagenumber = thirdBook.returnPageNumber();
        System.out.println(thirdBookPagenumber); // 100

        myBook.displayInfo(); // null - null

        myBook.title = "개구리왕자";
        myBook.publisher = "안녕출판사";
        myBook.pageNumber = 1234;

        myBook.displayInfo(); // 개구리왕자 - 안녕출판사
    }
}
