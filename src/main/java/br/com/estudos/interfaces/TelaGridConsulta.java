package br.com.estudos.interfaces;

import br.com.estudos.entity.Estudo;
import br.com.estudos.enuns.CamposFiltro;
import br.com.estudos.modelos.ModeloGridEstudo;
import br.com.estudos.service.EstudoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TelaGridConsulta extends JFrame {
    private JPanel painelCampoTexto, painelBotao;
    private JComboBox<CamposFiltro> comboBoxFiltro;
    private JTextField textoConsulta;
    private PainelGrid painelGrid;
    private List<Estudo> estudos;
    private ModeloGridEstudo modeloGridEstudo;
    private EstudoService estudoService;
    private JButton botaoFechar;

    public TelaGridConsulta(){
        this.setLayout(new BorderLayout());
        this.setSize(700,300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        painelCampoTexto = new JPanel();
        painelCampoTexto.setLayout(new FlowLayout());

        comboBoxFiltro = new JComboBox<>(CamposFiltro.values());
        painelCampoTexto.add(comboBoxFiltro);

        textoConsulta = new JTextField(60);
        painelCampoTexto.add(textoConsulta);

        painelGrid = new PainelGrid();
        estudos = new ArrayList<>();
        modeloGridEstudo = new ModeloGridEstudo(estudos);
        painelGrid.getGridEsboco().setModel(modeloGridEstudo);

        estudoService = new EstudoService();

        painelBotao = new JPanel();
        painelBotao.setLayout(new FlowLayout());
        botaoFechar = new JButton("Fechar");
        painelBotao.add(botaoFechar);


        textoConsulta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                estudos = estudoService.estudos(textoConsulta.getText());
                modeloGridEstudo.getRowCountClean();
                for(Estudo estudo : estudos){
                    modeloGridEstudo.adicionarEstudo(estudo);
                }
            }
        });

        botaoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        painelGrid.getGridEsboco().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2 && !e.isConsumed()) {
                    e.consume();
                    int linha = painelGrid.getGridEsboco().getSelectedRow();
                    if(linha != -1){
                        Object valor = painelGrid.getGridEsboco().getValueAt(linha, 0);
                        JOptionPane.showMessageDialog(null,"Você clicou duas vezes na linha "+" (valor: " + valor + ")");
                    }

                }
            }
        });


        this.add(painelCampoTexto, BorderLayout.NORTH);
        this.add(painelGrid, BorderLayout.CENTER);
        this.add(painelBotao,BorderLayout.SOUTH);
    }

}
