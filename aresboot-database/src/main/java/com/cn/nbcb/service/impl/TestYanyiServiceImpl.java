package com.cn.nbcb.service.impl;

import com.cn.nbcb.annotation.CacheAnntation;
import com.cn.nbcb.service.TestYanyiService;
import org.springframework.stereotype.Service;

/**
 * @author xy
 * @date 2021-9-2
 */
@Service
public class TestYanyiServiceImpl implements TestYanyiService {
    @Override
    public int test(int i) {
        return 0;
    }

    @Override
    public String test1(String i1) {
        return i1;
    }
}
