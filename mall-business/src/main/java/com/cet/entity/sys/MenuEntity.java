package com.cet.entity.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.cet.entity.BaseEntity;

/**
 * 菜单实体 
 * 
 * @author cet
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuEntity extends BaseEntity {
	

	/**
	 * 菜单名称
	 */
	private String name;

	/**
	 * 上级菜单ID
	 */
	private Long pid;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 路由
	 */
	private String path;

	/**
	 * 是否隐藏
	 */
	private Integer hidden;

	/**
	 * 是否外链 1：是 0：否
	 */
	private Integer isLink;

	/**
	 * 类型 1：目录 2：菜单 3：按钮
	 */
	private Integer type;

	/**
	 * 功能权限
	 */
	private String permission;

	/**
	 * url地址
	 */
	private String url;
}
