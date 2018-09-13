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
import uk.chromis.pos.customers.CustomerInfoExt;
import uk.chromis.pos.json.util.JsonObjectWrapper;

/**
 *
 * @author Matthew
 */
public class CustomerInfoExtAdapter extends BaseAdapter<CustomerInfoExt>{
    private static final String ID_PROPERTY = "Id";
    private static final String SEARCH_KEY_PROPERTY = "SearchKey";
    private static final String TAX_ID_PROPERTY = "TaxId";
    private static final String NAME_PROPERTY = "Name";
    private static final String POSTAL_PROPERTY = "Postal";
    private static final String PHONE_PROPERTY = "Phone";
    private static final String EMAIL_PROPERTY = "Email";
    private static final String TAX_CUSTOMER_CATEGORY_ID_PROPERTY = "TaxCustomerCategoryId";
    private static final String NOTES_PROPERTY = "Notes";
    private static final String VISIBLE_PROPERTY = "Visible";
    private static final String CARD_PROPERTY = "Card";
    private static final String MAX_DEBT_PROPERTY = "MaxDebt";
    private static final String CURRENT_DATE_PROPERTY = "CurrentDate";
    private static final String CURRENT_DEBT_PROPERTY = "CurrentDebt";
    private static final String FIRST_NAME_PROPERTY = "FirstName";
    private static final String LAST_NAME_PROPERTY = "LastName";
    private static final String PHONE2_PROPERTY = "Phone2";
    private static final String FAX_PROPERTY = "Fax";
    private static final String ADDRESS_PROPERTY = "Address";
    private static final String ADDRESS2_PROPERTY = "Address2";
    private static final String CITY_PROPERTY = "City";
    private static final String REGION_PROPERTY = "Region";
    private static final String COUNTRY_PROPERTY = "Country";
    private static final String IMAGE_PROPERTY = "Image";
    private static final String DOB_PROPERTY = "DOB";
    private static final String DISCOUNT_PROPERTY = "Discount";
    
    @Override
    public JsonElement serialize(CustomerInfoExt customer, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.addProperty(ID_PROPERTY, customer.getId());
        object.addProperty(SEARCH_KEY_PROPERTY, customer.getSearchkey());
        object.addProperty(TAX_ID_PROPERTY, customer.getTaxid());
        object.addProperty(NAME_PROPERTY, customer.getName());
        object.addProperty(POSTAL_PROPERTY, customer.getPostal());
        object.addProperty(PHONE_PROPERTY, customer.getPhone());
        object.addProperty(EMAIL_PROPERTY, customer.getEmail());
        object.addProperty(TAX_CUSTOMER_CATEGORY_ID_PROPERTY, customer.getTaxCustCategoryID());
        object.addProperty(NOTES_PROPERTY, customer.getNotes());
        object.addProperty(VISIBLE_PROPERTY, customer.isVisible());
        object.addProperty(CARD_PROPERTY, customer.getCard());
        object.addProperty(MAX_DEBT_PROPERTY, customer.getMaxdebt());
        object.addProperty(CURRENT_DATE_PROPERTY, getFormattedDate(customer.getCurdate()));
        object.addProperty(CURRENT_DEBT_PROPERTY, customer.getCurdebt());
        object.addProperty(FIRST_NAME_PROPERTY, customer.getFirstname());
        object.addProperty(LAST_NAME_PROPERTY, customer.getLastname());
        object.addProperty(PHONE2_PROPERTY, customer.getPhone2());
        object.addProperty(FAX_PROPERTY, customer.getFax());
        object.addProperty(ADDRESS_PROPERTY, customer.getAddress());
        object.addProperty(ADDRESS2_PROPERTY, customer.getAddress2());
        object.addProperty(CITY_PROPERTY, customer.getCity());
        object.addProperty(REGION_PROPERTY, customer.getRegion());
        object.addProperty(COUNTRY_PROPERTY, customer.getCountry());
        object.addProperty(IMAGE_PROPERTY, customer.getImage());
        object.addProperty(DOB_PROPERTY, getFormattedDate(customer.getDoB()));
        object.addProperty(DISCOUNT_PROPERTY, customer.getDiscount());
        
        return object;
    }

    @Override
    public CustomerInfoExt deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        CustomerInfoExt customer = new CustomerInfoExt(wrapper.getString(ID_PROPERTY));
        customer.setSearchkey(wrapper.getString(SEARCH_KEY_PROPERTY));
        customer.setTaxid(wrapper.getString(TAX_ID_PROPERTY));
        customer.setName(wrapper.getString(NAME_PROPERTY));
        customer.setPostal(wrapper.getString(POSTAL_PROPERTY));
        customer.setPhone(wrapper.getString(PHONE_PROPERTY));
        customer.setEmail(wrapper.getString(EMAIL_PROPERTY));
        customer.setTaxCustomerID(wrapper.getString(TAX_CUSTOMER_CATEGORY_ID_PROPERTY));
        customer.setNotes(wrapper.getString(NOTES_PROPERTY));
        customer.setVisible(wrapper.getBoolean(VISIBLE_PROPERTY));
        customer.setCard(wrapper.getString(CARD_PROPERTY));
        customer.setMaxdebt(wrapper.getDouble(MAX_DEBT_PROPERTY));
        customer.setCurdate(getParsedDate(wrapper.getString(CURRENT_DATE_PROPERTY)));
        customer.setCurdebt(wrapper.getDouble(CURRENT_DEBT_PROPERTY));
        customer.setFirstname(wrapper.getString(FIRST_NAME_PROPERTY));
        customer.setLastname(wrapper.getString(LAST_NAME_PROPERTY));
        customer.setPhone2(wrapper.getString(PHONE2_PROPERTY));
        customer.setFax(wrapper.getString(FAX_PROPERTY));
        customer.setAddress(wrapper.getString(ADDRESS_PROPERTY));
        customer.setAddress2(wrapper.getString(ADDRESS2_PROPERTY));
        customer.setCity(wrapper.getString(CITY_PROPERTY));
        customer.setRegion(wrapper.getString(REGION_PROPERTY));
        customer.setCountry(wrapper.getString(COUNTRY_PROPERTY));
        customer.setImage(wrapper.getString(IMAGE_PROPERTY));
        customer.setDoB(getParsedDate(wrapper.getString(DOB_PROPERTY)));
        customer.setDiscount(wrapper.getDouble(DISCOUNT_PROPERTY));
        
        return customer;
    }
}
