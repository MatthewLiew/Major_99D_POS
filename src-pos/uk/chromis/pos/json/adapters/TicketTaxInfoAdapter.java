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
import uk.chromis.pos.ticket.TaxInfo;
import uk.chromis.pos.ticket.TicketTaxInfo;

/**
 *
 * @author Matthew
 */
public class TicketTaxInfoAdapter extends BaseAdapter<TicketTaxInfo>{
    
    private static final String TAX_PROPERTY = "Tax";
    private static final String SUB_TOTAL_PROPERTY = "SubTotal";
    private static final String TAX_TOTAL_PROPERTY = "TaxTotal";
    
    @Override
    public JsonElement serialize(TicketTaxInfo tax, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.add(TAX_PROPERTY, context.serialize(tax.getTaxInfo()));
        object.addProperty(SUB_TOTAL_PROPERTY, tax.getSubTotal());
        object.addProperty(TAX_TOTAL_PROPERTY, tax.getTax());
        
        return object;
    }

    @Override
    public TicketTaxInfo deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        TicketTaxInfo tax = new TicketTaxInfo(
                wrapper.getObject(TAX_PROPERTY, TaxInfo.class),
                wrapper.getDouble(SUB_TOTAL_PROPERTY),
                wrapper.getDouble(TAX_TOTAL_PROPERTY));
        
        return tax;
    }
}
