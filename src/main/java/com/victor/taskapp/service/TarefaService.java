package com.victor.taskapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.taskapp.domain.Tarefa;
import com.victor.taskapp.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public List<Tarefa> listar() {
		List<Tarefa> tarefas = tarefaRepository.findAll();
		if (tarefas.isEmpty())
			System.out.println("Sem Tarefas para mostrar");;
		return tarefas;
	}
	

}
