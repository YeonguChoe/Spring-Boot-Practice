package com.backend.repository.search;

import com.backend.domain.Todo;
import com.backend.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {

    Page<Todo> search1(PageRequestDTO pageRequestDTO);
}
