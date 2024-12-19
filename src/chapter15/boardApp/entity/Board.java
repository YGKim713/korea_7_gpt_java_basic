package chapter15.boardApp.entity;

import lombok.Data;

/*
* Board 게시판
* - id: 게시판 고유 번호
* - title: 게시판 제목
* - content: 게시판 내용
* - author: 게시판 작성자
* */

// 매개변수 3가지 값을 가지고 온 뒤, 전달받은 매개변수를 각각 필드에 삽입
// BoardRequestDto 에서 Board()를 만들어 Entity 에 전달 => 데이터베이스에 저장
// 데이터베이스에서 가져올때는 DB의 Entity 로부터 BoardResponseDto 로 데이터 가져와서 응답값을 프론트엔드에 전달

@Data // getter, setter, toString
public class Board {
    private long id;
    private String title;
    private String content;
    private String author;

    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
