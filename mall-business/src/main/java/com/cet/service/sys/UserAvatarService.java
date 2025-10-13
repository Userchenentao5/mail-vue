package com.cet.service.sys;

import java.util.List;

import com.cet.entity.sys.UserAvatarConditionEntity;
import com.cet.entity.sys.UserAvatarEntity;
import com.cet.mapper.sys.UserAvatarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cet.entity.ResponsePageEntity;

import javax.annotation.Resource;

/**
 * 用户头像 服务层
 * 
 * @author cet 该项目是知识星球：java突击队 的内部项目
 * @date 2025-10-13 14:39:38
 */
@Service
public class UserAvatarService {

	@Resource
	private UserAvatarMapper userAvatarMapper;

	/**
     * 查询用户头像信息
     * 
     * @param id 用户头像ID
     * @return 用户头像信息
     */
	public UserAvatarEntity findById(Long id) {
	    return userAvatarMapper.findById(id);
	}
	
	/**
     * 根据条件分页查询用户头像列表
     * 
     * @param userAvatarConditionEntity 用户头像信息
     * @return 用户头像集合
     */
	public ResponsePageEntity<UserAvatarEntity> searchByPage(UserAvatarConditionEntity userAvatarConditionEntity) {
		int count = userAvatarMapper.searchCount(userAvatarConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(userAvatarConditionEntity);
		}
		List<UserAvatarEntity> dataList = userAvatarMapper.searchByCondition(userAvatarConditionEntity);
		return ResponsePageEntity.build(userAvatarConditionEntity, count, dataList);
	}
	
    /**
     * 新增用户头像
     * 
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	public int insert(UserAvatarEntity userAvatarEntity) {
	    return userAvatarMapper.insert(userAvatarEntity);
	}
	
	/**
     * 修改用户头像
     * 
     * @param userAvatarEntity 用户头像信息
     * @return 结果
     */
	public int update(UserAvatarEntity userAvatarEntity) {
	    return userAvatarMapper.update(userAvatarEntity);
	}

	/**
     * 删除用户头像对象
     * 
     * @param id 系统ID
     * @return 结果
     */
	public int deleteById(Long id) {
		return userAvatarMapper.deleteById(id);
	}
	
}
