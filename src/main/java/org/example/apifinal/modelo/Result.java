package org.example.apifinal.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

public abstract class Result {

    @Data
    @AllArgsConstructor
    public static class Sucess<T>{
        private T data;
    }
    @Data
    @AllArgsConstructor
    public static class Error{
        private String msg;
    }

}
