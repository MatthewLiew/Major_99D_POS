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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;

/**
 *
 * @author Matthew
 */
public class JsonObjectWrapper {
    private final JsonObject object;
    private final JsonDeserializationContext context;
    
    public JsonObjectWrapper(JsonObject object, JsonDeserializationContext context) {
        this.object = object;
        this.context = context;
    }
    
    public JsonObjectWrapper(JsonElement element, JsonDeserializationContext context) {
        this(element.getAsJsonObject(), context);
    }
    
    public String getString(String name) {
        JsonElement element = object.get(name);
        return element.isJsonNull() ? null : element.getAsString();
    }
    
    public Boolean getBoolean(String name) {
        JsonElement element = object.get(name);
        return element.isJsonNull() ? null : element.getAsBoolean();
    }
    
    public Double getDouble(String name) {
        JsonElement element = object.get(name);
        return element.isJsonNull() ? null : element.getAsDouble();
    }
    
    public Integer getInteger(String name) {
        JsonElement element = object.get(name);
        return element.isJsonNull() ? null : element.getAsInt();
    }
    
    public <T extends Object> T getObject(String name, Type type) {
        JsonElement element = object.get(name);
        return context.deserialize(element, type);
    }
}
