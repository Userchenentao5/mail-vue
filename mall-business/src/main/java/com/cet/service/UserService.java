package com.cet.service;

import com.cet.entity.ResponsePageEntity;
import com.cet.entity.user.UserConditionEntity;
import com.cet.entity.user.UserEntity;
import com.cet.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据id查询用户信息
     * @param id 用户Id
     * @return 用户信息
     */
    public UserEntity findById(Long id) {
        return userMapper.findById(id);
    }

    /**
     * 根据条件查询用户列表
     * @param userConditionEntity 条件
     * @return 用户列表
     */
    public ResponsePageEntity<UserEntity> searchByPage(UserConditionEntity userConditionEntity) {
        int count = userMapper.searchCount(userConditionEntity);
        if (count == 0) {
            return ResponsePageEntity.buildEmpty(userConditionEntity);
        }
        List<UserEntity> userEntities = userMapper.searchByCondition(userConditionEntity);
        return ResponsePageEntity.build(userConditionEntity, count, userEntities);
    }

    /**
     * 添加用户
     * @param userEntity 用户实体
     * @return 影响行数
     */
    public int insert(UserEntity userEntity) {
        return userMapper.insert(userEntity);
    }

    /**
     * 修改用户
     * @param userEntity 用户实体
     * @return 影响行数
     */
    public int update(UserEntity userEntity) {
        return userMapper.update(userEntity);
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return 影响行数
     */
    public int delete(Long id) {
        return userMapper.deleteById(id);
    }
}
