package com.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Builder
 */

// Entity는 DB테이블에서 1개의 테이블을 의미한다
@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_todo")
public class Todo {

    //    GeneratedValue는 키 생성 방법이다
    // 테이블에서 primary 키가 된다.
    @Id
    // tno는 자동으로 생성되는 생성되는 방식을 정의 한다.
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tno;

    @Setter
    private boolean complete;

    // 내용을 바꿀 수 있게 만든다.
    @Setter
    @Column(length = 500, nullable = false)
    private String title;

    @Setter
    private String content;

    private LocalDate dueDate;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }

    public void changeComplete(boolean complete) {
        this.complete = complete;
    }

    public void changeDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}