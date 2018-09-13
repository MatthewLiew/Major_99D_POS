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
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;
import uk.chromis.pos.customers.CustomerInfoExt;
import uk.chromis.pos.json.util.JsonObjectWrapper;
import uk.chromis.pos.payment.PaymentInfo;
import uk.chromis.pos.ticket.CouponSet;
import uk.chromis.pos.ticket.TicketInfo;
import uk.chromis.pos.ticket.TicketLineInfo;
import uk.chromis.pos.ticket.TicketTaxInfo;
import uk.chromis.pos.ticket.TicketType;
import uk.chromis.pos.ticket.UserInfo;

/**
 *
 * @author Matthew
 */
public class TicketInfoAdapter extends BaseAdapter<TicketInfo>{
    
    private static final String HOST_PROPERTY = "Host";
    private static final String ID_PROPERTY = "Id";
    private static final String TICKET_TYPE_PROPERTY = "TicketType";
    private static final String TICKET_ID_PROPERTY = "TicketId";
    private static final String PICKUP_ID_PROPERTY = "PickupId";
    private static final String DATE_PROPERTY = "Date";
    private static final String PROPERTIES_PROPERTY = "Properties";
    private static final String USER_PROPERTY = "User";
    private static final String CUSTOMER_PROPERTY = "Customer";
    private static final String ACTIVE_CASH_PROPERTY = "ActiveCash";
    private static final String LINES_PROPERTY = "Lines";
    private static final String PAYMENTS_PROPERTY = "Payments";
    private static final String TAXES_PROPERTY = "Taxes";
    private static final String COUPONS_PROPERTY = "Coupons";
    private static final String LOYALTY_CARD_NUMBER_PROPERTY = "LoyaltyCardNumber";
    private static final String OLD_TICKET_PROPERTY = "OldTicket";
    private static final String SHARED_TICKET_PROPERTY = "SharedTicket";
    private static final String SHARED_TICKET_USER_PROPERTY = "SharedTicketUser";
    private static final String NO_SC_PROPERTY = "NoSC";
    
    @Override
    public JsonElement serialize(TicketInfo ticket, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.addProperty(HOST_PROPERTY, ticket.getHost());
        object.addProperty(ID_PROPERTY, ticket.getId());
        object.addProperty(TICKET_TYPE_PROPERTY, ticket.getTicketType().getId());
        object.addProperty(TICKET_ID_PROPERTY, ticket.getTicketId());
        object.addProperty(PICKUP_ID_PROPERTY, ticket.getPickupId());
        object.addProperty(DATE_PROPERTY, getFormattedDate(ticket.getDate()));
        object.add(PROPERTIES_PROPERTY, context.serialize(ticket.getProperties()));
        object.add(USER_PROPERTY, context.serialize(ticket.getUser()));
        object.add(CUSTOMER_PROPERTY, context.serialize(ticket.getCustomer()));
        object.addProperty(ACTIVE_CASH_PROPERTY, ticket.getActiveCash());
        object.add(LINES_PROPERTY, context.serialize(ticket.getLines()));
        object.add(PAYMENTS_PROPERTY, context.serialize(ticket.getPayments()));
        object.add(TAXES_PROPERTY, context.serialize(ticket.getTaxes()));
        object.add(COUPONS_PROPERTY, context.serialize(ticket.getCouponSet()));
        object.addProperty(LOYALTY_CARD_NUMBER_PROPERTY, ticket.getLoyaltyCardNumber());
        object.addProperty(OLD_TICKET_PROPERTY, ticket.getOldTicket());
        object.addProperty(SHARED_TICKET_PROPERTY, ticket.isSharedTicket());
        object.add(SHARED_TICKET_USER_PROPERTY, context.serialize(ticket.getSharedTicketUser()));
        object.addProperty(NO_SC_PROPERTY, ticket.getNoSC());
        
        return object;
    }

    @Override
    public TicketInfo deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        TicketInfo ticket = new TicketInfo();
        ticket.setHost(wrapper.getString(HOST_PROPERTY));
        ticket.setId(wrapper.getString(ID_PROPERTY));
        ticket.setTicketType(TicketType.get(wrapper.getInteger(TICKET_TYPE_PROPERTY)));
        ticket.setTicketId(wrapper.getInteger(TICKET_ID_PROPERTY));
        ticket.setPickupId(wrapper.getInteger(PICKUP_ID_PROPERTY));
        ticket.setDate(getParsedDate(wrapper.getString(DATE_PROPERTY)));
        ticket.setProperties(wrapper.getObject(PROPERTIES_PROPERTY, Properties.class));
        ticket.setUser(wrapper.getObject(USER_PROPERTY, UserInfo.class));
        ticket.setCustomer(wrapper.getObject(CUSTOMER_PROPERTY, CustomerInfoExt.class));
        ticket.setActiveCash(wrapper.getString(ACTIVE_CASH_PROPERTY));
        ticket.setLines(wrapper.getObject(LINES_PROPERTY, new TypeToken<List<TicketLineInfo>>(){}.getType()));
        ticket.setPayments(wrapper.getObject(PAYMENTS_PROPERTY, new TypeToken<List<PaymentInfo>>(){}.getType()));
        ticket.setTaxes(wrapper.getObject(TAXES_PROPERTY, new TypeToken<List<TicketTaxInfo>>(){}.getType()));
        ticket.setCouponSet(wrapper.getObject(COUPONS_PROPERTY, CouponSet.class));
        ticket.setLoyaltyCardNumber(wrapper.getString(LOYALTY_CARD_NUMBER_PROPERTY));
        ticket.setOldTicket(wrapper.getBoolean(OLD_TICKET_PROPERTY));
        ticket.setSharedTicket(wrapper.getBoolean(SHARED_TICKET_PROPERTY));
        ticket.setSharedTicketUser(wrapper.getObject(SHARED_TICKET_USER_PROPERTY, UserInfo.class));
        ticket.setNoSC(wrapper.getString(NO_SC_PROPERTY));
        
        return ticket;
    }
}
