/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrs.cacheable.exceptions;

/**
 * Thrown when method could not be cached by some reasons.
 * @author root
 */
public class NonCacheableMethodException extends NonCacheableException{
    
    private final String message;
    
    public NonCacheableMethodException(String message) {
        this.message =  message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
    
}
