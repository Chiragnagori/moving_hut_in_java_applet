/* <applet code = "HutMove" width =900 height=900> </applet> */

import java.awt.*;
import java.applet.*;
  
public class HutMove extends Applet implements Runnable {
    
	int x, y,x1,y1,x2,y2,x3,x4,x5,y4, flag,i;
    Thread t;
  
    
    public void init()
    {
        x = 100;
        y = 100;
        x1=50;
        y1=200;
        x2=150;
        y2=400;
        x3=500;
        x4=80;
        y4=300;
        x5=120;
        flag = 1;
  
       
        t = new Thread(this, "MyThread");
        t.start();
    }
    public void update()
    {
  
        x = x + 10 * flag;
        x1 = x1 + 10 * flag;
        x2 = x2 + 10 * flag;
        x4 = x4 + 10 * flag;
        x5 = x5 + 10 * flag;
        x3 = x3 + 10 * flag;
        if (x > 300)
            flag = -1;
        if (x < 100)
            flag = 1;
    }
    public void run()
    {
  
        while (true) {
            repaint();
  
            update();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }
    public void paint(Graphics g)
    {
    	
        g.drawLine(x,y,x1,y1);
        g.drawLine(x,y,x2,y1);
        g.drawLine(x1,y1,x1,y2);
        g.drawLine(x1,y2,x2,y2);
        g.drawLine(x2,y2,x2,y1);
        g.drawLine(x1,y1,x2,y1);
        
        g.drawLine(x,y,x3,y);
        g.drawLine(x2,y1,x3,y1);
        g.drawLine(x2,y2,x3,y2);
        g.drawLine(x3,y,x3,y2);
        
        g.drawLine(x4, y4, x4, y2);
        g.drawLine(x5, y4, x5, y2);
        g.drawLine(x4, y4, x5, y4);
        
        
    }
}