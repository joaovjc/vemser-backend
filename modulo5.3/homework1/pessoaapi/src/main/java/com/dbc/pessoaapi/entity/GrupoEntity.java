package com.dbc.pessoaapi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "GRUPO")
public class GrupoEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6178910101254347628L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupo")
    @SequenceGenerator(name = "seq_grupo", sequenceName = "seq_grupo", allocationSize = 1)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    private String nome;

    private String descricao;

    @ManyToMany(mappedBy = "grupos")
    private List<UsuarioEntity> usuarios;

    @ManyToMany
    @JoinTable(
            name = "GRUPO_REGRA",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_regra")
    )
    private List<RegraEntity> regras;

}
