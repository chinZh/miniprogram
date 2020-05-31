package com.chin.miniprogram.common;

import lombok.Data;

/**
 * @author chinZh
 * @date 2020/5/30 20:38
 */
@Data
public class JsonData<T> {
    private int returnCode;
    private String returnMessage;
    private T data;
}
