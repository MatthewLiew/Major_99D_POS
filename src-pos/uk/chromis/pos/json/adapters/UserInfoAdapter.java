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
import uk.chromis.pos.ticket.UserInfo;

/**
 *
 * @author Matthew
 */
public class UserInfoAdapter extends BaseAdapter<UserInfo>{
    
    private static final String ID_PROPERTY = "Id";
    private static final String NAME_PROPERTY = "Name";
    
    @Override
    public JsonElement serialize(UserInfo user, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        
        object.addProperty(ID_PROPERTY, user.getId());
        object.addProperty(NAME_PROPERTY, user.getName());
        
        return object;
    }

    @Override
    public UserInfo deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObjectWrapper wrapper = new JsonObjectWrapper(element, context);
        
        UserInfo user = new UserInfo(
                wrapper.getString(ID_PROPERTY),
                wrapper.getString(NAME_PROPERTY));
        
        return user;
    }
}
