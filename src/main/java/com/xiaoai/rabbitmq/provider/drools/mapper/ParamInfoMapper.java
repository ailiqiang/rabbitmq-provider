package com.xiaoai.rabbitmq.provider.drools.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaoai.rabbitmq.provider.drools.entity.ParamInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParamInfoMapper extends BaseMapper<ParamInfo> {

    void insertParam (ParamInfo paramInfo) ;
}
