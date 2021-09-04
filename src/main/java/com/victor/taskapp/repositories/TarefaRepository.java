package com.victor.taskapp.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.victor.taskapp.domain.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    List<Tarefa> findAllByDataPlanejada(Date dataPalenjada);
    
    @Query("SELECT t FROM Tarefa AS t WHERE t.dataPlanejada > :proximaData")
    List<Tarefa> findByFutureDates(@Param("proximaData") Date data);
    
    @Query("SELECT t FROM Tarefa AS t WHERE t.dataPlanejada < :dataAtual")
    List<Tarefa> findByPastDates(@Param("dataAtual") Date data);

    

}

