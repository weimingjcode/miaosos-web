package com.miaosos.service.security;

import com.miaosos.dao.security.SecurityDao;
import com.miaosos.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther zln
 * @Date 2018-08-08
 * @Description :
 */

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    SecurityDao securityDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = securityDao.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        if(user.getRole() != null){
            authorities.add(new SimpleGrantedAuthority(user.getRole().getRole_name()));
            System.out.println("loadUserByUsername: " + user);
        }
        /*user.setAuthorities(authorities); //用于登录时 @AuthenticationPrincipal 标签取值*/
        return user;
       /* SysUser user = securityDao.findByUserName(username);
        if (user != null) {
            List<Map<String,String>> permissions = securityDao.findByAdminUserId(user.getUser_id());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            for (Map<String, String> permission : permissions) {
                if (permission != null && permission.get("permission_name")!=null) {
                    GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.get("permission_name"),permission.get("permission_method"));
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }

            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }*/
    }
}
