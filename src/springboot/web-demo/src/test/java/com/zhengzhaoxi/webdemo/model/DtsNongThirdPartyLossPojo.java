package com.zhengzhaoxi.webdemo.model;

public class DtsNongThirdPartyLossPojo {


    public java.lang.String thirdPropertyName;

    public java.lang.String thirdPropertyOwner;

    public java.lang.String thirdPropertyOwnerIdNo;

    public java.lang.String remark;



    public DtsNongThirdPartyLossPojo(){
    }






    public java.lang.String getThirdPropertyName() {
        return this.thirdPropertyName;
    }

    public void setThirdPropertyName(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
        }
        this.thirdPropertyName = value;
    }

    public java.lang.String getThirdPropertyOwner() {
        return this.thirdPropertyOwner;
    }

    public void setThirdPropertyOwner(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
        }
        this.thirdPropertyOwner = value;
    }

    public java.lang.String getThirdPropertyOwnerIdNo() {
        return this.thirdPropertyOwnerIdNo;
    }

    public void setThirdPropertyOwnerIdNo(java.lang.String value) {
        if(value!=null){
            if("".equals(value.trim()))
            {
                // 将前端的空字符串转化成null
                value= null;
            }
        }
        this.thirdPropertyOwnerIdNo = value;
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
