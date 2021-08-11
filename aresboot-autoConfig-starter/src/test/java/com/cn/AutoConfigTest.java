package com.cn;

import com.yitong.StartAutoConfigApplication;
import com.yitong.vo.Detp;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author xy
 * @date 2021-8-10
 */
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = StartAutoConfigApplication.class)
public class AutoConfigTest {

    @Autowired
    @Qualifier("xueyan.yookt.dept-com.yitong.vo.Detp")
    private Detp detp;


    @Test
    public void test1(){
        System.out.println(this.detp);
    }
}
