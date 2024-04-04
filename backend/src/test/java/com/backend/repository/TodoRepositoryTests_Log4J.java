package com.backend.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.backend.domain.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


// Spring Boot 테스트에는 꼭 @SpringBootTest라고 작성해준다.
@SpringBootTest
// Log4j는 info를 출력할 수 있는 로깅 라이브러리다.
@Log4j2
public class TodoRepositoryTests_Log4J {

    /**
     * DI (종속성 주입)
     * Dependency(부품): 클래스의 member 변수의 구현 부분을 dependency라고 한다.
     * DI: member 변수의 Object를 다른 클래스에서 직접 생성하고 해당 Object를 멤버 변수에 할당 하는것을 말한다.
     * 예: Setter Injection
     * A a = new A();
     * B b = new B();
     * A.setB(b);
     */

    /**
     * 빈 (Bean): 스프링에 의해 생성된 객체로 자동으로 IoC 컨테이너에 등록된다.
     */

    // Autowired를 사용하려면 TodoRepository 인터페이스만 만들어 주면 된다.
    // Autowired: 자동으로 member 변수에 할당해준다.
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1() {
        Assertions.assertNotNull(todoRepository);
    }


    @Test
    public void testInsert() {


        for (int i = 1; i < 100; i++) {
            Todo todo = Todo.builder()
                    .tno((long) i)
                    .title("Title")
                    .content("Content...")
                    .dueDate(LocalDate.of(2024, 4, 28))
                    .build();

            // 데이터 베이스에 todo를 저장한다.
            Todo result = todoRepository.save(todo);
        }

        // 빌더를 이용해서 객체를 만들어 준다.

//        log.info(result);
    }

    @Test
    public void testRead() {
        Long tno = 1L;

        Optional<Todo> result = todoRepository.findById(tno);

        // 문제있으면 할당 하고 아니면 에러를 반환한다.
        Todo todo = result.orElseThrow();
        log.info(todo);
    }

    @Test
    public void testUpdate() {

        // id를 통해 가져온다
        Optional<Todo> result = todoRepository.findById(1L);

        Todo todo = result.orElseThrow();

        todo.setTitle("Updated Title");
        todo.setContent("새로운 내용");
        todo.setComplete(true);

        // 데이터베이스를 꼭 저장해 줘야 한다.
        todoRepository.save(todo);
    }

    @Test
    public void testPaging() {
        // 페이지 번호는 0부터 시작한다.
        Pageable pageable = PageRequest.of(0, 10, Sort.by("tno").descending());
        Page<Todo> result = todoRepository.findAll(pageable);

        log.info("pageable의 조건에 충족되는 element수: " + result.getTotalElements());
        log.info("모든 Page 출력: " + result.getContent());
    }


    //    SQL이 잘 입력 되는지 검사하기
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testQuery() {
        String sql = "select t.tno from Todo t";
        Query question = entityManager.createQuery(sql);
        List<Integer> result = question.getResultList();
        log.info("쿼리 결과: " + result);
    }

//    // Query DSL 테스트 하기
//    @Test
//    public void testSearch1() {
//        todoRepository.search1();
//    }

}
