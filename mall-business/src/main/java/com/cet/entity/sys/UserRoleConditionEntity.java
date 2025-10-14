package com.cet.entity.sys;

import lombok.Data;
import com.cet.entity.RequestPageEntity;
import lombok.EqualsAndHashCode;

/**
 * 用户角色关联查询条件实体
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRoleConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	private Long id;

	/**
	 *  用户ID
     */
	private Long userId;

	/**
	 *  角色ID
     */
	private Long roleId;
}
