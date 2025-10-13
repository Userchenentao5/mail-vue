package com.cet.service.sys;

import java.util.List;

import com.cet.entity.sys.DeptConditionEntity;
import com.cet.entity.sys.DeptEntity;
import com.cet.mapper.sys.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cet.entity.ResponsePageEntity;

import javax.annotation.Resource;

/**
 * 部门 服务层
 * 
 * @author cet 该项目是知识星球：java突击队 的内部项目
 * @date 2025-10-13 14:39:38
 */
@Service
public class DeptService {

	@Resource
	private DeptMapper deptMapper;

	/**
     * 查询部门信息
     * 
     * @param id 部门ID
     * @return 部门信息
     */
	public DeptEntity findById(Long id) {
	    return deptMapper.findById(id);
	}
	
	/**
     * 根据条件分页查询部门列表
     * 
     * @param deptConditionEntity 部门信息
     * @return 部门集合
     */
	public ResponsePageEntity<DeptEntity> searchByPage(DeptConditionEntity deptConditionEntity) {
		int count = deptMapper.searchCount(deptConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(deptConditionEntity);
		}
		List<DeptEntity> dataList = deptMapper.searchByCondition(deptConditionEntity);
		return ResponsePageEntity.build(deptConditionEntity, count, dataList);
	}
	
    /**
     * 新增部门
     * 
     * @param deptEntity 部门信息
     * @return 结果
     */
	public int insert(DeptEntity deptEntity) {
	    return deptMapper.insert(deptEntity);
	}
	
	/**
     * 修改部门
     * 
     * @param deptEntity 部门信息
     * @return 结果
     */
	public int update(DeptEntity deptEntity) {
	    return deptMapper.update(deptEntity);
	}

	/**
     * 删除部门对象
     * 
     * @param id 系统ID
     * @return 结果
     */
	public int deleteById(Long id) {
		return deptMapper.deleteById(id);
	}
	
}
