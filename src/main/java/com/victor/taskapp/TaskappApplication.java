package com.victor.taskapp;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.victor.taskapp.domain.Tarefa;
import com.victor.taskapp.repositories.TarefaRepository;

@SpringBootApplication
public class TaskappApplication implements CommandLineRunner {
	
	@Autowired
	private TarefaRepository tarefaRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaskappApplication.class, args);
	}
	
		@Override
		public void run(String... args) throws Exception {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			Tarefa t1 = new Tarefa(null, "Tarefa1", sdf.parse("30/09/2017 10:32"), null, "Loren ipsum.", "usuario@email.com");
			
			tarefaRepository.saveAll(Arrays.asList(t1));

		}

}
