package com.miaosos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Auther zln
 * @Date 2018-08-08
 * @Description :
 */
@Data
public class SysUser implements UserDetails {

    private Integer user_id;
    private String username;
    @JsonIgnore
    private String password;
    private String number;
    private Integer onlinestatus;
    private String phone_type;
    private String phone_pass;

    private SysRole role;
    private List<SysPermission> pPermission;
    private List<SysPermission> cPermission;

    private List<? extends GrantedAuthority> authorities;


    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
