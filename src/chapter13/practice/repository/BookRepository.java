package chapter13.practice.repository;

import chapter13.practice.model.Book;

import java.util.ArrayList;
import java.util.List;

// 도서를 저장하고 검색 및 삭제하는 데이터 저장소 >> 데이터베이스 대체
public class BookRepository {
    private List<Book> books = new ArrayList<>(); // 데이터베이스

    public void save(Book book) {
        books.add(book);
    }

    public void deleteById(int id) {
//      Book bookToRemove = null;
//
//      for (Book book : books) {
//          if (book.getId() == id) {
//              bookToRemove = book;        // book을 bookToRemove에 담고 종료
//              break;
//          }
//      }
//
//        if (bookToRemove != null) {
//            books.remove(bookToRemove);     // bookToRemove에 담겨진 book을 삭제
//        }
        for (Book book : books) {       // 위의 코드를 짧은 로직으로도 구현 가능
            if (book.getId() == id) {   // void 타입으로 삭제 >> 삭제된 데이터는 사용하지 X
                books.remove(book);     // 위의 코드는 삭제된 데이터를 다시 사용해야할 때
                break;
            }
        }
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; // 해당하는 ID의 책이 없을 경우
    }

    public List<Book> findAll() {
        return books;
    }
}
