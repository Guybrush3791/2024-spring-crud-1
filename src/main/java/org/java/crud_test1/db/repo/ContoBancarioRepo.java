package org.java.crud_test1.db.repo;

import org.java.crud_test1.db.pojo.ContoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContoBancarioRepo
        extends JpaRepository<ContoBancario, Integer> {
}
