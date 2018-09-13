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
import java.util.Properties;
import uk.chromis.pos.json.util.JsonObjectWrapper;
import uk.chromis.pos.ticket.TaxInfo;
import uk.chromis.pos.ticket.TicketLineInfo;

/**
 *
 * @author Matthew
 */
public class TicketLineInfoAdapter extends BaseAdapter<TicketLineInfo>{
    
    private static final String TICKET_PROPERTY = "Ticket";
    private static final String TICKET_LINE_PROPERTY = "TicketLine";
    private static final String MULTIPLY_PROPERTY = "Multiply";
    private static final String PRICE_PROPERTY = "Price";
    private static final String TAX_PROPERTY = "Tax";
    private static final String PROPERTIES_PROPERTY = "Properties";
    private static final String PRODUCT_ID_PROPERTY = "ProductId";
    private static final String ATTRIBUTE_SET_INSTANCE_ID_PROPERTY = "AttributeSetInstanceId";
    private static final String UPDATED_PROPERTY = "Updated";
    private static final String REFUND_QUANTITY_PROPERTY = "RefundQuantity";
    private static final String ORDER_QUANTITY_PROPERTY = "OrderQuantity";
    
    @Override
    public JsonElement serialize(TicketLineInfo line, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.addProperty(TICKET_PROPERTY, line.getTicket());
        object.addProperty(TICKET_LINE_PROPERTY, line.getTicketLine());
        object.addProperty(MULTIPLY_PROPERTY, line.getMultiply());
        object.addProperty(PRICE_PROPERTY, line.getPrice());
        object.add(TAX_PROPERTY, context.serialize(line.getTaxInfo()));
        object.add(PROPERTIES_PROPERTY, context.serialize(line.getProperties()));
        object.addProperty(PRODUCT_ID_PROPERTY, line.getProductID());
        object.addProperty(ATTRIBUTE_SET_INSTANCE_ID_PROPERTY, line.getProductAttSetInstId());
        object.addProperty(UPDATED_PROPERTY, line.getUpdated());
        object.addProperty(REFUND_QUANTITY_PROPERTY, line.getRefundQty());
        object.addProperty(ORDER_QUANTITY_PROPERTY, line.getOrderQty());        
        
        return object;
    }

    @Override
    public TicketLineInfo deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        TicketLineInfo line = new TicketLineInfo();
        line.setTicket(wrapper.getString(TICKET_PROPERTY));
        line.setTicketLine(wrapper.getInteger(TICKET_LINE_PROPERTY));
        line.setMultiply(wrapper.getDouble(MULTIPLY_PROPERTY));
        line.setPrice(wrapper.getDouble(PRICE_PROPERTY));
        line.setTaxInfo(wrapper.getObject(TAX_PROPERTY, TaxInfo.class));
        line.setProperties(wrapper.getObject(PROPERTIES_PROPERTY, Properties.class));
        line.setProductID(wrapper.getString(PRODUCT_ID_PROPERTY));
        line.setProductAttSetInstId(wrapper.getString(ATTRIBUTE_SET_INSTANCE_ID_PROPERTY));
        line.setUpdated(wrapper.getBoolean(UPDATED_PROPERTY));
        line.setRefundQty(wrapper.getDouble(REFUND_QUANTITY_PROPERTY));
        line.setOrderQty(wrapper.getDouble(ORDER_QUANTITY_PROPERTY));
        
        return line;
    }
}
