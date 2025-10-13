package com.cet.mapper.sys;


import com.cet.entity.sys.UserAvatarConditionEntity;
import com.cet.entity.sys.UserAvatarEntity;

import java.util.List;

/**
 * 用户头像 mapper
 * 
 * @author cet 该项目是知识星球：java突击队 的内部项目
 * @date 2025-10-13 14:39:38
 */
public interface UserAvatarMapper {
	/**
     * 查询用户头像信息
     * 
     * @param id 用户头像ID
     * @return 用户头像信息
     */
	UserAvatarEntity findById(Long id);
	
	/**
     * 根据条件查询用户头像列表
     *
     * @param userAvatarConditionEntity 用户头像信息
     * @return 用户头像集合
     */
	List<UserAvatarEntity> searchByCondition(UserAvatarConditionEntity userAvatarConditionEntity);

	/**
	 * 根据条件查询用户头像数量
	 *
	 * @param userAvatarConditionEntity 用户头像信息
	 * @return 用户头像集合
	 */
	int searchCount(UserAvatarConditionEntity userAvatarConditionEntity);
	
	/**
     * 添加用户头像
     * 
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	int insert(UserAvatarEntity userAvatarEntity);
	
	/**
     * 修改用户头像
     * 
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	int update(UserAvatarEntity userAvatarEntity);
	
	/**
     * 删除用户头像
     * 
     * @param id 用户头像ID
     * @return 结果
     */
	int deleteById(Long id);
	
}