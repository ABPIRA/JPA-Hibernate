package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
