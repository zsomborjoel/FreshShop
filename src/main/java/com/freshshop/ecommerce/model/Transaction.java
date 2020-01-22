package com.freshshop.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cc_transactions", schema = "freshshop")
public class Transaction {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Order order;

    @Column(name = "transdate")
    private LocalDateTime transactionDate;

    @Column(name = "processor")
    private String processor;

    @Column(name = "processor_trans_id")
    private String processorTransactionId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "cc_num")
    private String creditCardNumber;

    @Column(name = "cc_type")
    private String creditCardType;

    @Column(name = "response")
    private String response;

    public Transaction() {
    }

    public Transaction(Long id, String code, Order order, LocalDateTime transactionDate, String processor, String processorTransactionId, BigDecimal amount, String creditCardNumber, String creditCardType, String response) {
        this.id = id;
        this.code = code;
        this.order = order;
        this.transactionDate = transactionDate;
        this.processor = processor;
        this.processorTransactionId = processorTransactionId;
        this.amount = amount;
        this.creditCardNumber = creditCardNumber;
        this.creditCardType = creditCardType;
        this.response = response;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDateTime getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getProcessorTransactionId() {
        return this.processorTransactionId;
    }

    public void setProcessorTransactionId(String processorTransactionId) {
        this.processorTransactionId = processorTransactionId;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreditCardNumber() {
        return this.creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardType() {
        return this.creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Transaction id(Long id) {
        this.id = id;
        return this;
    }

    public Transaction code(String code) {
        this.code = code;
        return this;
    }

    public Transaction order(Order order) {
        this.order = order;
        return this;
    }

    public Transaction transactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public Transaction processor(String processor) {
        this.processor = processor;
        return this;
    }

    public Transaction processorTransactionId(String processorTransactionId) {
        this.processorTransactionId = processorTransactionId;
        return this;
    }

    public Transaction amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Transaction creditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        return this;
    }

    public Transaction creditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
        return this;
    }

    public Transaction response(String response) {
        this.response = response;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(id, transaction.id) && Objects.equals(code, transaction.code) && Objects.equals(order, transaction.order) && Objects.equals(transactionDate, transaction.transactionDate) && Objects.equals(processor, transaction.processor) && Objects.equals(processorTransactionId, transaction.processorTransactionId) && Objects.equals(amount, transaction.amount) && Objects.equals(creditCardNumber, transaction.creditCardNumber) && Objects.equals(creditCardType, transaction.creditCardType) && Objects.equals(response, transaction.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, order, transactionDate, processor, processorTransactionId, amount, creditCardNumber, creditCardType, response);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", code='" + getCode() + "'" +
            ", order='" + getOrder() + "'" +
            ", transactionDate='" + getTransactionDate() + "'" +
            ", processor='" + getProcessor() + "'" +
            ", processorTransactionId='" + getProcessorTransactionId() + "'" +
            ", amount='" + getAmount() + "'" +
            ", creditCardNumber='" + getCreditCardNumber() + "'" +
            ", creditCardType='" + getCreditCardType() + "'" +
            ", response='" + getResponse() + "'" +
            "}";
    }

}