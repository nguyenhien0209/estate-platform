package com.programmingjavaweb.builder;

public class BuildingBuilder {
    private String name;
    private String street;
    private Integer numberOfBasement;
    private String[] buildingTypes = new String[]{};

    public BuildingBuilder(Builder builder) {
        this.name = builder.name;
        this.street = builder.street;
        this.numberOfBasement = builder.numberOfBasement;
        this.buildingTypes = builder.buildingTypes;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public static class Builder {
        private String name;
        private String street;
        private Integer numberOfBasement;
        private String[] buildingTypes = new String[]{};

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setBuildingTypes(String[] buildingTypes) {
            this.buildingTypes = buildingTypes;
            return this;
        }

        public BuildingBuilder build() {
            return new BuildingBuilder(this);
        }
    }

}
