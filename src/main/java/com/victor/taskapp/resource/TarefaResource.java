package com.victor.taskapp.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victor.taskapp.domain.Tarefa;
import com.victor.taskapp.dto.TarefaDTO;
import com.victor.taskapp.service.TarefaService;

@RestController
@RequestMapping(value = "/tasks")
public class TarefaResource {

	@Autowired
	private TarefaService tarefaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Tarefa> tarefas = tarefaService.listar();
		List<TarefaDTO> tarefaDTO = tarefas.stream().map(obj -> new TarefaDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(tarefaDTO);
	}

}
