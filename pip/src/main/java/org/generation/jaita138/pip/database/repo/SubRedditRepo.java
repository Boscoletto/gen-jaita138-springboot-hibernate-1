package org.generation.jaita138.pip.database.repo;

import org.generation.jaita138.pip.database.entity.SubReddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRedditRepo extends JpaRepository<SubReddit,Long> {

}
