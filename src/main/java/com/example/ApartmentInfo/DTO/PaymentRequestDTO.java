package com.example.ApartmentInfo.DTO;

import java.util.Date;

public class PaymentRequestDTO {
    private int pid;
    private int uid;
    private double amount;
    private Date paymentDate;
    private String method;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PaymentRequestDTO(int pid, int uid, double amount, Date paymentDate, String method) {
        this.pid = pid;
        this.uid = uid;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.method = method;
    }
}
