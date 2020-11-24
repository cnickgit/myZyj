package com.markerhub.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: vueblog
 * @description:
 * @author: wsg
 * @create: 2020-11-24 15:04
 **/
@Data
@TableName
public class ZyjToken implements Serializable {
    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 类型说明
     */
    private String type_Remarks;

    /**
     * 金额
     */
    private String money;

    /**
     * 事件范围
     */
    private String frequency;

    /**
     * prescription
     */
    private String prescription;

    /**
     * 是否过期
     */
    private String status;

    private Date createTime;

    private Date updateTime;

}
