package com.example.kodlamaiodevs.business.abstracts;

import com.example.kodlamaiodevs.entity.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    List<ProgrammingLanguage> getAllProgrammingLanguage() ;

    ProgrammingLanguage save(ProgrammingLanguage programmingLanguage) throws Exception;

    void delete(int id);

    void update(int id, ProgrammingLanguage programmingLanguage)throws Exception;

    ProgrammingLanguage getLanguageById(int id);
}
