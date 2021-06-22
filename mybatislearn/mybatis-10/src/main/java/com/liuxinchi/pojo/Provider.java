package com.liuxinchi.pojo;

import java.util.Date;

public class Provider {
    private Long id;

    private String procode;

    private String proname;

    private String prodesc;

    private String procontact;

    private String prophone;

    private String proaddress;

    private String profax;

    private Long createdby;

    private Date creationdate;

    private Date modifydate;

    private Long modifyby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcode() {
        return procode;
    }

    public void setProcode(String procode) {
        this.procode = procode;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProdesc() {
        return prodesc;
    }

    public void setProdesc(String prodesc) {
        this.prodesc = prodesc;
    }

    public String getProcontact() {
        return procontact;
    }

    public void setProcontact(String procontact) {
        this.procontact = procontact;
    }

    public String getProphone() {
        return prophone;
    }

    public void setProphone(String prophone) {
        this.prophone = prophone;
    }

    public String getProaddress() {
        return proaddress;
    }

    public void setProaddress(String proaddress) {
        this.proaddress = proaddress;
    }

    public String getProfax() {
        return profax;
    }

    public void setProfax(String profax) {
        this.profax = profax;
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

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    @Override
    public String toString() {
        return "Provider [createdby=" + createdby + ", creationdate=" + creationdate + ", id=" + id + ", modifyby="
                + modifyby + ", modifydate=" + modifydate + ", proaddress=" + proaddress + ", procode=" + procode
                + ", procontact=" + procontact + ", prodesc=" + prodesc + ", profax=" + profax + ", proname=" + proname
                + ", prophone=" + prophone + "]";
    }

    public Provider(Long id, String procode, String proname, String prodesc, String procontact, String prophone,
            String proaddress, String profax, Long createdby, Date creationdate, Date modifydate, Long modifyby) {
        this.id = id;
        this.procode = procode;
        this.proname = proname;
        this.prodesc = prodesc;
        this.procontact = procontact;
        this.prophone = prophone;
        this.proaddress = proaddress;
        this.profax = profax;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.modifydate = modifydate;
        this.modifyby = modifyby;
    }

    public Provider() {
    }
}
