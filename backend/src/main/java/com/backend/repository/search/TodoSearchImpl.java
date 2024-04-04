package com.backend.repository.search;

import com.backend.domain.QTodo;
import com.backend.domain.Todo;
import com.backend.dto.PageRequestDTO;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

@Log4j2
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1(PageRequestDTO pageRequestDTO) {

        log.info("search1이 실행됩니다....");

        QTodo todo = QTodo.todo;

        // JPQL에 from문 추가하기
        JPQLQuery<Todo> query = from(todo);

        // JPQL에 where문 추가하기
        query.where(todo.title.contains("t"));

        // Pagination를 만들기
        Pageable pageable = PageRequest.of(pageRequestDTO.getSize() - 1,
                pageRequestDTO.getSize(),
                Sort.by("tno").descending());
        this.getQuerydsl().applyPagination(pageable, query);

        // JPQL 쿼리 실행하여 목록 데이터를 가져온다.
        List<Todo> list = query.fetch();
        long total = query.fetchCount();

        return new PageImpl<>(list, pageable, total);
    }
}
