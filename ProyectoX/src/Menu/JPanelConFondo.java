package Menu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class JPanelConFondo extends JPanel {

    private BufferedImage imagen;

    //Constructor 
    public JPanelConFondo(){
        super();
		try {
			imagen = ImageIO.read(getClass().getResource("/Menu/rain.gif"));
		} catch (IOException ex) { // handle exception... 
			}
    }

    public void paint(Graphics g) {
    	
    	super.paintComponent(g); 
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this); 
    	
        //setOpaque(false);
       
    }

    public void cambiarImagen(BufferedImage i){
        imagen=i;
    }
}