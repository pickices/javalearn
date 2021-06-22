package com.liuxinchi.pojo;

import java.util.Date;

public class Address {
    private Long id;

    private String contact;

    private String addressdesc;

    @Override
    public String toString() {
        return "Address [addressdesc=" + addressdesc + ", contact=" + contact + ", createdby=" + createdby
                + ", creationdate=" + creationdate + ", id=" + id + ", modifyby=" + modifyby + ", modifydate="
                + modifydate + ", postcode=" + postcode + ", tel=" + tel + ", userid=" + userid + "]";
    }

    public Address() {
    }

    public Address(Long id, String contact, String addressdesc, String postcode, String tel, Long createdby,
            Date creationdate, Long modifyby, Date modifydate, Long userid) {
        this.id = id;
        this.contact = contact;
        this.addressdesc = addressdesc;
        this.postcode = postcode;
        this.tel = tel;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.modifyby = modifyby;
        this.modifydate = modifydate;
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressdesc() {
        return addressdesc;
    }

    public void setAddressdesc(String addressdesc) {
        this.addressdesc = addressdesc;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    private String postcode;

    private String tel;

    private Long createdby;

    private Date creationdate;

    private Long modifyby;

    private Date modifydate;

    private Long userid;
}
