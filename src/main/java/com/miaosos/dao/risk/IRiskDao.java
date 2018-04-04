package com.miaosos.dao.risk;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("riskDao")
public interface IRiskDao {

    @ResultType(Map.class)
    @Select("select " +
                "g.id," +
                "u.username," +
                "u.phone," +
                "g.gps_addr," +
                "g.alarm_time," +
                "d.device_no," +
                "d.device_type," +
                "g.gps_status," +
                "s.name accepter," +
                "su.name handler" +
            " from " +
                "gps_info g " +
            " join " +
                "user u " +
            " on " +
                "g.user_id=u.id " +
            " join " +
                "device d " +
            " on " +
                "g.device_no=d.device_no " +
            " join " +
                "sys_user s " +
            " on " +
                "s.user_id=g.accepter_id" +
            " left join " +
                "sys_user su " +
            " on " +
                "su.user_id = g.handler_id"+
            " where " +
                "g.gps_status=#{status}")
    List<Map> findGpsInfoByStatus(@Param("status") Integer status);
}
