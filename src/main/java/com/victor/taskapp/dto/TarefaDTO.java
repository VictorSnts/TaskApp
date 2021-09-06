package com.victor.taskapp.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.victor.taskapp.domain.Tarefa;

@Service
public class TarefaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private Date dataInclusao;
	private LocalDate dataPlanejada;
	private String notas;
	private String usuario;

	public TarefaDTO(Integer id, String titulo, Date dataInclusao, LocalDate dataPlanejada, String notas, String usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataInclusao = dataInclusao;
		this.dataPlanejada = dataPlanejada;
		this.notas = notas;
		this.usuario = usuario;
	}

	public TarefaDTO() {
		super();
	}

	public TarefaDTO(Tarefa tarefa) {
		super();
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.dataInclusao = tarefa.getDataInclusao();
		this.dataPlanejada = tarefa.getDataPlanejada();
		this.notas = tarefa.getNotas();
		this.usuario = tarefa.getUsuario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDate getDataPlanejada() {
		return dataPlanejada;
	}

	public void setDataPlanejada(LocalDate dataPlanejada) {
		this.dataPlanejada = dataPlanejada;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
