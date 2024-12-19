package chapter13.practice.controller;

import chapter13.practice.model.Book;
import chapter13.practice.service.BookServiceImpl;
import chapter13.practice.view.BookView;

import java.util.List;

// 사용자의 요청을 처리
public class BookController {
    private final BookServiceImpl service = BookServiceImpl.getInstance();
    private final BookView view = new BookView();

    public void start() {
        while(true) {
            view.showMenu();
            int choice = view.getInput(); // 숫자 값을 검증하여 가져오는 메서드

            switch (choice) {
                case 1: // 책 추가: 요청 데이터 O / 반환 데이터 X
                    Book book = view.getBookDetails(); // 픽션 책일 경우, Fiction >> Book 으로 담긴다 >> 업캐스팅!
                    if (book != null) service.addBook(book);
                    else System.out.println("책은 장르 또는 분야가 필수입니다.");
                    break;
                case 2: // 전체 책 조회: 요청 데이터 X / 반환 데이터 O
                    List<Book> books = service.listAllBooks();
                    view.displayBooks(books);
                    break;
                case 3: // 단건 책 조회: 요청 데이터 O / 반환 데이터 O
                    System.out.print("찾고자 하시는 책의 ID를 입력해주세요: ");
                    int findBookId = view.getInput(); // 검색하고자 하는 Book의 ID
                    if (findBookId != -1) {
                        Book findBook = service.findBookById(findBookId); // 해당 ID로 찾은 Book 객체
                        view.displayBook(findBook); // 객체 반환
                    } else {
                        System.out.println("유효하지 않은 ID 입니다.");
                    }
                    break;
                case 4: // 책 수정: 요청 데이터 O / 반환 데이터 X
                    System.out.print("수정하고자 하는 책의 ID를 입력해주세요: ");
                    int modifiedId = view.getInput();
                    if (modifiedId != -1) {
                        Book updatedBook = view.getBookDetails();
                        if (updatedBook != null) {
                            service.updateBook(modifiedId, updatedBook);
                        } else {
                            System.out.println("도서 정보가 유효하지 않습니다.");
                        }
                    } else {
                        System.out.println("유효하지 않은 ID 입니다.");
                    }
                    break;
                case 5:
                    System.out.print("삭제하고자 하는 책의 ID를 입력해주세요: ");
                    int removedId = view.getInput();
                    if (removedId != -1) {
                        service.removeBook(removedId);
                    } else {
                        System.out.println("유효하지 않은 ID 입니다.");
                    }
                    break;
                case 0:
                    System.out.println("=== 프로그램 종료 ===");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }
}
