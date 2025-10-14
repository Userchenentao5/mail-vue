package com.cet.entity.sys;

import lombok.Data;
import com.cet.entity.RequestPageEntity;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 菜单查询条件实体
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuConditionEntity extends RequestPageEntity {
	

	/**
	 *  ID
     */
	private Long id;

	/**
	 *  菜单名称
     */
	private String name;

	/**
	 *  上级菜单ID
     */
	private Long pid;

	/**
	 *  排序
     */
	private Integer sort;

	/**
	 *  图标
     */
	private String icon;

	/**
	 *  路由
     */
	private String path;

	/**
	 *  是否隐藏
     */
	private Integer hidden;

	/**
	 *  是否外链 1：是 0：否
     */
	private Integer isLink;

	/**
	 *  类型 1：目录 2：菜单 3：按钮
     */
	private Integer type;

	/**
	 *  功能权限
     */
	private String permission;

	/**
	 *  url地址
     */
	private String url;

	/**
	 *  创建人ID
     */
	private Long createUserId;

	/**
	 *  创建人名称
     */
	private String createUserName;

	/**
	 *  创建日期
     */
	private Date createTime;

	/**
	 *  修改人ID
     */
	private Long updateUserId;

	/**
	 *  修改人名称
     */
	private String updateUserName;

	/**
	 *  修改时间
     */
	private Date updateTime;

	/**
	 *  是否删除 1：已删除 0：未删除
     */
	private Integer isDel;
}
