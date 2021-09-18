package com.cn.nbcb.action.mmc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("mmcdata/*")
@Slf4j
public class MmcAction {

    @Autowired
    private DataSource dataSource;


    @PostMapping("mmc1")
    public Object getMmc() throws SQLException {
        log.info("mmc=======>>>>,{}",this.dataSource);
        log.info("mmc=======>>>>,{}",this.dataSource.getConnection().getCatalog());
        return null;
    }
}
