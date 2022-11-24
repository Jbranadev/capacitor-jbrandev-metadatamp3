package com.jbrandev.capacitor.metadatamp3;

public class MetaData {
    private String name;
    private Object value;

    public MetaData(String name, Object value){
        this.setName(name);
        this.setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
