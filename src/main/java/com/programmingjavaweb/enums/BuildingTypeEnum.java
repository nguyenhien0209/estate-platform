package com.programmingjavaweb.enums;

public enum BuildingTypeEnum {
    NOI_THAT("Nội thất"),
    NGUYEN_CAN("Nguyên căn"),
    TANG_HAM("Tầng hầm");

    private String value;

    BuildingTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
