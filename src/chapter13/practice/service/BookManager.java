package chapter13.practice.service;

import java.util.List;

/*
* 도서 관리 시스템의 비즈니스 로직을 인터페이스화
* : CRUD 기능 정의
* */
public interface BookManager<T> {
    void addBook(T book); // 추가 기능
    List<T> listAllBooks(); // 전체 조회
    T findBookById(int id); // 단건 조회
    void updateBook(int id, T updatedBook); // 수정 기능
    void removeBook(int id); // 삭제 기능
}
