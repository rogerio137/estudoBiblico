package br.com.estudos.interfaces;

import javax.swing.*;

import javax.swing.table.JTableHeader;

import java.awt.*;

public class PainelGrid extends JPanel {

    private GridEsboco gridEsboco;
    private JTableHeader header;

    public PainelGrid(){
        this.setPreferredSize(new Dimension(50,50));
        this.setLayout(new GridLayout());
        this.setBackground(Color.CYAN);

        gridEsboco = new GridEsboco();

        header = this.gridEsboco.getTableHeader();
        header.setBackground(Color.CYAN);
        header.set

        JScrollPane scrollPane = new JScrollPane(gridEsboco);
        this.add(scrollPane);
    }
}
