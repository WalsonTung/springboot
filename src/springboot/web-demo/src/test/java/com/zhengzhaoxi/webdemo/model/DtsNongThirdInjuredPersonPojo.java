package com.zhengzhaoxi.webdemo.model;

public class DtsNongThirdInjuredPersonPojo {


    public java.lang.String injuredPersonName;

    public java.lang.String injuredPersonIdNo;

    public java.lang.String remark;

    //columns END



    public DtsNongThirdInjuredPersonPojo(){
    }





    public java.lang.String getInjuredPersonName() {
        return this.injuredPersonName;
    }

    public void setInjuredPersonName(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
        }
        this.injuredPersonName = value;
    }

    public java.lang.String getInjuredPersonIdNo() {
        return this.injuredPersonIdNo;
    }

    public void setInjuredPersonIdNo(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
        }
        this.injuredPersonIdNo = value;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
        }
        this.remark = value;
    }


}
