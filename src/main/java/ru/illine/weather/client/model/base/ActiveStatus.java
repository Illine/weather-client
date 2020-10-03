package ru.illine.weather.client.model.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.EnumSet;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum ActiveStatus {

    ENABLED(true),
    DISABLED(false);

    private final boolean active;

    public static ActiveStatus activeOf(boolean active) {
        return EnumSet.allOf(ActiveStatus.class)
                .stream()
                .filter(it -> Objects.equals(it.active, active))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public String toString() {
        return String.valueOf(active);
    }
}