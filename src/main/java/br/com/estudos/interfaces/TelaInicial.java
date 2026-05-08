package br.com.estudos.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    private JButton esboco;
    private JButton estudo;
    private static Integer LARGURA_BOTAO = 120;
    private static Integer ALTURA_BOTAO = 100;
    private static Integer TAMANHO_FONT = 15;
    private PainelEsboco painelEsboco;



    public TelaInicial() throws HeadlessException {
        this.setTitle("Sistema de estudos para ensinos biblicos");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024,768);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new BorderLayout());


        JPanel painelSelecionar = new JPanel();
        painelSelecionar.setLayout(new GridLayout(1,2));

        this.esboco = new JButton("Esboço");
        this.esboco.setBorderPainted(false);
        this.esboco.setPreferredSize(new Dimension(LARGURA_BOTAO,ALTURA_BOTAO));
        this.esboco.setFont(new Font("Arial",Font.BOLD,TAMANHO_FONT));
        painelSelecionar.add(esboco);

        this.estudo= new JButton("Estudo");
        this.estudo.setBorderPainted(false);
        this.estudo.setPreferredSize(new Dimension(LARGURA_BOTAO,ALTURA_BOTAO));
        this.estudo.setFont(new Font("Arial",Font.BOLD,TAMANHO_FONT));
        painelSelecionar.add(estudo);

        this.add(painelSelecionar, BorderLayout.NORTH);

        this.painelEsboco = new PainelEsboco();
        this.painelEsboco.setVisible(false);
        this.add(painelEsboco, BorderLayout.CENTER);


        this.esboco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelEsboco.setVisible(true);
            }
        });

        this.estudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelEsboco.setVisible(false);
            }
        });

    }
}
