package com.cet.entity.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.cet.entity.BaseEntity;

/**
 * 岗位实体 
 * 
 * @author cet
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobEntity extends BaseEntity {
	

	/**
	 * 岗位名称
	 */
	private String name;

	/**
	 * 岗位排序
	 */
	private Integer sort;

	/**
	 * 部门ID
	 */
	private Long deptId;

	/**
	 * 有效状态 1:有效 0:无效
	 */
	private Integer validStatus;
}
