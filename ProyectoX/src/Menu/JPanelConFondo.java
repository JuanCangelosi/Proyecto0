package Menu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class JPanelConFondo extends JPanel {

    private BufferedImage imagen;

    //Constructor 
    public JPanelConFondo(BufferedImage i){
        super();
        imagen= i;
    }

    public void paint(Graphics g) {
    	
    	 
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this); 
        super.paint(g);
    	super.paintComponent(g);
        //setOpaque(false);
       
    }

    public void cambiarImagen(BufferedImage i){
        imagen=i;
    }
}