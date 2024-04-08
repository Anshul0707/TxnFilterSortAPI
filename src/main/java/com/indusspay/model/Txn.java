package com.indusspay.model;

import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Txn {
    private String txnId;
    private String customerName;
    private String service;
    private float amount;
    private float gst;
    private float commission;
}
