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
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import uk.chromis.pos.json.util.JsonObjectWrapper;
import uk.chromis.pos.payment.PaymentInfo;

/**
 *
 * @author Matthew
 */
public class PaymentInfoAdapter extends BaseAdapter<PaymentInfo> {
    
    static final String TYPE_PROPERTY = "Type";
    
    @Override
    public JsonElement serialize(PaymentInfo payment, Type type, JsonSerializationContext context) {
        return JsonNull.INSTANCE;
    }
    
    @Override
    public PaymentInfo deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        String implementation = wrapper.getString(TYPE_PROPERTY);
        JsonDeserializer<? extends PaymentInfo> deserializer;
        
        switch (implementation) {
            case "PaymentInfoCash":
                deserializer = new PaymentInfoCashAdapter();
                break;
            case "PaymentInfoCash_original":
                deserializer = new PaymentInfoCashOriginalAdapter();
                break;
            case "PaymentInfoFree":
                deserializer = new PaymentInfoFreeAdapter();
                break;
            case "PaymentInfoMagcard":
                deserializer = new PaymentInfoMagcardAdapter();
                break;
            case "PaymentInfoMagcardRefund":
                deserializer = new PaymentInfoMagcardRefundAdapter();
                break;
            case "PaymentInfoTicket":
                deserializer = new PaymentInfoTicketAdapter();
                break;
            default:
                throw new IllegalStateException("invalid payment type");
        }
        
        return deserializer.deserialize(element, type, context);
    }
}
