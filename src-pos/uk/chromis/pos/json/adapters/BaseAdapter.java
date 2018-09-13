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

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Matthew
 */
public abstract class BaseAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {
   
    private static final DateFormat COMMON_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    protected String getFormattedDate(Date date) {
        return COMMON_DATE_FORMAT.format(date);
    }
    
    protected Date getParsedDate(String date){
        try {
            return COMMON_DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
