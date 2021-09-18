package com.cn.nbcb.dao.mmc;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.nbcb.vo.MmpVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xy
 * @date 2021-9-7
 */
@Mapper
public interface MmcDao extends BaseMapper<MmpVo> {
}
