package com.miaosos.service.system;

import java.util.List;
import java.util.Map;

/**
 * @Auther zln
 * @Date 2018-09-19
 * @Description :
 */
public interface IRoleService {
    /**
     * 获取所有角色
     * @return
     */
    List<Map<String,String>> findAllRole();

}
