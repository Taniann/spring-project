package ua.tania.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Tania Nebesna on 18.03.2019
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    private BigDecimal orderNum;
    private Customer customer;
    private Product product;
    private Salesrep salesrep;
    private Date orderDate;
    private String mfr;
    private BigDecimal qty;
    private BigDecimal amount;

    public Order() {
    }

    public Order(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public Order(BigDecimal orderNum, Customer customer, Product product, Salesrep salesrep, Date orderDate,
                 String mfr, BigDecimal qty, BigDecimal amount) {
        this.orderNum = orderNum;
        this.customer = customer;
        this.product = product;
        this.salesrep = salesrep;
        this.orderDate = orderDate;
        this.mfr = mfr;
        this.qty = qty;
        this.amount = amount;
    }

    @Id
    @Column(name = "ORDER_NUM", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUST")
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT")
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REP")
    public Salesrep getSalesrep() {
        return this.salesrep;
    }

    public void setSalesrep(Salesrep salesrep) {
        this.salesrep = salesrep;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE", length = 7)
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "MFR", length = 3)
    public String getMfr() {
        return this.mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    @Column(name = "QTY", precision = 22, scale = 0)
    public BigDecimal getQty() {
        return this.qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    @Column(name = "AMOUNT", precision = 22, scale = 0)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum=" + orderNum +
                ", customer=" + customer +
                ", product=" + product +
                ", salesrep=" + salesrep +
                ", orderDate=" + orderDate +
                ", mfr='" + mfr + '\'' +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
