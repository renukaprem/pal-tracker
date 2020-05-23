package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Long id = 0l;

    Map<Long, TimeEntry> data = new HashMap<Long, TimeEntry>();

    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++id);
        data.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long timeEntryId) {
        return data.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
//        data.remove(id);
        if (data.containsKey(id)) {
            timeEntry.setId(id);
            data.put(id, timeEntry);
            return data.get(id);
        }
        return null;
    }

    public List list() {
        List l = new ArrayList();
        for (Long i : data.keySet()) {
            l.add(data.get(i));

        }
        return l;
    }


    @Override
    public void delete(long timeEntryId) {
        data.remove(timeEntryId);
    }
}
