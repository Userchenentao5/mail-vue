package com.cet.controller;

import com.cet.entity.sys.JobConditionEntity;
import com.cet.entity.sys.JobEntity;
import com.cet.service.sys.JobService;
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
 * 岗位 接口层
 * 
 * @author cet 该项目是知识星球：java突击队 的内部项目
 * @date 2025-10-13 14:39:38
 */
@RestController
@RequestMapping("/v1/job")
public class JobController {
	
	@Resource
	private JobService jobService;

	/**
	 * 通过id查询岗位信息
	 *
	 * @param id 系统ID
	 * @return 岗位信息
	 */
	@GetMapping("/findById")
	public JobEntity findById(Long id) {
		return jobService.findById(id);
	}

	/**
    * 根据条件查询岗位列表
    *
    * @param jobConditionEntity 条件
    * @return 岗位列表
    */
	@PostMapping("/searchByPage")
	public ResponsePageEntity<JobEntity> searchByPage(@RequestBody JobConditionEntity jobConditionEntity) {
		return jobService.searchByPage(jobConditionEntity);
	}


	/**
     * 添加岗位
     *
     * @param jobEntity 岗位实体
     * @return 影响行数
     */
	@PostMapping("/insert")
	public int insert(@RequestBody JobEntity jobEntity) {
		return jobService.insert(jobEntity);
	}

	/**
     * 修改岗位
     *
     * @param jobEntity 岗位实体
     * @return 影响行数
     */
	@PostMapping("/update")
	public int update(@RequestBody JobEntity jobEntity) {
		return jobService.update(jobEntity);
	}

	/**
     * 删除岗位
     *
     * @param id 岗位ID
     * @return 影响行数
     */
	@PostMapping("/deleteById")
	public int deleteById(@RequestBody @NotNull Long id) {
		return jobService.deleteById(id);
	}
}
