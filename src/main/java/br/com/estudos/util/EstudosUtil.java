package br.com.estudos.util;

import br.com.estudos.interfaces.PainelBotaoCrud;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class EstudosUtil {

    public static ImageIcon imageIcon(String url){
        URL urlIcone = PainelBotaoCrud.class.getResource(url);
        ImageIcon icon = new ImageIcon(urlIcone);
        Image img = icon.getImage();
        Image imgRedimensionada = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionada = new ImageIcon(imgRedimensionada);
        return iconRedimensionada;

    }
}
