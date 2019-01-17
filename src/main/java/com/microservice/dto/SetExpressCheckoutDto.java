/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author gonzalo
 */
@Data
@JsonInclude(Include.NON_EMPTY)
public class SetExpressCheckoutDto implements Serializable {
    
    //Credentials
    private String username;
    private String password;
    
    //General Info
    private String paymentAction;
    private String amount;
    private String currencyCode;
    private String returnUrl;
    private String cancelurl;
    private String invoiceNumber;
    private Integer noShipping;
    private String localeCode;
    private String pageStyle;
    private String legName0;
    private String legAmount;
    private String legDescription0;
    private String landingPage;
    private String custom;
    private String logoImage;
    private String email;
    private String legAirlineIssueDate;
    private String AirlineIssuingCarrierCode;
    private List<AirlineLeg> airlinesLegs; 
}
