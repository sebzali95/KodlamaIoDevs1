package com.example.kodlamaiodevs.dataAccess.abstracts;

import com.example.kodlamaiodevs.entity.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {

    List<ProgrammingLanguage> getAllProgrammingLanguage();

    ProgrammingLanguage save(ProgrammingLanguage programmingLanguage);

    void delete(int id);

    void update(int id, ProgrammingLanguage programmingLanguage);

    ProgrammingLanguage getLanguageById(int id);

}
