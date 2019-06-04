package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository {
    private HashMap<Long, TimeEntry> map = new HashMap<>(){
        {
            /*put(1L, new TimeEntry(1, 101, 1001, LocalDate.of(2019, Month.JUNE, 4),10));
            put(2L, new TimeEntry(2, 102, 1002, LocalDate.of(2019, Month.JUNE, 5),20));
            put(3L, new TimeEntry(3, 103, 1003, LocalDate.of(2019, Month.JUNE, 6),30));*/
        }
    };

    private long latestId = 0;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        latestId++;
        timeEntry.setId(latestId);
        map.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return map.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(map.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (find(id) != null) {
            timeEntry.setId(id);
            map.put(id, timeEntry);
            return timeEntry;
        }
        else
            return null;
    }

    @Override
    public void delete(long timeEntryId) {
        map.remove(timeEntryId);
    }

}
