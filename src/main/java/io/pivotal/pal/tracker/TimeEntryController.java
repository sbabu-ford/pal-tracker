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
            return ResponseEntity.ok(found);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/time-entries")
    public @ResponseBody ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok(timeEntryRepository.list());
    }

    @PutMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry entry = timeEntryRepository.update(id, timeEntry);
        if (entry != null)
            return ResponseEntity.ok(entry);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/time-entries/{id}")
    public @ResponseBody ResponseEntity delete(@PathVariable long id) {
        timeEntryRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
