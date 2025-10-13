package com.cet.service.sys;

import java.util.List;

import com.cet.entity.sys.RoleMenuConditionEntity;
import com.cet.entity.sys.RoleMenuEntity;
import com.cet.mapper.sys.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cet.entity.ResponsePageEntity;

import javax.annotation.Resource;

/**
 * 角色菜单关联 服务层
 * 
 * @author cet 该项目是知识星球：java突击队 的内部项目
 * @date 2025-10-13 14:39:38
 */
@Service
public class RoleMenuService {

	@Resource
	private RoleMenuMapper roleMenuMapper;

	/**
     * 查询角色菜单关联信息
     * 
     * @param id 角色菜单关联ID
     * @return 角色菜单关联信息
     */
	public RoleMenuEntity findById(Long id) {
	    return roleMenuMapper.findById(id);
	}
	
	/**
     * 根据条件分页查询角色菜单关联列表
     * 
     * @param roleMenuConditionEntity 角色菜单关联信息
     * @return 角色菜单关联集合
     */
	public ResponsePageEntity<RoleMenuEntity> searchByPage(RoleMenuConditionEntity roleMenuConditionEntity) {
		int count = roleMenuMapper.searchCount(roleMenuConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(roleMenuConditionEntity);
		}
		List<RoleMenuEntity> dataList = roleMenuMapper.searchByCondition(roleMenuConditionEntity);
		return ResponsePageEntity.build(roleMenuConditionEntity, count, dataList);
	}
	
    /**
     * 新增角色菜单关联
     * 
     * @param roleMenuEntity 角色菜单关联信息
     * @return 结果
     */
	public int insert(RoleMenuEntity roleMenuEntity) {
	    return roleMenuMapper.insert(roleMenuEntity);
	}
	
	/**
     * 修改角色菜单关联
     * 
     * @param roleMenuEntity 角色菜单关联信息
     * @return 结果
     */
	public int update(RoleMenuEntity roleMenuEntity) {
	    return roleMenuMapper.update(roleMenuEntity);
	}

	/**
     * 删除角色菜单关联对象
     * 
     * @param id 系统ID
     * @return 结果
     */
	public int deleteById(Long id) {
		return roleMenuMapper.deleteById(id);
	}
	
}
