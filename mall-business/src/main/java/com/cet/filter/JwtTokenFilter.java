package com.cet.filter;

import com.cet.helper.TokenHelper;
import com.cet.util.SpringBeanUtil;
import com.cet.util.TokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 30952
 */
public class JwtTokenFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String token = TokenUtil.getTokenForAuthorization(httpServletRequest);

        if (Objects.isNull(token)) {
            filterChain.doFilter(httpServletRequest, servletResponse);
            return;
        }

        TokenHelper tokenHelper = SpringBeanUtil.getBean(TokenHelper.class);

        String username = tokenHelper.getUsernameFromToken(token);
        if (StringUtils.hasText(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = tokenHelper.getUserDetailsFromUsername(username);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            // 已完成认证
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(httpServletRequest, servletResponse);
    }
}