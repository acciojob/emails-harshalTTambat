package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private ArrayList<Mail> Inbox; // list of inbox mails --> class Mail obj
    private ArrayList<Mail> Trash; // list of trash mails --> class Mail obj

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.Inbox = new ArrayList<>();
        this.Trash = new ArrayList<>();
    }
    public void setInboxCapacity(int inboxCapacity) {
        this.inboxCapacity = inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        Mail mail = new Mail(date, sender, message);
        if (this.Inbox.size() == this.inboxCapacity) //checking if inbox is full
        {
            this.Trash.add(this.Inbox.get(0)); // moving oldest mail from inbox to trash
            this.Inbox.remove(0);
            this.Inbox.add(mail);
        }
        else {
            this.Inbox.add(mail);
        }
    }
    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
       for(int i=0;i<this.Inbox.size();i++)
       {
           if(message.equals(Inbox.get(i).massageData))
           {
               this.Trash.add(Inbox.get(i));
               this.Inbox.remove(i);
           }
       }
    }
    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if (this.Inbox.size() == 0) return null;
        else {
            return this.Inbox.get(Inbox.size() - 1).massageData;
        }
    }
    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(this.Inbox.size() == 0) return null;
        else{
            return this.Inbox.get(0).massageData;
        }
    }
    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;
        for(int i=0;i<this.Inbox.size();i++)
        {
            if (this.Inbox.get(i).date.compareTo(start) >= 0 && this.Inbox.get(i).date.compareTo(end) <= 0)
            {
                count++;
            }
        }
        return count;
    }
    public int getInboxSize(){
        // Return number of mails in inbox
      return this.Inbox.size();
    }
    public int getTrashSize(){
        // Return number of mails in Trash
     return this.Trash.size();
    }
    public void emptyTrash(){
        // clear all mails in the trash
        if(this.Trash.size() == 0) return;
        for(int i=0;i<this.Trash.size();i++)
        {
            this.Trash.remove(i);
        }
    }
    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
}
