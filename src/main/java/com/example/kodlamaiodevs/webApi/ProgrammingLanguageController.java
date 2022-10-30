package com.example.kodlamaiodevs.webApi;
import com.example.kodlamaiodevs.business.abstracts.ProgrammingLanguageService;
import com.example.kodlamaiodevs.entity.ProgrammingLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
public class ProgrammingLanguageController {


    private final  ProgrammingLanguageService languageService;

//    @Autowired
//    public ProgrammingLanguageController(ProgrammingLanguageService languageService) {
//        this.languageService = languageService;
//    }

    @GetMapping("/all")
    public List<ProgrammingLanguage> getAllProgrammingLanguage() {
        return languageService.getAllProgrammingLanguage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> getLanguageById(@PathVariable int id) {
        return ResponseEntity.ok(languageService.getLanguageById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<ProgrammingLanguage> save(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(languageService.save(programmingLanguage));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        languageService.delete(id);
    }
    @PutMapping("/update/{id}")
    public void updateProgrammingLanguage(@PathVariable int id,@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        languageService.update(id, programmingLanguage);
    }
}
