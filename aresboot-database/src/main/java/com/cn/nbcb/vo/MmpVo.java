package com.cn.nbcb.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author xy
 * @date 2021-8-25
 */
@Data
@TableName("MMP_TEMP")
public class MmpVo {

    private String taskid;

    private String timeser;

    /*@TableField(fill = FieldFill.INSERT_UPDATE)
    private String flag;*/
}
