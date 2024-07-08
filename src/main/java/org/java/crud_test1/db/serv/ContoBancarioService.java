package org.java.crud_test1.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.crud_test1.db.pojo.ContoBancario;
import org.java.crud_test1.db.repo.ContoBancarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContoBancarioService {

    @Autowired
    private ContoBancarioRepo contoBancarioRepo;

    public List<ContoBancario> getAll() {

        return contoBancarioRepo.findAll();
    }

    public Optional<ContoBancario> getById(int id) {

        return contoBancarioRepo.findById(id);
    }

    public void save(ContoBancario contoBancario) {

        contoBancarioRepo.save(contoBancario);
    }

    public void delete(ContoBancario contoBancario) {

        contoBancarioRepo.delete(contoBancario);
    }
}
