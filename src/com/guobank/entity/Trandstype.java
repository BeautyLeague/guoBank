package com.guobank.entity;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: MyBank
 * @Package com.guobank.entity
 * @Descriptio /**
 * @Project: MyBank
 * @Package com.guobank.entity
 * @Description: TODO
 * @date Date : 2019年11月20日 9:00
 */
public class Trandstype {
    private Integer typeId;
    private String typeName;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Trandstype{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
