package com.cet.entity.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.cet.entity.BaseEntity;

/**
 * 角色实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author cet
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleEntity extends BaseEntity {
	

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 数据权限
	 */
	private String dataScope;

	/**
	 * 角色级别
	 */
	private Integer level;

	/**
	 * 功能权限
	 */
	private String permission;
}
