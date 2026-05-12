package br.com.estudos.modelos;


import br.com.estudos.entity.Estudo;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class ModeloGridEstudo extends AbstractTableModel {

    private final List<Estudo> estudos;
    private final String[] colunas = {"Tema", "Texto Base"};

    public ModeloGridEstudo(List<Estudo> estudos) {
        this.estudos = estudos;
    }

    @Override
    public int getRowCount() {
        return (estudos == null) ? 0 : estudos.size();
    }

    public void getRowCountClean(){
        estudos.clear();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Estudo e = estudos.get(rowIndex);
        switch (columnIndex) {
            case 0: return e.getTema();
            case 1: return e.getTextoBase();
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void adicionarEstudo(Estudo e) {
        int posicao = estudos == null ? 1 : estudos.size();
        estudos.add(e);
        fireTableRowsInserted(posicao, posicao); // notifica apenas a nova linha
    }
    public Estudo getEstudoAt(int rowIndex) {
        return estudos.get(rowIndex);
    }




}
