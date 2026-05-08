package br.com.estudos.interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GridEsboco extends JTable {

    public GridEsboco(){
       super();
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][] {
                        {1, "Caneta", 2.50},
                        {2, "Caderno", 15.00},
                        {3, "Borracha", 1.20}
                },
                new String[] {"ID", "Nome", "Preço"}
        );

        setModel(modelo);

        // Configurações visuais
        setRowHeight(25);
        setGridColor(Color.LIGHT_GRAY);
        setSelectionBackground(Color.YELLOW);
        setSelectionForeground(Color.BLACK);
        setAutoCreateRowSorter(true);
    }
}
