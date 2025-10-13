package com.cet.mapper.user;

import com.cet.entity.user.UserConditionEntity;
import com.cet.entity.user.UserEntity;
import org.apache.ibatis.annotations.Param;

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
    UserEntity findById(@Param("id") Long id);

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

    /**
     * 添加用户
     * @param userEntity 用户实体
     * @return 影响行数
     */
    int insert(UserEntity userEntity);

    /**
     * 修改用户
     * @param userEntity 用户实体
     * @return 影响行数
     */
    int update(UserEntity userEntity);

    /**
     * 删除用户
     * @param id 用户ID
     * @return 影响行数
     */
    int deleteById(@Param("id") Long id);
}
