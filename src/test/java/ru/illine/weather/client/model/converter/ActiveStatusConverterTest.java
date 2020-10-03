package ru.illine.weather.client.model.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.illine.weather.client.model.base.ActiveStatus;
import ru.illine.weather.client.model.base.converter.ActiveStatusConverter;
import ru.illine.weather.client.test.tag.UnitTest;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UnitTest
@DisplayName("ActiveStatusConverter Unit Test")
class ActiveStatusConverterTest {

    private ActiveStatusConverter testActiveStatusConverter;

    @BeforeEach
    void setup() {
        testActiveStatusConverter = new ActiveStatusConverter();
    }

    //  -----------------------   successful tests   -------------------------

    @Test
    @DisplayName("convertToDatabaseColumn(): returns all valid values")
    void successfulConvertToDatabaseColumn() {
        var expected = Set.of(Boolean.TRUE, Boolean.FALSE);
        var actual = EnumSet.allOf(ActiveStatus.class)
                .stream()
                .map(testActiveStatusConverter::convertToDatabaseColumn)
                .collect(Collectors.toSet());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("convertToEntityAttribute(): returns all valid values")
    void successfulConvertToEntityAttribute() {
        var expected = Set.of(ActiveStatus.ENABLED, ActiveStatus.DISABLED);
        var actual = Set.of(Boolean.TRUE, Boolean.FALSE)
                .stream()
                .map(testActiveStatusConverter::convertToEntityAttribute)
                .collect(Collectors.toSet());
        assertEquals(expected, actual);
    }
}