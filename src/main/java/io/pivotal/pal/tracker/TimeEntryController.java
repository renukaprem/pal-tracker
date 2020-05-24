package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Component
@RequestMapping("/time-entries")
public class TimeEntryController {

//    @Autowired
    private TimeEntryRepository timeEntryRepository;
    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        TimeEntry t =null;
       if(id!=null) t= timeEntryRepository.find(id);
        if (t != null)
            return new ResponseEntity(t, HttpStatus.OK);
        else {
            return new ResponseEntity(t, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody  TimeEntry expected) {
        TimeEntry t = timeEntryRepository.update(id, expected);
        if (t != null)
            return new ResponseEntity(t, HttpStatus.OK);
        else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
            timeEntryRepository.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(timeEntryRepository.list(), HttpStatus.OK);
    }
}
