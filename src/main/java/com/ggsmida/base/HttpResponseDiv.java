package com.ggsmida.base;

import java.io.Serializable;

/**
 * Created by junwuguo on 2017/1/10 0010.
 */
public class HttpResponseDiv<T> implements Serializable {

    private T resultObject;
    private int resultCode;
    private String resultMsg = "";

    /**
     * !!note!!
     * the construct function must be non-public to make sure that
     * this should be created by ResultState
     * Example:ResultState.OK.wrap(resultObject, resultMsg)
     * @param resultObject
     * @param resultStat
     * @param resultMsg
     */
    HttpResponseDiv(T resultObject, ResultState resultStat, String resultMsg) {
        this.resultObject = resultObject;
        this.resultCode = resultStat.resultCode;
        this.resultMsg = resultMsg;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public T getResultObject() {
        return resultObject;
    }

    public void setResultObject(T resultObject) {
        this.resultObject = resultObject;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
