package com.cet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 分页响应实体
 */

@AllArgsConstructor
@Data
public class ResponsePageEntity <T> implements Serializable {

    private static final Integer ZERO = 0;

    private Integer pageNo;

    private Integer pageSize;

    private Integer totalPage;

    private Integer totalCount;

    private List<T> data;

    public static <T> ResponsePageEntity<T> buildEmpty(RequestPageEntity requestPageEntity) {
        return build(requestPageEntity, 0, new ArrayList<>(0));
    }

    public static <T> ResponsePageEntity<T> build(RequestPageEntity requestPageEntity, Integer totalCount, List<T> data) {
        Integer totalPage = getTotalPage(requestPageEntity.getPageSize(), totalCount);
        return new ResponsePageEntity<>(requestPageEntity.getPageNo(), requestPageEntity.getPageSize(), totalPage, totalCount, data);
    }

    private static Integer getTotalPage(Integer pageSize, Integer totalCount) {
        if(Objects.isNull(pageSize) || Objects.isNull(totalCount)) {
            return ZERO;
        }

        if(pageSize <= 0 || totalCount <= 0) {
            return ZERO;
        }

        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

}
