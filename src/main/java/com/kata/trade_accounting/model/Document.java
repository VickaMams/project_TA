package com.kata.trade_accounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DocumentType type;
    private DocumentStatus status;
    private DocumentExpenseItem expenseItem;
    private Integer documentNumber;
    private Integer incomingNumber;
    private Date incomingNumberDate;
    private Date documentDate;
    private Date planningShippingDate;
    private Date planningPaymentDate;
    private Date planningAcceptanceDate;
    private Date sent;
    private Date printed;
    private Double sum;
    private Double includingNds;
    private String agreement;
    private String shippingAddress;
    private String project;
    private String organization;
    private String comment;
    private String paymentPurpose;
    private String reason;

    @OneToOne
    @JoinColumn(name = "from_warehouse_id")
    private Warehouse fromWarehouse;

    @OneToOne
    @JoinColumn(name = "to_warehouse_id")
    private Warehouse toWarehouse;

    @OneToOne
    @JoinColumn(name = "counte_agent_id")
    private CounterAgent counterAgent;

    @OneToOne
    @JoinColumn(name = "sales_channel_id")
    private SalesChannel salesChannel;

    private boolean removed;
}
