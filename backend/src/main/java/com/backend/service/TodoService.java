package com.backend.service;

import com.backend.domain.Todo;
import com.backend.dto.PageRequestDTO;
import com.backend.dto.PageResponseDTO;
import com.backend.dto.TodoDTO;
import jakarta.transaction.Transactional;

// 서비스: 사용자의 요청에 따라 데이터를 처리해 주는 객체를 말한다.
// 예: 조회, 등록

// 데이터 베이스를 묶어서 1개로 처리 하는 작업
@Transactional
public interface TodoService {

    TodoDTO get(Long tno);

    Long register(TodoDTO dto);

    void modify(TodoDTO dto);

    void remove(Long tno);

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    // 인터페이스에서도 default를 이용해서 메소드를 선언할수 있도록 Java 8 부터 바뀌었다.
    default TodoDTO entityToDTO(Todo todo) {
        // TodoDTO를 만들어 내는 메소드

        TodoDTO todoDTO =
                TodoDTO.builder()
                        .tno(todo.getTno())
                        .title(todo.getTitle())
                        .content(todo.getContent())
                        .complete(todo.isComplete())
                        .dueDate(todo.getDueDate())
                        .build();

        return todoDTO;
    }

    default Todo dtoToEntity(TodoDTO todoDTO) {
        Todo todo = Todo.builder()
                .tno(todoDTO.getTno())
                .title(todoDTO.getTitle())
                .content(todoDTO.getContent())
                .complete(todoDTO.isComplete())
                .dueDate(todoDTO.getDueDate())
                .build();

        return todo;
    }


}
