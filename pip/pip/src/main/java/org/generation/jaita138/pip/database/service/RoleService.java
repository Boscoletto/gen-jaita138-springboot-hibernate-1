package org.generation.jaita138.pip.database.service;

import java.util.List;
import java.util.Optional;

import org.generation.jaita138.pip.database.entity.Role;
import org.generation.jaita138.pip.database.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role save(Role entity) {
        return roleRepo.save(entity);
    }

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public Optional<Role> findById(long id) {
        return roleRepo.findById(id);
    }

    public void delete(Role entity) {
        roleRepo.delete(entity);
    }
}
