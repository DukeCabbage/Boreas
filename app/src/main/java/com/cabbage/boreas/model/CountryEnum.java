package com.cabbage.boreas.model;

import android.support.annotation.Nullable;

public enum CountryEnum {

    Canada("CA", "Canada"),
    USA("US", "USA"),
    France("FR", "France");

    private String code;
    private String name;

    CountryEnum(String code, String name) {
        this.name = name;
        this.code = code;
    }

    @Nullable
    public static CountryEnum codeToEnum(String code) {
        for (CountryEnum countryEnum : values()) {
            if (countryEnum.code.equalsIgnoreCase(code)) return countryEnum;
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name;
    }
}
