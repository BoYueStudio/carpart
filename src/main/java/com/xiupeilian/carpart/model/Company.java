package com.xiupeilian.carpart.model;

import java.util.Date;

public class Company {
    private Integer id;

    private String companyCode;

    private String companyName;

    private String address;

    private Integer province;

    private Integer city;

    private Integer county;

    private String tel1;

    private String tel2;

    private String phone;

    private String main;

    private String singleBrand;

    private String singleParts;

    private String prime;

    private String leader;

    private Date createTime;

    private String picurl1;

    private String picurl2;

    private String picurl3;

    private Integer deleteStatus;

    private String qq;

    private String zone1;

    private String zone2;

    private String reservedField1;

    private String reservedField2;

    private String reservedField3;

    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1 == null ? null : tel1.trim();
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2 == null ? null : tel2.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main == null ? null : main.trim();
    }

    public String getSingleBrand() {
        return singleBrand;
    }

    public void setSingleBrand(String singleBrand) {
        this.singleBrand = singleBrand == null ? null : singleBrand.trim();
    }

    public String getSingleParts() {
        return singleParts;
    }

    public void setSingleParts(String singleParts) {
        this.singleParts = singleParts == null ? null : singleParts.trim();
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime == null ? null : prime.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPicurl1() {
        return picurl1;
    }

    public void setPicurl1(String picurl1) {
        this.picurl1 = picurl1 == null ? null : picurl1.trim();
    }

    public String getPicurl2() {
        return picurl2;
    }

    public void setPicurl2(String picurl2) {
        this.picurl2 = picurl2 == null ? null : picurl2.trim();
    }

    public String getPicurl3() {
        return picurl3;
    }

    public void setPicurl3(String picurl3) {
        this.picurl3 = picurl3 == null ? null : picurl3.trim();
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getZone1() {
        return zone1;
    }

    public void setZone1(String zone1) {
        this.zone1 = zone1 == null ? null : zone1.trim();
    }

    public String getZone2() {
        return zone2;
    }

    public void setZone2(String zone2) {
        this.zone2 = zone2 == null ? null : zone2.trim();
    }

    public String getReservedField1() {
        return reservedField1;
    }

    public void setReservedField1(String reservedField1) {
        this.reservedField1 = reservedField1 == null ? null : reservedField1.trim();
    }

    public String getReservedField2() {
        return reservedField2;
    }

    public void setReservedField2(String reservedField2) {
        this.reservedField2 = reservedField2 == null ? null : reservedField2.trim();
    }

    public String getReservedField3() {
        return reservedField3;
    }

    public void setReservedField3(String reservedField3) {
        this.reservedField3 = reservedField3 == null ? null : reservedField3.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}