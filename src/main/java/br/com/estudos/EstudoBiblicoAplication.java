package br.com.estudos;

import br.com.estudos.interfaces.TelaInicial;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;

public class EstudoBiblicoAplication
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        SwingUtilities.invokeLater(() -> {new TelaInicial().setVisible(true);});
    }
}
