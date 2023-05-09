package com.alunoonline.api.services;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public Aluno create(Aluno aluno) {
        repository.save(aluno);
        return aluno;
    }
    public Aluno updateAluno(Long id,Aluno alunoAtt){
        Aluno aluno = repository.findById(id).get();
        BeanUtils.copyProperties(alunoAtt, aluno, "id");
        Aluno alunoAtualizado = repository.save(aluno);
        return alunoAtualizado;
    }
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id){
        return repository.findById(id);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }
}
