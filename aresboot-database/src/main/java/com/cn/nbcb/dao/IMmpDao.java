package com.cn.nbcb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.nbcb.vo.MmpVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 定义dao接口
 * @author xy
 * @date 2021-8-26
 */
@Mapper
public interface IMmpDao extends BaseMapper<MmpVo> {

    /**
     * 查询所有
     * @return
     */
    List<MmpVo> findAll();
}
