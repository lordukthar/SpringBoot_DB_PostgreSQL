package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Service
public class PlaygroundService {

    @Autowired
    PlaygroundRepository playgroundRepository;

   // @PersistenceContext
   // private EntityManager entityManager;


    public String hello() {
        return "Hello World";
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = {SQLException.class})
    public List<Playground> getAll() {
        List<Playground> all = playgroundRepository.findAll();
        return all;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = {Exception.class})
    public Playground getPlayground(long id) throws Exception {
        return playgroundRepository.findById(id).orElseThrow(Exception::new);
    }

    @Transactional(readOnly = false)
    public Long add(Playground playground) {
        try {
            return playgroundRepository.save(playground).getEquip_id();

        } catch (Exception ex) {
            System.out.println("EXEC" + ex.getMessage());
            return 1L;
        }
    }



}
