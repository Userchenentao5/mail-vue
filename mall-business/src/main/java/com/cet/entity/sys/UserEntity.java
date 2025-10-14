package com.cet.entity.sys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.cet.entity.BaseEntity;
import java.util.Date;

/**
 * 用户实体 
 * 
 * @author cet
 * @date 2025-10-13 14:39:38
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity extends BaseEntity {
	

	/**
	 * 头像
	 */
	private Long avatarId;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 部门ID
	 */
	private Long deptId;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * 岗位ID
	 */
	private Long jobId;

	/**
	 * 最后修改密码的时间
	 */
	private Date lastChangePasswordTime;

	/**
	 * 别名
	 */
	private String nickName;

	/**
	 * 性别 1：男 2：女
	 */
	private Integer sex;

	/**
	 * 有效状态 1:有效 0:无效
	 */
	private Integer validStatus;
}
