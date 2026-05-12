package br.com.estudos.interfaces;



import br.com.estudos.entity.Estudo;
import br.com.estudos.enuns.TipoEstudo;
import br.com.estudos.service.EstudoService;
import lombok.Data;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class PainelEsboco extends JPanel {
    private JLabel lblTema, lblTextoBase, lblIntroducao, lblDesenvolvimento, lblConclusao;
    private JTextField txtTema, txtTextoBase;
    private JTextArea txtIntroducao, txtDesenvolvimento, txtConclusao;
    private JPanel painelDeCanpos;
    private PainelBotaoCrud painelBotaoCrud;
    private Estudo estudo;
    private EstudoService estudoService;
    private GridEsboco gridEsboco;
    private PainelGrid painelGrid;



    public PainelEsboco() {
        this.setLayout(new FlowLayout());
        this.setSize(1024,768);
        //this.setBackground(Color.pink);


        painelDeCanpos = new JPanel();
        painelDeCanpos.setPreferredSize(new Dimension(1120, 1200));
        painelDeCanpos.setLayout(null);

        this.lblTema = new JLabel("Tema");
        this.lblTema.setBounds(10,10,200,30);
        painelDeCanpos.add(this.lblTema);

        this.txtTema = new JTextField(20);
        this.txtTema.setBounds(10, 40, 500, 30);
        painelDeCanpos.add(this.txtTema);

        this.lblTextoBase = new JLabel("Texto Base");
        this.lblTextoBase.setBounds(600,10,200,30);
        painelDeCanpos.add(this.lblTextoBase);

        this.txtTextoBase = new JTextField(20);
        this.txtTextoBase.setBounds(600,40,500,30);
        painelDeCanpos.add(this.txtTextoBase);

        this.lblIntroducao = new JLabel("Introdução");
        this.lblIntroducao.setBounds(10,80,200,30);
        painelDeCanpos.add(this.lblIntroducao);

        this.txtIntroducao = new JTextArea(5,30);
        this.txtIntroducao.setBounds(10,110,1100,200);
        this.txtIntroducao.setLineWrap(true);
        painelDeCanpos.add(this.txtIntroducao);

        this.lblDesenvolvimento = new JLabel("Desenvolvimento");
        this.lblDesenvolvimento.setBounds(10,310,200,30);
        painelDeCanpos.add(this.lblDesenvolvimento);

        this.txtDesenvolvimento = new JTextArea(5,30);
        this.txtDesenvolvimento.setBounds(10,340,1100,200);
        this.txtDesenvolvimento.setLineWrap(true);
        painelDeCanpos.add(this.txtDesenvolvimento);

        this.lblConclusao = new JLabel("Conclusão");
        this.lblConclusao.setBounds(10,540,200,30);
        painelDeCanpos.add(this.lblConclusao);

        this.txtConclusao = new JTextArea(5,30);
        this.txtConclusao.setBounds(10,570,1100,200);
        this.txtConclusao.setLineWrap(true);
        painelDeCanpos.add(this.txtConclusao);

        painelBotaoCrud = new PainelBotaoCrud();
        painelBotaoCrud.setBounds(10,800,510,30);
        painelBotaoCrud.botaoAlterar.setEnabled(false);
        painelBotaoCrud.botaoExcluir.setEnabled(false);
        painelDeCanpos.add(painelBotaoCrud);


        painelBotaoCrud.botaoIncluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estudo = new Estudo(getTxtTema().getText(), getTxtTextoBase().getText(),getTxtIntroducao().getText(), getTxtDesenvolvimento().getText(), getTxtConclusao().getText(), TipoEstudo.ESBOCO);
                estudoService = new EstudoService();
                estudoService.salvar(estudo);
                limparCampos();

            }
        });

        painelBotaoCrud.botaoPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaGridConsulta telaGridConsulta = new TelaGridConsulta();
                telaGridConsulta.setVisible(true);
            }
        });

        this.add(painelDeCanpos);



    }

    private void limparCampos(){
        this.getTxtTema().setText("");
        this.getTxtTextoBase().setText("");
        this.getTxtIntroducao().setText("");
        this.getTxtDesenvolvimento().setText("");
        this.getTxtConclusao().setText("");
    }


}