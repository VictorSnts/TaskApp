package com.victor.taskapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.taskapp.domain.Tarefa;
import com.victor.taskapp.repositories.TarefaRepository;
import com.victor.taskapp.service.util.Utils;

@Service
public class TarefaService {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private TarefaRepository tarefaRepository;

	public List<Tarefa> getAllTasks() {
		List<Tarefa> tarefas = tarefaRepository.findAll();
		if (tarefas.isEmpty())
			System.out.println("Sem Tarefas para mostrar");
		return tarefas;
	}

	public List<Tarefa> getTasksToday() throws ParseException {
		List<Tarefa> tarefas = tarefaRepository.findAllByDataPlanejada(Utils.getSystemDate());
		if (tarefas.isEmpty())
			System.out.println("Sem Tarefas para mostrar");
		return tarefas;
	}

	public List<Tarefa> getTasksTomorrow() throws ParseException {
		List<Tarefa> tarefas = tarefaRepository.findAllByDataPlanejada(Utils.getNextSystemDate());
		if (tarefas.isEmpty())
			System.out.println("Sem Tarefas para mostrar");
		return tarefas;
	}

	public List<Tarefa> getTasksFuture() throws ParseException {
		List<Tarefa> tarefas = tarefaRepository.findByFutureDates(Utils.getNextSystemDate());
		if (tarefas.isEmpty())
			System.out.println("Sem Tarefas para mostrar");
		return tarefas;
	}

	public List<Tarefa> getTasksPast() throws ParseException {
		List<Tarefa> tarefas = tarefaRepository.findByPastDates(Utils.getNextSystemDate());
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

	public Tarefa postTask(Tarefa tarefa) throws ParseException {
		tarefa.setId(null);
		tarefa.setDataInclusao(Utils.getSystemDate());
		tarefa = tarefaRepository.save(tarefa);
		return tarefa;
	}

	public Tarefa putTask(Tarefa tarefa) {
		tarefa = tarefaRepository.save(tarefa);
		return tarefa;
	}

	public void deleteTask(Integer id) {
		tarefaRepository.deleteById(id);
	}

}
