package com.cet.service.sys;

import java.util.List;

import com.cet.entity.sys.RoleConditionEntity;
import com.cet.entity.sys.RoleEntity;
import com.cet.mapper.sys.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cet.entity.ResponsePageEntity;

import javax.annotation.Resource;

/**
 * 角色 服务层
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@Service
public class RoleService {

	@Resource
	private RoleMapper roleMapper;

	/**
     * 查询角色信息
     * 
     * @param id 角色ID
     * @return 角色信息
     */
	public RoleEntity findById(Long id) {
	    return roleMapper.findById(id);
	}
	
	/**
     * 根据条件分页查询角色列表
     * 
     * @param roleConditionEntity 角色信息
     * @return 角色集合
     */
	public ResponsePageEntity<RoleEntity> searchByPage(RoleConditionEntity roleConditionEntity) {
		int count = roleMapper.searchCount(roleConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(roleConditionEntity);
		}
		List<RoleEntity> dataList = roleMapper.searchByCondition(roleConditionEntity);
		return ResponsePageEntity.build(roleConditionEntity, count, dataList);
	}
	
    /**
     * 新增角色
     * 
     * @param roleEntity 角色信息
     * @return 结果
     */
	public int insert(RoleEntity roleEntity) {
	    return roleMapper.insert(roleEntity);
	}
	
	/**
     * 修改角色
     * 
     * @param roleEntity 角色信息
     * @return 结果
     */
	public int update(RoleEntity roleEntity) {
	    return roleMapper.update(roleEntity);
	}

	/**
     * 删除角色对象
     * 
     * @param id 系统ID
     * @return 结果
     */
	public int deleteById(Long id) {
		return roleMapper.deleteById(id);
	}
	
}
