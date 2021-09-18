package com.cn.nbcb.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * mmc实例
 * @author xy
 * @date 2021-9-7
 */
@Data
@TableName("MMP_TEMP")
public class MmcVo {

    private String taskid;

    private String timeser;

//    private String identNo;

   /* @TableField(fill = FieldFill.INSERT_UPDATE)
    private String flag;*/
}
