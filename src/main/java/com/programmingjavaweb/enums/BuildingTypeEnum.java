package com.programmingjavaweb.enums;

public enum BuildingTypeEnum {
    NOI_THAT("Nội thất"),
    NGUYEN_CAN("Nguyên căn"),
    TANG_HAM("Tầng hầm");

    private String name;

    BuildingTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
