package me.shinsunyoung.springbootdeveloper.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter // Getter 자동으로 하게해줌
@NoArgsConstructor(access = AccessLevel.PROTECTED) // proteced 생성자 대신
public class Article {

    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // title 이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder // 빌더 패턴으로 객체 생성 -> 롬북에서 지원하는 애너테이션
    public Article(String title, String content) {
        this.title= title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
