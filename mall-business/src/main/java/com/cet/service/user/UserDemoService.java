package com.cet.service.user;

import com.cet.entity.ResponsePageEntity;
import com.cet.entity.user.UserConditionEntity;
import com.cet.entity.user.UserDemoEntity;
import com.cet.mapper.user.UserDemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserDemoService {

    @Resource
    private UserDemoMapper userDemoMapper;

    /**
     * 根据id查询用户信息
     * @param id 用户Id
     * @return 用户信息
     */
    public UserDemoEntity findById(Long id) {
        return userDemoMapper.findById(id);
    }

    /**
     * 根据条件查询用户列表
     * @param userConditionEntity 条件
     * @return 用户列表
     */
    public ResponsePageEntity<UserDemoEntity> searchByPage(UserConditionEntity userConditionEntity) {
        int count = userDemoMapper.searchCount(userConditionEntity);
        if (count == 0) {
            return ResponsePageEntity.buildEmpty(userConditionEntity);
        }
        List<UserDemoEntity> userEntities = userDemoMapper.searchByCondition(userConditionEntity);
        return ResponsePageEntity.build(userConditionEntity, count, userEntities);
    }

    /**
     * 添加用户
     * @param userDemoEntity 用户实体
     * @return 影响行数
     */
    public int insert(UserDemoEntity userDemoEntity) {
        return userDemoMapper.insert(userDemoEntity);
    }

    /**
     * 修改用户
     * @param userDemoEntity 用户实体
     * @return 影响行数
     */
    public int update(UserDemoEntity userDemoEntity) {
        return userDemoMapper.update(userDemoEntity);
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return 影响行数
     */
    public int delete(Long id) {
        return userDemoMapper.deleteById(id);
    }
}
