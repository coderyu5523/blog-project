package org.example.blogproject._core.utils;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingUtil {

    private int pageNumber; // 1부터 시작
    private int pageSize; // 10
    private Sort sort; // name: ASC
    private boolean hasPrevious; // false
    private int nextPageNumber; // 다음 페이지 번호
    private int prevPageNumber; // 이전 페이지 번호
    private boolean isNextPageDisabled; // 마지막 페이지인지 여부
    private List<PageNumberDTO> pageNumbers = new ArrayList<>();

    public PagingUtil(Page<?> page, Pageable pageable) {
        this.pageNumber = pageable.getPageNumber(); // 이미 1을 더한 상태로 전달받음
        this.pageSize = pageable.getPageSize();
        this.sort = pageable.getSort();
        this.hasPrevious = page.hasPrevious();
        this.nextPageNumber = page.hasNext() ? this.pageNumber + 1 : this.pageNumber;
        this.prevPageNumber = this.pageNumber > 1 ? this.pageNumber - 1 : 1;
        this.isNextPageDisabled = !page.hasNext();

        int totalPages = page.getTotalPages();
        for (int i = 1; i <= totalPages; i++) {
            pageNumbers.add(new PageNumberDTO(i, i == this.pageNumber));
        }
    }

    @Data
    public static class PageNumberDTO {
        private int pageNumber;
        private boolean isActive;

        public PageNumberDTO(int pageNumber, boolean isActive) {
            this.pageNumber = pageNumber;
            this.isActive = isActive;
        }
    }
}
