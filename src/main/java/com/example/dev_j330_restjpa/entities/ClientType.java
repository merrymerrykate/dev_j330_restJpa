package com.example.dev_j330_restjpa.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ClientType {



    INDIVIDUAL("Физическое лицо"),

    LEGAL("Юридическое лицо");


    private final String type;

    ClientType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }


    @JsonCreator
    //public static ClientType getClientType(String type){
    public static ClientType getType(String type){
        if(type == null) return null;
        for(ClientType typ : ClientType.values()){
            if(typ.getType().equals(type))
                return typ;
        }
        return null;
    }
}

//    @JsonCreator
//    public static ClientType fromString(String type) {
//        for (ClientType clientType : ClientType.values()) {
//            if (clientType.type.equalsIgnoreCase(type)) {
//                return clientType;
//            }
//        }
//        throw new IllegalArgumentException("No enum constant " + ClientType.class.getCanonicalName() + "." + type);
//    }
//}
