package com.cn.nbcb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.nbcb.dao.mmc.MmcDao;
import com.cn.nbcb.dao.mmp.MmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xy
 * @date 2021-9-8
 */
@Service
public class MmpMmpImpl   {

    private MmpDao mmpDao;

    private MmcDao mmcDao;

    public Map<String, Object> list() {
        Map<String,Object> map = new HashMap<>();
        map.put("mmc",this.mmcDao.selectList(new QueryWrapper<>()));
        map.put("mmp",this.mmpDao.selectList(new QueryWrapper<>()));
        return map;
    }
}
