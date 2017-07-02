package com.yu.entity;

import java.util.Date;

public class Message {
    private Integer msgId;

    private Integer msgFrom;

    private Integer msgReceiver;

    private String msgContent;

    private Date msgSendtime;

    private Date msgReadtime;

    private String msgFont;

    private Integer msgFontSize;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(Integer msgFrom) {
        this.msgFrom = msgFrom;
    }

    public Integer getMsgReceiver() {
        return msgReceiver;
    }

    public void setMsgReceiver(Integer msgReceiver) {
        this.msgReceiver = msgReceiver;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Date getMsgSendtime() {
        return msgSendtime;
    }

    public void setMsgSendtime(Date msgSendtime) {
        this.msgSendtime = msgSendtime;
    }

    public Date getMsgReadtime() {
        return msgReadtime;
    }

    public void setMsgReadtime(Date msgReadtime) {
        this.msgReadtime = msgReadtime;
    }

    public String getMsgFont() {
        return msgFont;
    }

    public void setMsgFont(String msgFont) {
        this.msgFont = msgFont == null ? null : msgFont.trim();
    }

    public Integer getMsgFontSize() {
        return msgFontSize;
    }

    public void setMsgFontSize(Integer msgFontSize) {
        this.msgFontSize = msgFontSize;
    }
}