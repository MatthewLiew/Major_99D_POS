/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//   VogomoPOS - PointOfSale
//   Copyright (c) (c) 2015-2018  
//
//   This file is part of VogomoPOS
//
//   www.vogomo.com
//   
//   edited by: Matthew

package uk.chromis.pos.json.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uk.chromis.pos.customers.CustomerInfoExt;
import uk.chromis.pos.json.adapters.CouponLineAdapter;
import uk.chromis.pos.json.adapters.CouponSetAdapter;
import uk.chromis.pos.json.adapters.CustomerInfoExtAdapter;
import uk.chromis.pos.json.adapters.PaymentInfoAdapter;
import uk.chromis.pos.json.adapters.PaymentInfoCashAdapter;
import uk.chromis.pos.json.adapters.PaymentInfoCashOriginalAdapter;
import uk.chromis.pos.json.adapters.PaymentInfoFreeAdapter;
import uk.chromis.pos.json.adapters.PaymentInfoMagcardAdapter;
import uk.chromis.pos.json.adapters.PaymentInfoMagcardRefundAdapter;
import uk.chromis.pos.json.adapters.PaymentInfoTicketAdapter;
import uk.chromis.pos.json.adapters.TaxInfoAdapter;
import uk.chromis.pos.json.adapters.TicketInfoAdapter;
import uk.chromis.pos.json.adapters.TicketLineInfoAdapter;
import uk.chromis.pos.json.adapters.TicketTaxInfoAdapter;
import uk.chromis.pos.json.adapters.UserInfoAdapter;
import uk.chromis.pos.payment.PaymentInfo;
import uk.chromis.pos.payment.PaymentInfoCash;
import uk.chromis.pos.payment.PaymentInfoCash_original;
import uk.chromis.pos.payment.PaymentInfoFree;
import uk.chromis.pos.payment.PaymentInfoMagcard;
import uk.chromis.pos.payment.PaymentInfoMagcardRefund;
import uk.chromis.pos.payment.PaymentInfoTicket;
import uk.chromis.pos.ticket.CouponLine;
import uk.chromis.pos.ticket.CouponSet;
import uk.chromis.pos.ticket.TaxInfo;
import uk.chromis.pos.ticket.TicketInfo;
import uk.chromis.pos.ticket.TicketLineInfo;
import uk.chromis.pos.ticket.TicketTaxInfo;
import uk.chromis.pos.ticket.UserInfo;

/**
 *
 * @author Dell Dev 2
 */
public class TicketJsonParser {
    
    private final Gson gson;
    
    public TicketJsonParser() {
        gson = new GsonBuilder()
                .registerTypeAdapter(CouponLine.class, new CouponLineAdapter())
                .registerTypeAdapter(CouponSet.class, new CouponSetAdapter())
                .registerTypeAdapter(CustomerInfoExt.class, new CustomerInfoExtAdapter())
                .registerTypeAdapter(PaymentInfo.class, new PaymentInfoAdapter())
                .registerTypeAdapter(PaymentInfoCash.class, new PaymentInfoCashAdapter())
                .registerTypeAdapter(PaymentInfoCash_original.class, new PaymentInfoCashOriginalAdapter())
                .registerTypeAdapter(PaymentInfoFree.class, new PaymentInfoFreeAdapter())
                .registerTypeAdapter(PaymentInfoMagcard.class, new PaymentInfoMagcardAdapter())
                .registerTypeAdapter(PaymentInfoMagcardRefund.class, new PaymentInfoMagcardRefundAdapter())
                .registerTypeAdapter(PaymentInfoTicket.class, new PaymentInfoTicketAdapter())
                .registerTypeAdapter(TaxInfo.class, new TaxInfoAdapter())
                .registerTypeAdapter(TicketInfo.class, new TicketInfoAdapter())
                .registerTypeAdapter(TicketLineInfo.class, new TicketLineInfoAdapter())
                .registerTypeAdapter(TicketTaxInfo.class, new TicketTaxInfoAdapter())
                .registerTypeAdapter(UserInfo.class, new UserInfoAdapter())
                .serializeNulls()
                .create();
    }
    
    public String serialize(TicketInfo ticket) {
        return gson.toJson(ticket);
    }
    
    public TicketInfo deserialize(String json) {
        return gson.fromJson(json, TicketInfo.class);
    }
}
