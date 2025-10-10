package com.cet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author 30952
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RequestConditionEntity extends RequestPageEntity {


    /**
     * 创建日期范围
     */
    private List<String> betweenTime;

    /**
     * 创建开始时间
     */
    private String createBeginTime;

    /**
     * 创建结束时间
     */
    private String createEndTime;

    /**
     * 自定义excel表头列表
     */
    private List<String> customizeColumnNameList;

    /**
     * 查询条件
     */
    private String blurry;
}