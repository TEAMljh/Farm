package com.ljh.farm.util;

import lombok.Data;

/**
 * @Description
 * @Author ljh
 * @Date 2020/2/27 17:56
 */
@Data
public class QuerySort {

    private String sort;
    //desc（降序）、asc（升序）、null（空对象，默认排序）
    private String order;
    private boolean mapCamelCaseToUnderscore = true;

    public String getSort() {
        if (mapCamelCaseToUnderscore) {
            return UnderscoreCamelCaseUtils.underscoreName(sort);
        }
        return sort;
    }
}
