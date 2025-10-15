package com.cet.service.sys;

import java.util.Arrays;
import java.util.List;

import com.cet.auth.AuthUserEntity;
import com.cet.auth.JwtUserEntity;
import com.cet.auth.TokenEntity;
import com.cet.entity.sys.UserConditionEntity;
import com.cet.entity.sys.UserEntity;
import com.cet.helper.TokenHelper;
import com.cet.mapper.sys.UserMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cet.entity.ResponsePageEntity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户 服务层
 * 
 * @author cet 
 * @date 2025-10-13 14:39:38
 */
@Service
public class UserService {

	@Resource
	private UserMapper userMapper;

  @Resource
  private TokenHelper tokenHelper;

  @Resource
  private AuthenticationManagerBuilder authenticationManagerBuilder;

    /**
     * 用户登录
     * @param authUserEntity 用户录入信息
     */
    public TokenEntity login(AuthUserEntity authUserEntity) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(authUserEntity.getUsername(), authUserEntity.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 直接使用认证成功的用户名创建JwtUserEntity
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("User"));
        JwtUserEntity jwtUserEntity = new JwtUserEntity(
            1L, // 暂时固定ID
            authUserEntity.getUsername(),
            null, // 密码不需要在token中
            authorities,
            Arrays.asList("User")
        );

        String token = tokenHelper.generateToken(jwtUserEntity);
        return new TokenEntity(authUserEntity.getUsername(), token);
    }

    /**
     * 用户登出
     *
     * @param request 请求
     */
    public void logout(HttpServletRequest request) {
//        String token = TokenUtil.getTokenForAuthorization(request);
//        AssertUtil.hasLength(token, "请重新登录");
//        tokenHelper.delToken(token);
    }

	/**
     * 查询用户信息
     * 
     * @param id 用户ID
     * @return 用户信息
     */
	public UserEntity findById(Long id) {
	    return userMapper.findById(id);
	}
	
	/**
     * 根据条件分页查询用户列表
     * 
     * @param userConditionEntity 用户信息
     * @return 用户集合
     */
	public ResponsePageEntity<UserEntity> searchByPage(UserConditionEntity userConditionEntity) {
		int count = userMapper.searchCount(userConditionEntity);
		if (count == 0) {
			return ResponsePageEntity.buildEmpty(userConditionEntity);
		}
		List<UserEntity> dataList = userMapper.searchByCondition(userConditionEntity);
		return ResponsePageEntity.build(userConditionEntity, count, dataList);
	}
	
    /**
     * 新增用户
     * 
     * @param userEntity 用户信息
     * @return 结果
     */
	public int insert(UserEntity userEntity) {
	    return userMapper.insert(userEntity);
	}
	
	/**
     * 修改用户
     * 
     * @param userEntity 用户信息
     * @return 结果
     */
	public int update(UserEntity userEntity) {
	    return userMapper.update(userEntity);
	}

	/**
     * 删除用户对象
     * 
     * @param id 系统ID
     * @return 结果
     */
	public int deleteById(Long id) {
		return userMapper.deleteById(id);
	}
	
}
