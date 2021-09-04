package com.victor.taskapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.victor.taskapp.dto.TarefaDTO;

@Entity
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Date dataInclusao;
	private Date dataAlteracao;
	private String notas;
	private String usuario;

	public Tarefa(Integer id, String titulo, Date dataInclusao, Date dataAlteracao, String notas, String usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.notas = notas;
		this.usuario = usuario;
	}
	
	public Tarefa(TarefaDTO tarefaDTO) {
		super();
		this.id = tarefaDTO.getId();
		this.titulo = tarefaDTO.getTitulo();
		this.dataInclusao = tarefaDTO.getDataInclusao();
		this.dataAlteracao = tarefaDTO.getDataAlteracao();
		this.notas = tarefaDTO.getNotas();
		this.usuario = tarefaDTO.getUsuario();
	}

	public Tarefa() {

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

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}

}
