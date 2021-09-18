package com.cn.nbcb.action;

import com.cn.nbcb.vo.MmpVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * durid连接池测试
 * @author xy
 * @date 2021-8-24d
 */
@RequestMapping("mmp/*")
@RestController
@Slf4j
public class DruidAction {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    @Qualifier("mmpDataSource")
    private DataSource mmp;
//
//    @Autowired
//    @Qualifier("mmcDataSource")
    private DataSource mmc;


    @PostMapping("mmp")
    public void druid() throws SQLException {
        String sql = "select t.taskid,t.servertime from TBS_MMP t";
        List<MmpVo> list = new ArrayList<>();
//        list = this.jdbcTemplate.query(sql, (RowMapper<MmpVo>) (rs,rowNum)->{
//            MmpVo mmpVo = new MmpVo();
//            mmpVo.setTaskid(rs.getString(1));
//            mmpVo.setServerTime(rs.getString(2));
//            return mmpVo;
//        });
        log.info("================={}",list);
    }
    @PostMapping("mmpmmc")
    public void druid1() throws SQLException {
        log.info("mmp================={}",mmp.getConnection());
        log.info("mmc================={}",mmc.getConnection());

    }

    public static void main(String[] args) {
        int num =10;

        System.out.println(DruidAction.test(num));
    }

    public static int test(int b){
        try {
            b+=10;
            return b;
        }catch (Exception e){
return 1;
        }finally {
            b+=10;
            return b;
        }
    }
}
