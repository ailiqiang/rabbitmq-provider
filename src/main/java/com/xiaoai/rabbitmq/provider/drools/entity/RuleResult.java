package com.xiaoai.rabbitmq.provider.drools.entity;

public class RuleResult {

    private boolean postCodeResult = false ;

    public boolean isPostCodeResult() {
        return postCodeResult;
    }

    public void setPostCodeResult(boolean postCodeResult) {
        this.postCodeResult = postCodeResult;
    }

    @Override
    public String toString() {
        return "RuleResult{" +
                "postCodeResult=" + postCodeResult +
                '}';
    }
}
