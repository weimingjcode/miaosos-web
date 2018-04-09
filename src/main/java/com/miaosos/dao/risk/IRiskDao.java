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
                "g.gps_status=#{status} " +
            "order by " +
                "g.id desc")
    List<Map<String, String>> findGpsInfoByStatus(@Param("status") Integer status);

    @ResultType(Map.class)
    @Select("select id,gps_addr,gps_latitude,gps_dimension,gps_time,gps_info_id from gps_addr where gps_info_id=#{gpsInfoId} order by gps_time desc")
    List<Map<String,String>> findGpsAddrByGpsInfoId(@Param("gpsInfoId") Integer gpsInfoId);
}
