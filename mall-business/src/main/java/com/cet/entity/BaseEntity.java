package com.cet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 30952
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseEntity implements Serializable {

    private Long id;

    private Long createUserId;

    private String createUserName;

    private LocalDateTime createTime;

    private Long updateUserId;

    private String updateUserName;

    private LocalDateTime updateTime;

    private Integer isDel;

}
