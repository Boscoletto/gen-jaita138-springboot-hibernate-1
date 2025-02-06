package org.generation.jaita138.pip.database.service;

import java.util.List;
import java.util.Optional;

import org.generation.jaita138.pip.database.entity.SubReddit;
import org.generation.jaita138.pip.database.repo.SubRedditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubRedditService {
    @Autowired
    private SubRedditRepo subRedditRepo;

    public void delete(SubReddit entity) {
        subRedditRepo.delete(entity);
    }

    public List<SubReddit> findAll() {
        return subRedditRepo.findAll();
    }

    public Optional<SubReddit> findById(Long id) {
        return subRedditRepo.findById(id);
    }

    public <S extends SubReddit> S save(S entity) {
        return subRedditRepo.save(entity);
    }
    

    

}
