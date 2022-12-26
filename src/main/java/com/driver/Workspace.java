package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar;  // Stores all the meetings
    int maxMeet;

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        // The inboxCapacity is equal to the maximum value an integer can store.
        this.calendar = new ArrayList<>();
    }

    public int getMaxMeet() {
        return maxMeet;
    }

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }
    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
       this.calendar.add(meeting);

    }
   // LocalTime curEndTime;
    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
/*
*  if(calendar.isEmpty()) return 0;

        Collections.sort(calendar, new Sortbyendtime());
        curEndTime = calendar.get(0).getEndTime();
        maxMeetings = 1;

        for(Meeting meeting : calendar){

            if(meeting.getStartTime().compareTo(curEndTime) > 0){
                maxMeetings+=1;
                curEndTime= meeting.getEndTime();
            }
        }
        return maxMeetings;*/

        for (int i=0;i<this.calendar.size();i++)
        {

        }

     return maxMeet;
    }
}
