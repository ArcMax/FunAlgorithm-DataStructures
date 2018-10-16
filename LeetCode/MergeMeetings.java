package LeetCode;

import java.util.*;

class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Meeting)) {
            return false;
        }
        final Meeting meeting = (Meeting) o;
        return startTime == meeting.startTime && endTime == meeting.endTime;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + startTime;
        result = result * 31 + endTime;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }
}

public class MergeMeetings {
    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        //make a copy so we don't destroy the input
        List<Meeting> sortedMeetings = new ArrayList<>();

        for(Meeting meeting : meetings){
//            Meeting meetingCopy = new Meeting(meeting.getStartTime(),meeting.getEndTime());
            sortedMeetings.add(meeting);
        }

        // sort by starttime
        Collections.sort(sortedMeetings, new Comparator<Meeting>(){

            @Override
            public int compare(Meeting m1, Meeting m2){
                return m1.getStartTime() - m2.getStartTime();
            }
        });

        // initialize mergedMeetings with earliest meeting
        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(sortedMeetings.get(0));

        for(Meeting currentMeeting :  sortedMeetings){
            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size()-1);

            if(currentMeeting.getStartTime()  <= lastMergedMeeting.getEndTime()){
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(),currentMeeting.getEndTime()));
            }else{
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }

    public static void main(String args[]){
        final List<Meeting> meetings = Arrays.asList(new Meeting(1, 3), new Meeting(2, 4));
        final List<Meeting> actual = mergeRanges(meetings);
        final List<Meeting> expected = Arrays.asList(new Meeting(1, 4));

        System.out.println(actual);
        System.out.println(expected);
    }
}
