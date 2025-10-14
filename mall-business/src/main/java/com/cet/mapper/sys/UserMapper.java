package com.cet.mapper.sys;


import com.cet.entity.sys.UserConditionEntity;
import com.cet.entity.sys.UserEntity;

import java.util.List;

/**
 * 用户 mapper
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
public interface UserMapper {
	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
	UserEntity findById(Long id);
	
	/**
     * 根据条件查询用户列表
     *
     * @param userConditionEntity 用户信息
     * @return 用户集合
     */
	List<UserEntity> searchByCondition(UserConditionEntity userConditionEntity);

	/**
	 * 根据条件查询用户数量
	 *
	 * @param userConditionEntity 用户信息
	 * @return 用户集合
	 */
	int searchCount(UserConditionEntity userConditionEntity);
	
	/**
     * 添加用户
     * 
     * @param userEntity 用户信息
     * @return 结果
     */
	int insert(UserEntity userEntity);
	
	/**
     * 修改用户
     * 
     * @param userEntity 用户信息
     * @return 结果
     */
	int update(UserEntity userEntity);
	
	/**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
	int deleteById(Long id);
	
}