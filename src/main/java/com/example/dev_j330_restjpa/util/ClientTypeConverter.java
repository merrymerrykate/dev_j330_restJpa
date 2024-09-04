package com.example.dev_j330_restjpa.util;

import com.example.dev_j330_restjpa.entities.ClientType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ClientTypeConverter implements AttributeConverter<ClientType, String> {

    @Override
    public String convertToDatabaseColumn(ClientType clientType) {
        if (clientType == null) {
            return null;
        }
        return clientType.getType();
    }

    @Override
    public ClientType convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return ClientType.getType(dbData);
    }
}

