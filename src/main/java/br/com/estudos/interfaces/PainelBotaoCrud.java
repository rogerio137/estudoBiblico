package br.com.estudos.interfaces;


import br.com.estudos.util.EstudosUtil;

import javax.swing.*;
import java.awt.*;

public class PainelBotaoCrud extends JPanel {
    public JButton botaoIncluir, botaoExcluir, botaoAlterar, botaoCancelar, botaoPesquisar;

    public PainelBotaoCrud(){
        this.setLayout(new GridLayout(1,5));
        this.setPreferredSize(new Dimension(50,50));

        this.botaoIncluir = new JButton("Gravar", EstudosUtil.imageIcon("/img/add.png"));
        this.add(this.botaoIncluir);

        this.botaoAlterar = new JButton("Alterar", EstudosUtil.imageIcon("/img/data-processing.png"));
        this.add(this.botaoAlterar);

        this.botaoExcluir = new JButton("Excluir", EstudosUtil.imageIcon("/img/delete.png"));
        this.add(this.botaoExcluir);

        this.botaoCancelar = new JButton("Cancelar", EstudosUtil.imageIcon("/img/cancel.png"));
        this.add(this.botaoCancelar);

        this.botaoPesquisar = new JButton("Pesquisar", EstudosUtil.imageIcon("/img/magnifier.png"));
        this.add(this.botaoPesquisar);
    }

}
