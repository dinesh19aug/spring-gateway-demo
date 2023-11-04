package com.javahabit.userservice.error;


public class DataNotFoundException extends Exception {
    public DataNotFoundException(String message){
        super(message);
    }
}
