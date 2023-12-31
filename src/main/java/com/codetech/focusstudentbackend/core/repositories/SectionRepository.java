package com.codetech.focusstudentbackend.core.repositories;

import com.codetech.focusstudentbackend.core.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    Boolean existsByName(String name);
}
