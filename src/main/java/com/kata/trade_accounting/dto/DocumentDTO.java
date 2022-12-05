package com.kata.trade_accounting.dto;

import com.kata.trade_accounting.model.DocumentExpenseItem;
import com.kata.trade_accounting.model.DocumentStatus;
import com.kata.trade_accounting.model.DocumentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema
public class DocumentDTO {
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
    private Date dateOfDeletion;
    private Double sum;
    private Double includingNds;
    private String agreement;
    private String shippingAddress;
    private String project;
    private String organization;
    private String comment;
    private String paymentPurpose;
    private String reason;
    private WarehouseDTO fromWarehouse;
    private WarehouseDTO toWarehouse;
    private CounterAgentDto counterAgent;
    private SalesChannelDTO salesChannel;
}
