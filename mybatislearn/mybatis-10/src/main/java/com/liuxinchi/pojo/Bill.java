package com.liuxinchi.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private Long id;

    private String billcode;

    private String productname;

    private String productdesc;

    public Bill() {
    }

    public Bill(Long id, String billcode, String productname, String productdesc, String productunit,
            BigDecimal productcount, BigDecimal totalprice, Integer ispayment, Long createdby, Date creationdate,
            Long modifyby, Date modifydate, Integer providerid) {
        this.id = id;
        this.billcode = billcode;
        this.productname = productname;
        this.productdesc = productdesc;
        this.productunit = productunit;
        this.productcount = productcount;
        this.totalprice = totalprice;
        this.ispayment = ispayment;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.modifyby = modifyby;
        this.modifydate = modifydate;
        this.providerid = providerid;
    }

    @Override
    public String toString() {
        return "Bill [billcode=" + billcode + ", createdby=" + createdby + ", creationdate=" + creationdate + ", id="
                + id + ", ispayment=" + ispayment + ", modifyby=" + modifyby + ", modifydate=" + modifydate
                + ", productcount=" + productcount + ", productdesc=" + productdesc + ", productname=" + productname
                + ", productunit=" + productunit + ", providerid=" + providerid + ", totalprice=" + totalprice + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getProductunit() {
        return productunit;
    }

    public void setProductunit(String productunit) {
        this.productunit = productunit;
    }

    public BigDecimal getProductcount() {
        return productcount;
    }

    public void setProductcount(BigDecimal productcount) {
        this.productcount = productcount;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getIspayment() {
        return ispayment;
    }

    public void setIspayment(Integer ispayment) {
        this.ispayment = ispayment;
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

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    private String productunit;

    private BigDecimal productcount;

    private BigDecimal totalprice;

    private Integer ispayment;

    private Long createdby;

    private Date creationdate;

    private Long modifyby;

    private Date modifydate;

    private Integer providerid;
}
