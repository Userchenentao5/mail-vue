package com.cet.controller;

import com.cet.entity.sys.UserAvatarConditionEntity;
import com.cet.entity.sys.UserAvatarEntity;
import com.cet.service.sys.UserAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cet.entity.ResponsePageEntity;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 用户头像 接口层
 * 
 * @author cet 该项目是知识星球：java突击队 的内部项目
 * @date 2025-10-13 14:39:38
 */
@RestController
@RequestMapping("/v1/userAvatar")
public class UserAvatarController {
	
	@Resource
	private UserAvatarService userAvatarService;

	/**
	 * 通过id查询用户头像信息
	 *
	 * @param id 系统ID
	 * @return 用户头像信息
	 */
	@GetMapping("/findById")
	public UserAvatarEntity findById(Long id) {
		return userAvatarService.findById(id);
	}

	/**
    * 根据条件查询用户头像列表
    *
    * @param userAvatarConditionEntity 条件
    * @return 用户头像列表
    */
	@PostMapping("/searchByPage")
	public ResponsePageEntity<UserAvatarEntity> searchByPage(@RequestBody UserAvatarConditionEntity userAvatarConditionEntity) {
		return userAvatarService.searchByPage(userAvatarConditionEntity);
	}


	/**
     * 添加用户头像
     *
     * @param userAvatarEntity 用户头像实体
     * @return 影响行数
     */
	@PostMapping("/insert")
	public int insert(@RequestBody UserAvatarEntity userAvatarEntity) {
		return userAvatarService.insert(userAvatarEntity);
	}

	/**
     * 修改用户头像
     *
     * @param userAvatarEntity 用户头像实体
     * @return 影响行数
     */
	@PostMapping("/update")
	public int update(@RequestBody UserAvatarEntity userAvatarEntity) {
		return userAvatarService.update(userAvatarEntity);
	}

	/**
     * 删除用户头像
     *
     * @param id 用户头像ID
     * @return 影响行数
     */
	@PostMapping("/deleteById")
	public int deleteById(@RequestBody @NotNull Long id) {
		return userAvatarService.deleteById(id);
	}
}
