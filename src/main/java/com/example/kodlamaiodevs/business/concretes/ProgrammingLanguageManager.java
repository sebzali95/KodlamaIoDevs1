package com.example.kodlamaiodevs.business.concretes;


import com.example.kodlamaiodevs.business.abstracts.ProgrammingLanguageService;
import com.example.kodlamaiodevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.example.kodlamaiodevs.entity.ProgrammingLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final   ProgrammingLanguageRepository languageRepository;

//    @Autowired
//    public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
//        this.languageRepository = languageRepository;
//    }

    @Override
    public List<ProgrammingLanguage> getAllProgrammingLanguage() {
        return languageRepository.getAllProgrammingLanguage();
    }

    @Override
    public ProgrammingLanguage save(ProgrammingLanguage programmingLanguage) throws Exception {
        if (isNameExist(programmingLanguage)) throw new Exception("Program name cannot be repeated");
        return languageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void update(int id, ProgrammingLanguage programmingLanguage) throws Exception {
        if (isNameExist(programmingLanguage)) throw new Exception("Program name cannot be repeated");
        languageRepository.update(id, programmingLanguage);
    }

    @Override
    public ProgrammingLanguage getLanguageById(int id) {
        return languageRepository.getLanguageById(id);
    }

    public boolean isNameExist(ProgrammingLanguage programmingLanguage) {
        for (ProgrammingLanguage language : getAllProgrammingLanguage()) {
            if (programmingLanguage.getName().equals(language.getName())) {
                return true;
            }
        }
        return false;
    }
}
