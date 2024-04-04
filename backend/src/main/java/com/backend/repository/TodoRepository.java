package com.backend.repository;

import com.backend.domain.Todo;
import com.backend.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository는 특정 Entity에 대한 CRUD를 실행 할 수 있게 해준다
// 괄호 안에는 Entity의 자료형과 primary key의 자료형이 들어간다.
// extends에는 Todo 리포지토리가 사용할 기능들을 추가해 준다.
public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {
}
