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

	public List<Tarefa> getAllTasks() {
		List<Tarefa> tarefas = tarefaRepository.findAll();
		if (tarefas.isEmpty())
			System.out.println("Sem Tarefas para mostrar");
		return tarefas;
	}

	public Tarefa getTask(Integer id) {
		Tarefa tarefa = tarefaRepository.findById(id).get();
		if (tarefa.equals(null))
			System.out.println("Sem Tarefas para mostrar");
		return tarefa;
	}
	
	public Tarefa postTask(Tarefa tarefa) {
		tarefa.setId(null);
		tarefa = tarefaRepository.save(tarefa);
		return tarefa;
	}
	
	public Tarefa putTask(Tarefa tarefa) {
		tarefa = tarefaRepository.save(tarefa);
		return tarefa;
	}
	

}
