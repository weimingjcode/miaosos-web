package com.miaosos.entity;

/**
 * @Auther zln
 * @Date 2018-09-07
 * @Description :
 */
public class SysPermission {

       private int  permission_id;
       private String  permission_name;
       private String  permission_url;
       private String  permission_description;
       private int  permission_pid;
       private String  url_icon;
       private int  permission_order;
       private String  permission_tag_id;

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public String getPermission_url() {
        return permission_url;
    }

    public void setPermission_url(String permission_url) {
        this.permission_url = permission_url;
    }

    public String getPermission_description() {
        return permission_description;
    }

    public void setPermission_description(String permission_description) {
        this.permission_description = permission_description;
    }

    public int getPermission_pid() {
        return permission_pid;
    }

    public void setPermission_pid(int permission_pid) {
        this.permission_pid = permission_pid;
    }

    public String getUrl_icon() {
        return url_icon;
    }

    public void setUrl_icon(String url_icon) {
        this.url_icon = url_icon;
    }

    public int getPermission_order() {
        return permission_order;
    }

    public void setPermission_order(int permission_order) {
        this.permission_order = permission_order;
    }

    public String getPermission_tag_id() {
        return permission_tag_id;
    }

    public void setPermission_tag_id(String permission_tag_id) {
        this.permission_tag_id = permission_tag_id;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "permission_id=" + permission_id +
                ", permission_name='" + permission_name + '\'' +
                ", permission_url='" + permission_url + '\'' +
                ", permission_description='" + permission_description + '\'' +
                ", permission_pid=" + permission_pid +
                ", url_icon='" + url_icon + '\'' +
                ", permission_order=" + permission_order +
                ", permission_tag_id='" + permission_tag_id + '\'' +
                '}';
    }
}
