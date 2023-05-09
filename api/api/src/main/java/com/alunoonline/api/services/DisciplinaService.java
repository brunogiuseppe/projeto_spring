package com.alunoonline.api.services;

import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public Disciplina create(Disciplina disciplina) {
        return repository.save(disciplina);
    }
    public Disciplina updateDisc(Long id, Disciplina disciplinaAtt){
        Disciplina disciplina = repository.findById(id).get();
        BeanUtils.copyProperties(disciplinaAtt, disciplina, "id");
        Disciplina discAtualizada = repository.save(disciplina);
        return discAtualizada;
    }
    public List<Disciplina> findAll() {
        return repository.findAll();
    }

    public Optional<Disciplina> findById(Long id){
        return repository.findById(id);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }
}
