/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.cacheable;

/**
 *
 * @author root
 */
public interface CacheStrategy {
     public Object getValue(final MethodInfo methodName);
     public void putValue(final MethodInfo key, final Object value);
    
}
