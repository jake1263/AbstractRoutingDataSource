package com.irish.constant;
public enum DataSourceType {
    SLAVE("slave", "从库"),
    MASTER("master", "主库");
 
    private String type;
    private String name;
 
    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}