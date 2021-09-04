package com.victor.taskapp.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.victor.spring.modeloconceitual.domain.Categoria;
import com.victor.spring.modeloconceitual.dto.CategoriaDTO;
import com.victor.taskapp.domain.Tarefa;
import com.victor.taskapp.dto.TarefaDTO;
import com.victor.taskapp.service.TarefaService;

@RestController
@RequestMapping(value = "/tasks")
public class TarefaResource {

	@Autowired
	private TarefaService tarefaService;
	
	/***
	 * Retorna todas as tarefas cadastradas
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getTasks() {
		List<Tarefa> tarefas = tarefaService.getAllTasks();
		List<TarefaDTO> tarefaDTO = tarefas.stream().map(obj -> new TarefaDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(tarefaDTO);
	}
	/***
	 * Retorna uma tarefa especifica
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTask(@PathVariable Integer id){
		Tarefa tarefa = tarefaService.getTask(id);
		TarefaDTO tarefaDTO = new TarefaDTO(tarefa);
		return ResponseEntity.ok().body(tarefaDTO);
	}
	
	
	
	
	

}
