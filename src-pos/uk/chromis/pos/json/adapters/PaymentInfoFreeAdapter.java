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
import uk.chromis.pos.payment.PaymentInfoFree;

/**
 *
 * @author Matthew
 */
public class PaymentInfoFreeAdapter extends BaseAdapter<PaymentInfoFree>{
    
    private static final String TOTAL_PROPERTY = "Total";
    
    @Override
    public JsonElement serialize(PaymentInfoFree payment, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.addProperty(PaymentInfoAdapter.TYPE_PROPERTY, PaymentInfoFree.class.getSimpleName());
        object.addProperty(TOTAL_PROPERTY, payment.getTotal());
        
        return object;
    }
    
    @Override
    public PaymentInfoFree deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        PaymentInfoFree payment = new PaymentInfoFree(
                wrapper.getDouble(TOTAL_PROPERTY));
        
        return payment;
    }
}
