package com.example.kodlamaiodevs.dataAccess.concretes;

import com.example.kodlamaiodevs.dataAccess.abstracts.ProgrammingLanguageRepository;
import com.example.kodlamaiodevs.entity.ProgrammingLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryProgrammingLanguage implements ProgrammingLanguageRepository {
    List<ProgrammingLanguage> programmingLanguagesList;

    public InMemoryProgrammingLanguage() {
        programmingLanguagesList = new ArrayList<>();
        programmingLanguagesList.add(new ProgrammingLanguage(1, "Java"));
        programmingLanguagesList.add(new ProgrammingLanguage(2, "C#"));
        programmingLanguagesList.add(new ProgrammingLanguage(3, "Payton"));
        programmingLanguagesList.add(new ProgrammingLanguage(4, "C++"));
    }


    @Override
    public List<ProgrammingLanguage> getAllProgrammingLanguage() {
        return programmingLanguagesList;
    }

    @Override
    public ProgrammingLanguage save(ProgrammingLanguage programmingLanguage) {
        programmingLanguagesList.add(programmingLanguage);
        return getLanguageById(programmingLanguage.getId());
    }

    @Override
    public void delete(int id) {
        programmingLanguagesList.remove(id);
    }

    @Override
    public void update(int id, ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguage language = getLanguageById(id);
        language.setName(programmingLanguage.getName());
    }

    @Override
    public ProgrammingLanguage getLanguageById(int id) {
        return programmingLanguagesList.stream()
                .filter(programmingLanguage -> programmingLanguage.getId() == id)
                .findFirst().get();
    }
}
