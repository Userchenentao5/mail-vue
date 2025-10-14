package com.cet.controller;

import com.cet.entity.sys.MenuConditionEntity;
import com.cet.entity.sys.MenuEntity;
import com.cet.service.sys.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cet.entity.ResponsePageEntity;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 菜单 接口层
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@RestController
@RequestMapping("/v1/menu")
public class MenuController {
	
	@Resource
	private MenuService menuService;

	/**
	 * 通过id查询菜单信息
	 *
	 * @param id 系统ID
	 * @return 菜单信息
	 */
	@GetMapping("/findById")
	public MenuEntity findById(Long id) {
		return menuService.findById(id);
	}

	/**
    * 根据条件查询菜单列表
    *
    * @param menuConditionEntity 条件
    * @return 菜单列表
    */
	@PostMapping("/searchByPage")
	public ResponsePageEntity<MenuEntity> searchByPage(@RequestBody MenuConditionEntity menuConditionEntity) {
		return menuService.searchByPage(menuConditionEntity);
	}


	/**
     * 添加菜单
     *
     * @param menuEntity 菜单实体
     * @return 影响行数
     */
	@PostMapping("/insert")
	public int insert(@RequestBody MenuEntity menuEntity) {
		return menuService.insert(menuEntity);
	}

	/**
     * 修改菜单
     *
     * @param menuEntity 菜单实体
     * @return 影响行数
     */
	@PostMapping("/update")
	public int update(@RequestBody MenuEntity menuEntity) {
		return menuService.update(menuEntity);
	}

	/**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return 影响行数
     */
	@PostMapping("/deleteById")
	public int deleteById(@RequestBody @NotNull Long id) {
		return menuService.deleteById(id);
	}
}
