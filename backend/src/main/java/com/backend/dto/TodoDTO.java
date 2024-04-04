package com.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// DTO는 데이터를 담는 객체이다.
// 데이터를 담아서 보내는 편지라고 생각하면 된다.
// 시스템이 관리를 하지 않는 자료형이다.

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private String content;
    private boolean complete;
    private LocalDate dueDate;
}
