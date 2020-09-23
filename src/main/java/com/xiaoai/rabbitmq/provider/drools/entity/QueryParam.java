package com.xiaoai.rabbitmq.provider.drools.entity;

public class QueryParam {

    private String paramId ;

    private String paramSign ;

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public String getParamSign() {
        return paramSign;
    }

    public void setParamSign(String paramSign) {
        this.paramSign = paramSign;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "paramId='" + paramId + '\'' +
                ", paramSign='" + paramSign + '\'' +
                '}';
    }
}
