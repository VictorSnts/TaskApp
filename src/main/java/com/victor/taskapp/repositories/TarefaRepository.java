package com.victor.taskapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victor.taskapp.domain.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}

