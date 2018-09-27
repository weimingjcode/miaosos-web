package com.miaosos.entity;

import lombok.Data;

/**
 * @Auther zln
 * @Date 2018-09-25
 * @Description :
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String id_card;
    private String id_type;
    private String phone;
    private String address;
    private String create_time;
    private String emergency_contact;
    private String default_description;
    private Integer gender;
    private Integer integral;

}
