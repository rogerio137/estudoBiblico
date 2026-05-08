package br.com.estudos;

import br.com.estudos.interfaces.TelaInicial;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class EstudoBiblicoAplication
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {new TelaInicial().setVisible(true);});
    }
}
