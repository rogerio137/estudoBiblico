package br.com.estudos.entity;

import br.com.estudos.enuns.TipoEstudo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "estudo")
@Data
@NoArgsConstructor
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
