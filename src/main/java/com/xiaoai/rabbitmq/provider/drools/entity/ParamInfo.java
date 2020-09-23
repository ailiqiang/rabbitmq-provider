package com.xiaoai.rabbitmq.provider.drools.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("re_param_info")
public class ParamInfo {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id ;
    private String paramSign ;
    private Date createTime ;
    private Date updateTime ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamSign() {
        return paramSign;
    }

    public void setParamSign(String paramSign) {
        this.paramSign = paramSign;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
