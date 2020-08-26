package com.littlebuddha.community.notice.replyenum;

public enum StatusEnum {
    UNREAD(0),
    READ(1);

    private int status;

    public int getStatus() {
        return status;
    }

    StatusEnum(int status) {
        this.status = status;
    }
}
