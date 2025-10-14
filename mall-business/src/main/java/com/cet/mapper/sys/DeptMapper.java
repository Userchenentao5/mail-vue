package com.cet.mapper.sys;


import com.cet.entity.sys.DeptConditionEntity;
import com.cet.entity.sys.DeptEntity;

import java.util.List;

/**
 * 部门 mapper
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
public interface DeptMapper {
	/**
     * 查询部门信息
     * 
     * @param id 部门ID
     * @return 部门信息
     */
	DeptEntity findById(Long id);
	
	/**
     * 根据条件查询部门列表
     *
     * @param deptConditionEntity 部门信息
     * @return 部门集合
     */
	List<DeptEntity> searchByCondition(DeptConditionEntity deptConditionEntity);

	/**
	 * 根据条件查询部门数量
	 *
	 * @param deptConditionEntity 部门信息
	 * @return 部门集合
	 */
	int searchCount(DeptConditionEntity deptConditionEntity);
	
	/**
     * 添加部门
     * 
     * @param deptEntity 部门信息
     * @return 结果
     */
	int insert(DeptEntity deptEntity);
	
	/**
     * 修改部门
     * 
     * @param deptEntity 部门信息
     * @return 结果
     */
	int update(DeptEntity deptEntity);
	
	/**
     * 删除部门
     * 
     * @param id 部门ID
     * @return 结果
     */
	int deleteById(Long id);
	
}