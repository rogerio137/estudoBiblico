package br.com.estudos;

import br.com.estudos.interfaces.TelaInicial;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;

public class EstudoBiblicoAplication
{
    public static void main( String[] args )
    {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        SwingUtilities.invokeLater(() -> {new TelaInicial().setVisible(true);});
    }
}
