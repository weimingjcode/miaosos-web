package com.miaosos.entity;

import lombok.Data;

/**
 * @Auther zln
 * @Date 2018-09-07
 * @Description :
 */
@Data
public class SysPermission {

       private int  permission_id;
       private String  permission_name;
       private String  permission_url;
       private String  permission_description;
       private int  permission_pid;
       private String  url_icon;
       private int  permission_order;
       private String  permission_tag_id;
}
