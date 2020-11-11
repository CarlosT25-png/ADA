package utilities;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ScaleImage {
    public static void setScaleImage(JLabel label, String ruta){
        ImageIcon img = new ImageIcon(ruta);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }
    
    public static void setScaleImage(JLabel label, ImageIcon img){
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }
}
