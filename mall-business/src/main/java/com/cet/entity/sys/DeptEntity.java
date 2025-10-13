package com.cet.entity.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.cet.entity.BaseEntity;

/**
 * 部门实体 该项目是知识星球：java突击队 的内部项目
 * 
 * @author cet
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptEntity extends BaseEntity {
	

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 上级部门ID
	 */
	private Long pid;

	/**
	 * 有效状态 1:有效 0:无效
	 */
	private Integer validStatus;
}
