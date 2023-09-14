package org.tmurakam.jackson_playground;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity1 {
    private int fieldNormal;

    @JsonIgnore
    private int fieldIgnored;

    @JsonIgnore
    private int fieldIgnoreSetterOnly;

    private int fieldJsonSetter;

    public Entity1 init() {
        fieldNormal = 1;
        fieldIgnored = 2;
        fieldIgnoreSetterOnly = 3;
        fieldJsonSetter = 4;
        return this;
    }

    @JsonProperty
    public int getFieldIgnoreSetterOnly() {
        return fieldIgnoreSetterOnly;
    }

    @JsonSetter("setttter") // This will affect getter too.
    public void setFieldJsonSetter(int value) {
        fieldJsonSetter = value;
    }
}
