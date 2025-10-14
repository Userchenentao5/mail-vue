package com.cet.entity.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.cet.entity.BaseEntity;

/**
 * 用户角色关联实体 
 * 
 * @author cet
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleEntity extends BaseEntity {
	

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 角色ID
	 */
	private Long roleId;
}
