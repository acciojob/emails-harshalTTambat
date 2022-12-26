package com.driver;

import java.util.Date;

public class Mail {
    public Date date;
    public String senderId;
    public String massageData;

    public Mail(Date date, String senderId, String massageData) {
        this.date = date;
        this.senderId = senderId;
        this.massageData = massageData;
    }
}
