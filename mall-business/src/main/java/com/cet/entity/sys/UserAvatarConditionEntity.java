package com.cet.entity.sys;

import lombok.Data;
import com.cet.entity.RequestPageEntity;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户头像查询条件实体
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAvatarConditionEntity extends RequestPageEntity {
	

	/**
	 *  
     */
	private Long id;

	/**
	 *  文件名
     */
	private String fileName;

	/**
	 *  路径
     */
	private String path;

	/**
	 *  大小
     */
	private String fileSize;

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
