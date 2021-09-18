package com.cn.nbcb.action.mmp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author xy
 * @date 2021-9-4
 */
@RestController
@RequestMapping("mmpdata/*")
@Slf4j
public class MmpAction {

    @Autowired
    private DataSource dataSource;

    @PostMapping("mmp1")
    public Object getMmp() throws SQLException {
        log.info("mmp=======>>>>,{}",this.dataSource);
        log.info("mmp=======>>>>,{}",this.dataSource.getConnection().getCatalog());
        return null;
    }
}
