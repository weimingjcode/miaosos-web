package com.miaosos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Auther zln
 * @Date 2018-08-08
 * @Description :
 */
public class SysUser implements UserDetails {

    private Integer user_id;
    private String username;
    @JsonIgnore
    private String password;
    private String rawPassword;
    private String number;
    private Integer onlinestatus;
    private String phone_type;
    private String phone_pass;

    private SysRole role;
    private List<SysPermission> pPermission;
    private List<SysPermission> cPermission;
    private List<? extends GrantedAuthority> authorities;


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public List<SysPermission> getpPermission() {
        return pPermission;
    }

    public void setpPermission(List<SysPermission> pPermission) {
        this.pPermission = pPermission;
    }

    public List<SysPermission> getcPermission() {
        return cPermission;
    }

    public void setcPermission(List<SysPermission> cPermission) {
        this.cPermission = cPermission;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getOnlinestatus() {
        return onlinestatus;
    }

    public void setOnlinestatus(Integer onlinestatus) {
        this.onlinestatus = onlinestatus;
    }

    public String getPhone_type() {
        return phone_type;
    }

    public void setPhone_type(String phone_type) {
        this.phone_type = phone_type;
    }

    public String getPhone_pass() {
        return phone_pass;
    }

    public void setPhone_pass(String phone_pass) {
        this.phone_pass = phone_pass;
    }

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

    @Override
    public String toString() {
        return "SysUser{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rawPassword='" + rawPassword + '\'' +
                ", number='" + number + '\'' +
                ", onlinestatus=" + onlinestatus +
                ", phone_type='" + phone_type + '\'' +
                ", phone_pass='" + phone_pass + '\'' +
                ", roles=" + role +
                ", pPermission=" + pPermission +
                ", cPermission=" + cPermission +
                ", authorities=" + authorities +
                '}';
    }
}
