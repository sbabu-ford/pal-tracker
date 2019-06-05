package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository {
    private HashMap<Long, TimeEntry> map = new HashMap<>();
    private long latestId = 0;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        latestId++;
        timeEntry.setId(latestId);
        map.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long timeEntryId) {
        return map.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(map.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (find(id) != null) {
            timeEntry.setId(id);
            map.put(id, timeEntry);
            return timeEntry;
        }
        else
            return null;
    }

    @Override
    public void delete(Long timeEntryId) {
        map.remove(timeEntryId);
    }

}
