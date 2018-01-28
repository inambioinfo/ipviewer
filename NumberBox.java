
/**
 * A Swing viewer for a numerical value
 * 
 * @author Simon Andrews
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class NumberBox extends JPanel
{
    private String number = ".";

    public void setNumber (int number)
    {
        this.number = ""+number;
        repaint();
    }
    
    public void clearNumber () {
        number = "-";
        repaint();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        
        //Figure out the maximum size of number we can fit in
        
        int fontSize = 50;
        int sizeLimit = Math.min(getHeight(),getWidth()) - 6;

        
        while (true)
        {
            g.setFont(new Font("Monospace",Font.BOLD,fontSize));
            if (fontSize < 6) break;
            
            int thisMax = Math.max(g.getFontMetrics().stringWidth(number),g.getFontMetrics().getAscent());

            if (thisMax > sizeLimit) {
                fontSize--;
                continue;
            }
            
            break;
        }
                
        g.drawString(
            number,
            (getWidth()-g.getFontMetrics().stringWidth(number))/2,
            getHeight()-(getHeight()-g.getFontMetrics().getAscent())/2);
        
    }
}
