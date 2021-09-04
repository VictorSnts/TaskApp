package com.victor.taskapp.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getTasks() {
		List<Tarefa> tarefas = tarefaService.getAllTasks();
		List<TarefaDTO> tarefaDTO = tarefas.stream().map(obj -> new TarefaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(tarefaDTO);
	}

	/***
	 * Retorna uma tarefa especifica
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTask(@PathVariable Integer id) {
		Tarefa tarefa = tarefaService.getTask(id);
		TarefaDTO tarefaDTO = new TarefaDTO(tarefa);
		return ResponseEntity.ok().body(tarefaDTO);
	}

	/***
	 * Cadastra uma tareda no banco
	 * 
	 * @param tarefaDTO
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> putTask(@RequestBody TarefaDTO tarefaDTO) {
		Tarefa tarefa = new Tarefa(tarefaDTO);
		tarefa = tarefaService.postTask(tarefa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/***
	 * Atualiza uma tarefa existente
	 * 
	 * @param id
	 * @param tarefaDTO
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> putTask(@PathVariable Integer id, @RequestBody TarefaDTO tarefaDTO) {
		Tarefa tarefa = new Tarefa(tarefaDTO);
		tarefa.setId(id);
		tarefa = tarefaService.putTask(tarefa);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTask(@PathVariable Integer id) {
		tarefaService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}

}
