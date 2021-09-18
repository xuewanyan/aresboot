package com.cn.nbcb.service.impl;

import com.cn.nbcb.dao.IMmpDao;
import com.cn.nbcb.service.IMmpService;
import com.cn.nbcb.vo.MmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author xy
 * @date 2021-8-26
 */
@Service
public class MmpServiceImpl implements IMmpService {

    @Autowired
    private IMmpDao iMmpDao;

    @Override
    public List<MmpVo> list() {
        List<MmpVo> list =  iMmpDao.findAll();
        return null;
    }
}
