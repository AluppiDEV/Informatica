package com.example.javafx_4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Model class following MVC pattern.
 * Manages the event data including timestamps and statistics.
 */
public class EventModel {
    private final List<LocalDateTime> events;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public EventModel() {
        this.events = new ArrayList<>();
    }

    /**
     * Adds a new event with the current timestamp
     */
    public void addEvent() {
        events.add(LocalDateTime.now());
    }

    /**
     * Returns the total number of events
     */
    public Object getTotalEvents() {
        return events.size();
    }

    /**
     * Returns the timestamp of the first event, or null if no events
     */
    public LocalDateTime getFirstEvent() {
        return events.isEmpty() ? null : events.get(0);
    }

    /**
     * Returns the timestamp of the last event, or null if no events
     */
    public LocalDateTime getLastEvent() {
        return events.isEmpty() ? null : events.get(events.size() - 1);
    }

    /**
     * Returns a formatted string of the last event
     */
    public String getLastEventFormatted() {
        LocalDateTime last = getLastEvent();
        return last != null ? last.format(FORMATTER) : "";
    }

    /**
     * Returns a formatted string of the first event
     */
    public String getFirstEventFormatted() {
        LocalDateTime first = getFirstEvent();
        return first != null ? first.format(FORMATTER) : "";
    }

    /**
     * Returns all events as formatted strings
     */
    public List<String> getFormattedEvents() {
        List<String> formatted = new ArrayList<>();
        for (LocalDateTime event : events) {
            formatted.add(event.format(FORMATTER));
        }
        return formatted;
    }

    /**
     * Clears all events
     */
    public void clearEvents() {
        events.clear();
    }

    /**
     * Checks if the image should be visible (10 or more events)
     */
    public boolean shouldShowImage() {
        return events.size() >= 10;
    }
}
