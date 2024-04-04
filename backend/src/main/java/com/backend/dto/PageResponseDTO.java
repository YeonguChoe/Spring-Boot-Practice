package com.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * 페이지네이션을 처리해 주는 클래스 입니다.
 *
 * @param <E>
 */

@Data
public class PageResponseDTO<E> {

    private List<E> dtoList;
    private List<Integer> pageNumList;
    private PageRequestDTO pageRequestDTO;

    private boolean prev;
    private boolean next;

    private int totalCount;
    private int prevPage;
    private int nextPage;
    private int totalPage;
    private int current;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(List<E> dtoList, PageRequestDTO pageRequestDTO, long totalCount) {
        this.dtoList = dtoList;
        this.pageRequestDTO = pageRequestDTO;
        this.totalCount = (int) totalCount;

        // 페지네이션에서 끝 페이지 계산
        int end = (int) (Math.ceil(pageRequestDTO.getPage() / 10.0)) * 10;

        // 시작 페이지 계산
        int start = end - 9;

        // 가장 마지막 페이지
        int last = (int) (Math.ceil((totalCount / pageRequestDTO.getSize())));

        end = end > last ? last : end;

        // 이전 페이지가 화면에 표시 되어야 하는가
        this.prev = start > 1;
        // 다음 페이지가 화면에 표시 되어야 하는가
        this.next = totalCount > end * pageRequestDTO.getSize();

        // 페지네이션 번호 만들기
        this.pageNumList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
        if (prev) {
            this.prevPage = start - 1;
        }

        if (next) {
            this.nextPage = end + 1;
        }

        this.totalPage = this.pageNumList.size();
        this.current = pageRequestDTO.getPage();
    }
}
