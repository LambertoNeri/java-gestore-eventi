package org.lessons.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEvents {
    String title;
    List<Event> events;

    public ProgrammEvents(String title) {
        this.title = title;
        this.events = new ArrayList<>();
    }

    public void newEvent(List<Event> event){
        events.add((Event) event);
    }

    public List<Event> getEventsOnDate(LocalDate date) {
        List<Event> filteredEvents = new ArrayList<>();
        for (Event event:events) {
            if (event.getDate().equals(date)) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }
}
