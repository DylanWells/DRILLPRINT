import javax.swing.JButton;
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class MyButton extends JButton implements MouseListener {
    private ImageIcon neutral;
    private ImageIcon hover;
    private ImageIcon press;

    public MyButton(ImageIcon[] state) {
        setPreferredSize(new Dimension(state[0].getIconWidth(),state[0].getIconHeight()));
        addMouseListener(this);
        setVisible(true);
        neutral = new ImageIcon(state[0].getImage());
        hover = new ImageIcon(state[1].getImage());
        press = new ImageIcon(state[2].getImage());
    }
    
    private boolean isHover;
    private boolean isPress;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(isPress)
            press.paintIcon(this,g,0,0);
        else if(isHover)
            hover.paintIcon(this,g,0,0);
        else
            neutral.paintIcon(this,g,0,0);
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        isPress = false;
        repaint();
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
        isHover = true;
        repaint();
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
        isHover = false;
        isPress = false;
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
        isHover = false;
        isPress = true;
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) 
    {
        isPress = false;
        isHover = true;
        repaint();
    }
}