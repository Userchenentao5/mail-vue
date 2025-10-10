package com.cet.mapper.user;

import com.cet.entity.user.UserConditionEntity;
import com.cet.entity.user.UserEntity;

import java.util.List;

/**
 * @author 30952
 */
public interface UserMapper {

    /**
     * 根据id查询用户信息
     * @param id 用户Id
     * @return 用户信息
     */
    UserEntity findById(Long id);

    /**
     * 根据条件查询用户列表
     * @param userConditionEntity 条件
     * @return 用户列表
     */
    List<UserEntity> searchByCondition(UserConditionEntity userConditionEntity);

    /**
     * 根据条件查询用户数量
     * @param userConditionEntity 条件
     * @return 用户数量
     */
    int searchCount(UserConditionEntity userConditionEntity);
}
