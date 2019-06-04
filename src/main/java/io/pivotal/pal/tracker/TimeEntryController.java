package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public @ResponseBody ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry found = timeEntryRepository.find(id);
        if (found != null)
            return new ResponseEntity(found, HttpStatus.OK);
        else
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/time-entries")
    public @ResponseBody ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
        return new ResponseEntity(timeEntryRepository.update(id, timeEntry), HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity delete(@PathVariable long id) {
        if (timeEntryRepository.find(id) != null) {
            timeEntryRepository.delete(id);
            return new ResponseEntity("", HttpStatus.NO_CONTENT);
        }
        else
            return new ResponseEntity("", HttpStatus.NOT_FOUND);
    }
}
