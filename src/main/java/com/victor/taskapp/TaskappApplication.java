package com.victor.taskapp;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.victor.taskapp.domain.Tarefa;
import com.victor.taskapp.repositories.TarefaRepository;
import com.victor.taskapp.service.util.Utils;

@SpringBootApplication
public class TaskappApplication implements CommandLineRunner {

	@Autowired
	private TarefaRepository tarefaRepository;

	public static void main(String[] args) {
		SpringApplication.run(TaskappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		

		Tarefa t1 = new Tarefa(null, "Tarefa1", sdf.parse("30/09/2017"), Utils.toLocalDate("30/09/2017"), "Loren ipsum.",
				"usuario@email.com");
		Tarefa t2 = new Tarefa(null, "Tarefa2", sdf.parse("30/09/2017"),  Utils.toLocalDate("09/09/2021"), "Loren ipsum.",
				"usuario@email.com");
		Tarefa t3 = new Tarefa(null, "Tarefa3", sdf.parse("30/09/2017"),  Utils.toLocalDate("04/09/2021"), "Loren ipsum.",
				"usuario@email.com");
		Tarefa t4 = new Tarefa(null, "Tarefa4", sdf.parse("04/09/2021"),  Utils.toLocalDate("05/09/2021"), "Loren ipsum.",
				"usuario@email.com");

		tarefaRepository.saveAll(Arrays.asList(t1, t2, t3, t4));

	}

}
