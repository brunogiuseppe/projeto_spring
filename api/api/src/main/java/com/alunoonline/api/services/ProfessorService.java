package com.alunoonline.api.services;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.DisciplinaRepository;
import com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public Professor create(Professor professor) {
        return repository.save(professor);

    }
    public Professor updateProf(Long id, Professor professorAtt){
        Professor professor = repository.findById(id).get();
        BeanUtils.copyProperties(professorAtt, professor, "id");
        Professor profAtualizado = repository.save(professor);
        return profAtualizado;
    }
    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Optional<Professor> findById(Long id){
        return repository.findById(id);
    }

    public void delete (Long id){
        repository.deleteById(id);
    }
}
