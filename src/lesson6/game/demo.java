package lesson6.game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Demo extends JPanel implements MouseMotionListener
{
    protected JButton cmd;

    Demo()
    {
        JFrame frm =new JFrame();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(1000, 1000);
        frm.add(this);

        this.add(cmd=new JButton("Жмякни меня !!!"));
        cmd.setFocusPainted(false);
        cmd.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent arg0) {
                cmd.setText("Ты победил!");
                cmd.setBackground(new Color(200,255,200));
              }

        });
        frm.getContentPane().addMouseMotionListener(this);
        frm.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Demo();
            }
        });
    }

    public void mouseDragged(MouseEvent e) {
        if(e.getModifiers()==16)this.MoveGetdirection(e.getX(), e.getY());

    }
    public void mouseMoved(MouseEvent e)
    {
        this.MoveGetdirection(e.getX(), e.getY());
    }

    int Rad;
    protected void MoveGetdirection(int x_position,int y_position)
    {
        Rad=(int)(this.cmd.getWidth()*1.2);
        int x_centerbutton=this.cmd.getLocation().x+(this.cmd.getWidth()/2);
        int y_centerbutton=this.cmd.getLocation().y+(this.cmd.getHeight()/2);
        int rast=(int) (2*Math.sqrt(Math.pow(x_position-x_centerbutton, 2)+Math.pow(y_position-y_centerbutton, 2)));
        if (rast < Rad)
        {
            int dx = Rad - rast;
            int dy = Rad - rast;

            if(x_position>x_centerbutton){dx=-dx;}
            if(y_position>y_centerbutton){dy=-dy;}
            this.MoveDCmd(dx, dy, x_centerbutton, y_centerbutton);
        }
    }

    int bonus = 5;
    protected void MoveDCmd(int dx, int dy, int x_centerbutton, int y_centerbutton)
    {

        if (dx > 0) {
            if (x_centerbutton + this.cmd.getWidth() / 2 + dx < this.getWidth()) {
                this.cmd.setLocation(this.cmd.getLocation().x += dx, this.cmd.getLocation().y);
            }else{
                this.cmd.setLocation(bonus, this.cmd.getLocation().y);
            }
        }

        if (dy > 0) {
            if (y_centerbutton + this.cmd.getHeight() / 2 + dy < this.getHeight()) {
                this.cmd.setLocation(this.cmd.getLocation().x, this.cmd.getLocation().y += dy);
            }else{
                this.cmd.setLocation(this.cmd.getLocation().x,bonus);
            }
        }

        if (dx < 0) {
            if (x_centerbutton - this.cmd.getWidth() / 2 > -dx) {
                this.cmd.setLocation(this.cmd.getLocation().x += dx, this.cmd.getLocation().y);
            }else{
                this.cmd.setLocation(this.getWidth()-(this.cmd.getWidth()+bonus),this.cmd.getLocation().y );
            }
        }

        if (dy < 0) {
            if (y_centerbutton - (this.cmd.getHeight() / 2) > -dy) {
                this.cmd.setLocation(this.cmd.getLocation().x, this.cmd.getLocation().y += dy);
            }else{
                this.cmd.setLocation(this.cmd.getLocation().x,this.getHeight()-(this.cmd.getHeight()+bonus));
            }
        }
    }
}