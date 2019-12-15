package com.zhkchi.config.service;

import com.zhkchi.domain.RbPermission;
import com.zhkchi.domain.RbUser;
import com.zhkchi.service.RbPermissionService;
import com.zhkchi.service.RbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * @author wedbet
 * @date 2019/12/15
 */
public class RbbUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    RbUserService rbUserService;
    @Autowired
    RbPermissionService rbPermissionService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        RbUser rbUser = rbUserService.getRbUserByUserName(s);
        List<GrantedAuthority> grantedAuthorityList = Arrays.asList();
        User user = null;
        //该用户不存在
        if (rbUser == null){
            user = new User(null,null,null);
            return user;
        }
        List<RbPermission> rbPermissionList = rbPermissionService.getPermissionsByUserId(rbUser.getId());
        //用户授权
        rbPermissionList.forEach(rbPermission -> {
            if (rbPermission != null && rbPermission.getEnname() != null){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rbPermission.getEnname());
                grantedAuthorityList.add(grantedAuthority);
            }
        });
        user = new User(rbUser.getUsername(),rbUser.getPassword(),grantedAuthorityList);
        return user;
    }
}
