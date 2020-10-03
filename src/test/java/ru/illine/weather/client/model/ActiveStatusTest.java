package ru.illine.weather.client.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.illine.weather.client.model.base.ActiveStatus;
import ru.illine.weather.client.test.tag.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UnitTest
@DisplayName("ActiveStatus Unit Test")
class ActiveStatusTest {

    //  -----------------------   successful tests   -------------------------

    @Test
    @DisplayName("activeOf(): returns 'ENABLED' when 'true'")
    void successfulActiveOfTrue() {
        assertEquals(ActiveStatus.ENABLED, ActiveStatus.activeOf(true));
    }

    @Test
    @DisplayName("activeOf(): returns 'DISABLED' when 'false'")
    void successfulActiveOfFalse() {
        assertEquals(ActiveStatus.DISABLED, ActiveStatus.activeOf(false));
    }

    @Test
    @DisplayName("toString(): returns a valid string when 'ENABLED'")
    void successfulToStringEnabled() {
        var expected = String.valueOf(true);
        assertEquals(expected, ActiveStatus.ENABLED.toString());
    }

    @Test
    @DisplayName("toString(): returns a valid string when 'DISABLED'")
    void successfulToStringDeleted() {
        var expected = String.valueOf(false);
        assertEquals(expected, ActiveStatus.DISABLED.toString());
    }
}