package com.miaosos.controller.mptest;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.miaosos.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther zln
 * @Date 2018-09-25
 * @Description :
 */
@Controller
public class MpControlelr {

    @Autowired
    SysUserMapper sysUserMapper;

    @GetMapping("testMp")
    public void testMp() {
       /* QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.gt("user_id","1");
        Page<SysUser> page = new Page<>(1,5);
        IPage<SysUser> userIPage = sysUserMapper.selectPage(page, wrapper);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        for (SysUser sysUser : userIPage.getRecords()) {
            System.out.println(sysUser);
        }*/
        //用来获取Mybatis-Plus.properties文件的配置信息
        AutoGenerator mpg = new AutoGenerator();
// 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(System.getProperty("user.dir"));
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("zln");
        mpg.setGlobalConfig(gc);
// 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://localhost:3306/miaosos");
        mpg.setDataSource(dsc);
// 策略配置
        StrategyConfig strategy = new StrategyConfig();
//strategy.setTablePrefix(new String[] { "bmd_", "mp_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[]{"sys_user"}); // 需要生成的表
// 字段名生成策略
// strategy.setFieldNaming(NamingStrategy.underline_to_camel);
//strategy.setSuperServiceImplClass("com.baomidou.springwind.service.support.BaseServiceImpl");
        mpg.setStrategy(strategy);
// 包配置
        PackageConfig pc = new PackageConfig();
// pc.setModuleName("test");
        pc.setParent(System.getProperty("user.dir")+".com.miaosos.mp");// 自定义包路径
        pc.setController("controller.mp");// 这里是控制器包名，默认 web
        pc.setEntity("model.mp");
        pc.setMapper("dao.mp");
        pc.setService("service.mp");
        pc.setServiceImpl("service.mp");
        mpg.setPackageInfo(pc);
// 执行生成
        mpg.execute();
    }
}
