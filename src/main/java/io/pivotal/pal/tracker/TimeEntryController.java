package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<TimeEntry> read(long nonExistentTimeEntryId) {
        TimeEntry t = timeEntryRepository.find(nonExistentTimeEntryId);
        if (t != null)
            return new ResponseEntity(t, HttpStatus.OK);
        else {
            return new ResponseEntity(t, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/")
    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        TimeEntry t = timeEntryRepository.update(timeEntryId, expected);
        if (t != null)
            return new ResponseEntity(t, HttpStatus.OK);
        else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity delete(long timeEntryId) {
        if(timeEntryRepository.find(timeEntryId)!=null){

            return new ResponseEntity(HttpStatus.OK);
        }else{
            timeEntryRepository.delete(timeEntryId);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(timeEntryRepository.list(), HttpStatus.OK);
    }
}
