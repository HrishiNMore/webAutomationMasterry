package com.hrishi.webautomation.data.clientdata;

import com.hrishi.webautomation.data.mappers.DataMapper;
import com.hrishi.webautomation.data.mappers.JSONDataMapper;

import java.util.Objects;

public class Dataclient {
    protected DataMapper dataMapper;
    public Dataclient() {
        this.dataMapper=new JSONDataMapper();
    }

    protected String getFilePath(String relativePath) {
        return Objects.requireNonNull(this.getClass()
                        .getClassLoader()
                        .getResource(String.format("data_sets/%s",relativePath)))
                .getPath();
    }
}
