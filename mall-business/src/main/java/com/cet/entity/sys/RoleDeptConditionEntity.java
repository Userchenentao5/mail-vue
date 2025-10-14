package com.cet.entity.sys;

import lombok.Data;
import com.cet.entity.RequestPageEntity;
import lombok.EqualsAndHashCode;

/**
 * 角色部门关联查询条件实体
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDeptConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	private Long id;

	/**
	 *  
     */
	private Long roleId;

	/**
	 *  
     */
	private Long deptId;
}
