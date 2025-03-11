package com.xrp.aipicturebackend.common;

import lombok.Data;

import java.io.Serializable;
@Data
public class DeleteRequest implements Serializable {
    /**
     * id
     */
    private long id;
    private static final long serialVersionUID = 1L;
}
