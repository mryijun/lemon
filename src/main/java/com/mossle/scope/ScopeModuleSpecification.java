package com.mossle.scope;

import com.mossle.ext.dbmigrate.ModuleSpecification;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
public class ScopeModuleSpecification implements ModuleSpecification {
    private String type;
    private boolean enabled;
    private boolean initData;

    public boolean isEnabled() {
        return enabled;
    }

    public String getSchemaTable() {
        return "SCHEMA_VERSION_SCOPE";
    }

    public String getSchemaLocation() {
        return "dbmigrate." + type + ".scope";
    }

    public boolean isInitData() {
        return initData;
    }

    public String getDataTable() {
        return "SCHEMA_VERSION_DATA_SCOPE";
    }

    public String getDataLocation() {
        return "dbmigrate." + type + ".data_scope";
    }

    @Value("${application.database.type}")
    public void setType(String type) {
        this.type = type;
    }

    @Value("${scope.dbmigrate.enabled}")
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Value("${scope.dbmigrate.initData}")
    public void setInitData(boolean initData) {
        this.initData = initData;
    }
}
