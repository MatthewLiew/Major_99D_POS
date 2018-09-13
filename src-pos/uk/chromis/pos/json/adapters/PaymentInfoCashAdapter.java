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

package uk.chromis.pos.json.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import uk.chromis.pos.json.util.JsonObjectWrapper;
import uk.chromis.pos.payment.PaymentInfoCash;

/**
 *
 * @author Matthew
 */
public class PaymentInfoCashAdapter extends BaseAdapter<PaymentInfoCash>{
    private static final String TOTAL_PROPERTY = "Total";
    private static final String PAID_PROPERTY = "Paid";
    private static final String TENDERED_PROPERTY = "Tendered";
    private static final String PRE_PAID_AMOUNT_PROPERTY = "PrePaidAmount";
    
    @Override
    public JsonElement serialize(PaymentInfoCash payment, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.addProperty(PaymentInfoAdapter.TYPE_PROPERTY, PaymentInfoCash.class.getSimpleName());
        object.addProperty(TOTAL_PROPERTY, payment.getTotal());
        object.addProperty(PAID_PROPERTY, payment.getPaid());
        object.addProperty(TENDERED_PROPERTY, payment.getTendered());
        object.addProperty(PRE_PAID_AMOUNT_PROPERTY, payment.getPrePaid());
        
        return object;
    }

    @Override
    public PaymentInfoCash deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        PaymentInfoCash payment = new PaymentInfoCash(
                wrapper.getDouble(TOTAL_PROPERTY),
                wrapper.getDouble(PAID_PROPERTY),
                wrapper.getDouble(TENDERED_PROPERTY),
                wrapper.getDouble(PRE_PAID_AMOUNT_PROPERTY));
        
        return payment;
    }
}
