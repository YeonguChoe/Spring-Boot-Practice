package com.backend.service;

import com.backend.dto.PageRequestDTO;
import com.backend.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

    @Autowired
    TodoService todoService;

    @Test
    public void testGet() {
        log.info(todoService.get(252L));
    }

    @Test
    public void testRegister() {
        TodoDTO todoDTO = TodoDTO.builder()
                .title("제목")
                .content("내용")
                .dueDate(LocalDate.of(2029, 1, 1))
                .build();
        log.info(todoService.register((todoDTO)));
    }

    @Test
    public void testGetList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        log.info(todoService.getList(pageRequestDTO));
    }

}
