package com.miaosos.entity;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PageResult<T> extends Page<T>{

    private Integer rows;
    private List<Map<String,String>> pageData;

}
