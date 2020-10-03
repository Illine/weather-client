package ru.illine.weather.client.model.base.converter;


import ru.illine.weather.client.model.base.ActiveStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ActiveStatusConverter implements AttributeConverter<ActiveStatus, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(ActiveStatus type) {
        return type.isActive();
    }

    @Override
    public ActiveStatus convertToEntityAttribute(Boolean active) {
        return ActiveStatus.activeOf(active);
    }
}