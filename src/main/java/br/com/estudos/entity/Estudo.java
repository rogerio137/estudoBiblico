package br.com.estudos.entity;

import br.com.estudos.enuns.TipoEstudo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "estudo")
@Table(name = "estudo")
@Data
public class Estudo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String tema;
    private String textoBase;


    @Column(columnDefinition = "TEXT")
    private String introducao;

    @Column(columnDefinition = "TEXT")
    private String desenvolvimento;

    @Column(columnDefinition = "TEXT")
    private String conclusao;

    @Enumerated(EnumType.STRING)
    private TipoEstudo tipoEstudo;

    public Estudo(String tema, String textoBase, String introducao, String desenvolvimento, String conclusao, TipoEstudo tipoEstudo){
        this.tema = tema;
        this.textoBase = textoBase;
        this.introducao = introducao;
        this.desenvolvimento = desenvolvimento;
        this.conclusao = conclusao;
        this.tipoEstudo = tipoEstudo;
    }


}
