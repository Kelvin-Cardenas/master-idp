package org.example.prueba.church.repository;

import org.example.prueba.church.entity.Church;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ChurchRepository extends JpaRepository<Church, Long> {


}
