package com.guobank.entity;

import java.util.Date;


/**
* @Project: MyBank
* @Package com.guobank.entity
* @Descriptio
/**
* @Project: MyBank
* @Package com.guobank.entity
* @Description: TODO
* @author : pengliang
* @date Date : 2019年11月19日 8:45
* @version V1.0
*/

public class Transinfo {


    private Integer trandsid;

    private Trandstype trandstype;

    private String bankcardid;

    private Date trandsdate;

    private Float trandsmoney;

    private String trandsinfos;

    public Integer getTrandsid() {
        return trandsid;
    }

    public void setTrandsid(Integer trandsid) {
        this.trandsid = trandsid;
    }

    public Trandstype getTrandstype() {
        return trandstype;
    }

    public void setTrandstype(Trandstype trandstype) {
        this.trandstype = trandstype;
    }

    public String getBankcardid() {
        return bankcardid;
    }

    public void setBankcardid(String bankcardid) {
        this.bankcardid = bankcardid;
    }

    public Date getTrandsdate() {
        return trandsdate;
    }

    public void setTrandsdate(Date trandsdate) {
        this.trandsdate = trandsdate;
    }

    public Float getTrandsmoney() {
        return trandsmoney;
    }

    public void setTrandsmoney(Float trandsmoney) {
        this.trandsmoney = trandsmoney;
    }

    public String getTrandsinfos() {
        return trandsinfos;
    }

    public void setTrandsinfos(String trandsinfos) {
        this.trandsinfos = trandsinfos;
    }



}