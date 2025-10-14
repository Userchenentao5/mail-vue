package com.cet.controller;

import com.cet.entity.sys.DeptConditionEntity;
import com.cet.entity.sys.DeptEntity;
import com.cet.service.sys.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cet.entity.ResponsePageEntity;

import javax.validation.constraints.NotNull;

/**
 * 部门 接口层
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@RestController
@RequestMapping("/v1/dept")
public class DeptController {
	
	@Autowired
	private DeptService deptService;

	/**
	 * 通过id查询部门信息
	 *
	 * @param id 系统ID
	 * @return 部门信息
	 */
	@GetMapping("/findById")
	public DeptEntity findById(Long id) {
		return deptService.findById(id);
	}

	/**
    * 根据条件查询部门列表
    *
    * @param deptConditionEntity 条件
    * @return 部门列表
    */
	@PostMapping("/searchByPage")
	public ResponsePageEntity<DeptEntity> searchByPage(@RequestBody DeptConditionEntity deptConditionEntity) {
		return deptService.searchByPage(deptConditionEntity);
	}


	/**
     * 添加部门
     *
     * @param deptEntity 部门实体
     * @return 影响行数
     */
	@PostMapping("/insert")
	public int insert(@RequestBody DeptEntity deptEntity) {
		return deptService.insert(deptEntity);
	}

	/**
     * 修改部门
     *
     * @param deptEntity 部门实体
     * @return 影响行数
     */
	@PostMapping("/update")
	public int update(@RequestBody DeptEntity deptEntity) {
		return deptService.update(deptEntity);
	}

	/**
     * 删除部门
     *
     * @param id 部门ID
     * @return 影响行数
     */
	@PostMapping("/deleteById")
	public int deleteById(@RequestBody @NotNull Long id) {
		return deptService.deleteById(id);
	}
}
