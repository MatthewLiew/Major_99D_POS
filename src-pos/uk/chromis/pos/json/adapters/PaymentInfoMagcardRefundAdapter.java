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
import uk.chromis.pos.payment.PaymentInfoMagcardRefund;

/**
 *
 * @author Matthew
 */
public class PaymentInfoMagcardRefundAdapter extends BaseAdapter<PaymentInfoMagcardRefund>{
    
    private static final String HOLDER_NAME_PROPERTY = "HolderName";
    private static final String CARD_NUMBER_PROPERTY = "CardNumber";
    private static final String EXPIRATION_DATE_PROPERTY = "ExpirationDate";
    private static final String TRACK1_PROPERTY = "Track1";
    private static final String TRACK2_PROPERTY = "Track2";
    private static final String TRACK3_PROPERTY = "Track3";
    private static final String TRANSACTION_ID_PROPERTY = "TransactionId";
    private static final String TOTAL_PROPERTY = "Total";
   
    @Override
    public JsonElement serialize(PaymentInfoMagcardRefund payment, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.addProperty(PaymentInfoAdapter.TYPE_PROPERTY, PaymentInfoMagcardRefund.class.getSimpleName());
        object.addProperty(HOLDER_NAME_PROPERTY, payment.getHolderName());
        object.addProperty(CARD_NUMBER_PROPERTY, payment.getCardNumber());
        object.addProperty(EXPIRATION_DATE_PROPERTY, payment.getExpirationDate());
        object.addProperty(TRACK1_PROPERTY, payment.getTrack1(true));
        object.addProperty(TRACK2_PROPERTY, payment.getTrack2(true));
        object.addProperty(TRACK3_PROPERTY, payment.getTrack3(true));
        object.addProperty(TRANSACTION_ID_PROPERTY, payment.getTransactionID());
        object.addProperty(TOTAL_PROPERTY, payment.getTotal());
        
        return object;
    }

    @Override
    public PaymentInfoMagcardRefund deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        PaymentInfoMagcardRefund payment = new PaymentInfoMagcardRefund(
                wrapper.getString(HOLDER_NAME_PROPERTY),
                wrapper.getString(CARD_NUMBER_PROPERTY),
                wrapper.getString(EXPIRATION_DATE_PROPERTY),
                wrapper.getString(TRACK1_PROPERTY),
                wrapper.getString(TRACK2_PROPERTY),
                wrapper.getString(TRACK3_PROPERTY),
                wrapper.getString(TRANSACTION_ID_PROPERTY),
                wrapper.getDouble(TOTAL_PROPERTY));
        
        return payment;
    }
}
