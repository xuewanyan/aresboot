package com.cn.nbcb.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.cn.nbcb.vo.MmcVo;
import com.cn.nbcb.vo.MmpVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author xy
 * @date 2021-9-7
 */
@Component
@Slf4j
public class FlagMateObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if(MmpVo.class.equals(metaObject.getOriginalObject().getClass())){
            this.setFieldValByName("flag","insertMMP",metaObject);
        }else if(MmcVo.class.equals(metaObject.getOriginalObject().getClass())){
            this.setFieldValByName("flag","insertMMC",metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(MmpVo.class.equals(metaObject.getOriginalObject().getClass())){
            this.setFieldValByName("flag","updateMMP",metaObject);
        }else if(MmcVo.class.equals(metaObject.getOriginalObject().getClass())){
            this.setFieldValByName("flag","updateMMC",metaObject);
        }
    }
}
