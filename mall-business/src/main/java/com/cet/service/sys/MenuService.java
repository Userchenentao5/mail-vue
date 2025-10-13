package com.cet.service.sys;

import java.util.List;

import com.cet.entity.sys.MenuConditionEntity;
import com.cet.entity.sys.MenuEntity;
import com.cet.mapper.sys.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cet.entity.ResponsePageEntity;

import javax.annotation.Resource;

/**
 * 菜单 服务层
 * 
 * @author cet 该项目是知识星球：java突击队 的内部项目
 * @date 2025-10-13 14:39:38
 */
@Service
public class MenuService {

	@Resource
	private MenuMapper menuMapper;

	/**
     * 查询菜单信息
     * 
     * @param id 菜单ID
     * @return 菜单信息
     */
	public MenuEntity findById(Long id) {
	    return menuMapper.findById(id);
	}
	
	/**
     * 根据条件分页查询菜单列表
     * 
     * @param menuConditionEntity 菜单信息
     * @return 菜单集合
     */
	public ResponsePageEntity<MenuEntity> searchByPage(MenuConditionEntity menuConditionEntity) {
		int count = menuMapper.searchCount(menuConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(menuConditionEntity);
		}
		List<MenuEntity> dataList = menuMapper.searchByCondition(menuConditionEntity);
		return ResponsePageEntity.build(menuConditionEntity, count, dataList);
	}
	
    /**
     * 新增菜单
     * 
     * @param menuEntity 菜单信息
     * @return 结果
     */
	public int insert(MenuEntity menuEntity) {
	    return menuMapper.insert(menuEntity);
	}
	
	/**
     * 修改菜单
     * 
     * @param menuEntity 菜单信息
     * @return 结果
     */
	public int update(MenuEntity menuEntity) {
	    return menuMapper.update(menuEntity);
	}

	/**
     * 删除菜单对象
     * 
     * @param id 系统ID
     * @return 结果
     */
	public int deleteById(Long id) {
		return menuMapper.deleteById(id);
	}
	
}
