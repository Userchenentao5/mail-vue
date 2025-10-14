package com.cet.controller;

import com.cet.entity.sys.RoleConditionEntity;
import com.cet.entity.sys.RoleEntity;
import com.cet.service.sys.RoleService;
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
 * 角色 接口层
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@RestController
@RequestMapping("/v1/role")
public class RoleController {
	
	@Resource
	private RoleService roleService;

	/**
	 * 通过id查询角色信息
	 *
	 * @param id 系统ID
	 * @return 角色信息
	 */
	@GetMapping("/findById")
	public RoleEntity findById(Long id) {
		return roleService.findById(id);
	}

	/**
    * 根据条件查询角色列表
    *
    * @param roleConditionEntity 条件
    * @return 角色列表
    */
	@PostMapping("/searchByPage")
	public ResponsePageEntity<RoleEntity> searchByPage(@RequestBody RoleConditionEntity roleConditionEntity) {
		return roleService.searchByPage(roleConditionEntity);
	}


	/**
     * 添加角色
     *
     * @param roleEntity 角色实体
     * @return 影响行数
     */
	@PostMapping("/insert")
	public int insert(@RequestBody RoleEntity roleEntity) {
		return roleService.insert(roleEntity);
	}

	/**
     * 修改角色
     *
     * @param roleEntity 角色实体
     * @return 影响行数
     */
	@PostMapping("/update")
	public int update(@RequestBody RoleEntity roleEntity) {
		return roleService.update(roleEntity);
	}

	/**
     * 删除角色
     *
     * @param id 角色ID
     * @return 影响行数
     */
	@PostMapping("/deleteById")
	public int deleteById(@RequestBody @NotNull Long id) {
		return roleService.deleteById(id);
	}
}
