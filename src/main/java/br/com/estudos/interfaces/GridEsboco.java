package br.com.estudos.interfaces;

import br.com.estudos.entity.Estudo;
import br.com.estudos.modelos.ModeloGridEstudo;

import javax.swing.*;
import java.util.List;

public class GridEsboco extends JTable {
    private ModeloGridEstudo modeloGridEstudo;
    private List<Estudo> estudos;

    public GridEsboco(){
       super();
    }

}
