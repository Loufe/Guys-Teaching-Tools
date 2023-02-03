
/*
 *  Created as an JApplet.java on July 22, 2004, 8:48 AM, revised as an application March 1, 2018
 *  Author Guy Lemire, deep River,
 * 
 */

package PowerSupply;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;

/**
 *
 * @author  Guy Lemire  2005. Rev. 2018
 */
@SuppressWarnings("deprecation")
public class PowerSupply extends JFrame implements ActionListener {
    private Timer timer;

    private PowerSupply() {


        ViewPanel viewPanel = new ViewPanel();
        jOnOffButton = new JButton();
        JTextArea jTextArea1 = new JTextArea();
        viewPanel.setLayout(null);

        viewPanel.setBackground(new Color(252, 255, 234));
        viewPanel.setPreferredSize(new Dimension(600, 500));
        jOnOffButton.setText("Turn ON");
        jOnOffButton.setHorizontalTextPosition(SwingConstants.CENTER);
        jOnOffButton.setSelected(true);
        jOnOffButton.addActionListener(evt -> jOnOffButtonActionPerformed());

        jOnOffButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jOnOffButtonMousePressed();
            }
        });

        viewPanel.add(jOnOffButton);
        jOnOffButton.setBounds(5, 60, 100, 26);
        jTextArea1.setText("This basic supply will deliver up to 1.5 amperes at the\n rated output if properly heat sunk. You must use a\ntransformer rated at the proper voltage and current.");
        jTextArea1.setPreferredSize(new Dimension(130, 30));
        viewPanel.add(jTextArea1);
        jTextArea1.setBounds(140, 350, 340, 60);

        getContentPane().add(viewPanel, BorderLayout.CENTER);

        timerListener = actionEvent -> actionPerformed2();
    }//GEN-END:initComponents

    private void jOnOffButtonMousePressed() {/* GEN-FIRST:event_jOnOffButtonMousePressed */

    }//GEN-LAST:event_jOnOffButtonMousePressed

    private void jOnOffButtonActionPerformed() {//GEN-FIRST:event_jOnOffButtonActionPerformed
          if(jOnOffButton.getText().equals("Turn ON")){
          powerOn=true;
          jOnOffButton.setText("Turn OFF");
              startDraw();
          }
          else
          if(!jOnOffButton.getText().equals("Turn ON")) {
              powerOn=false;
          }
          startDraw();
    }//GEN-LAST:event_jOnOffButtonActionPerformed
     private boolean powerOn=false;
     private int j;

    private void actionPerformed2() {
        if (powerOn) {
            j++;
            if (j > 6) j = 1;
            //  if(powerOn==false)
            //  timer.stop();
        }
    }

    // Paint Panel
    public class ViewPanel extends JPanel{
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    int heightArc=20;
    int startAngle=90,pointX;
    g.setColor(Color.BLACK);
    g.setFont(new Font("Serif", BOLD,24));
    g.drawString("12 Volt POWER SUPPLY",180,24);
    g.setFont(new Font("Serif", BOLD,16));
    g.drawString("Transformer",52,220);
    g.drawString("Diode",235,70);
    g.drawString("Rectifier",225,90);
    g.drawString("Capacitors",290,240);
    g.drawString("Regulator", 393,135);
    g.drawString("-",520,224);
    
     // Draw transformer plates
    pointX=120;

        int i;
        for(i = 1; i<4; i++)
    { 
    pointX=pointX+5;
    g.drawLine(pointX,100,pointX,195);   
    }
    g.drawLine(212,146,212,223);
    // Draw diodes
    Graphics2D g2d = (Graphics2D)g;
    AffineTransform old = g2d.getTransform();
   GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
    if(powerOn){
    g.setColor(Color.RED);
    }
    else
    {
    g.setColor(Color.BLACK);
    } 
   path.moveTo(0.0f,0.0f);
   path.lineTo(66.4f,0.0f);
   path.lineTo(66.4f,66.4f);
   path.lineTo(0.0f,66.4f);
   path.closePath();
   g2d.translate(260,101);
   g2d.rotate(Math.PI/4);
   g2d.draw(path);
   g2d.setTransform(old);
   g.setColor(Color.BLACK);
   GeneralPath diode = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
   g2d.translate(260.0f,145.0f);
   diode.moveTo(0.0f,0.0f);
   diode.lineTo(16.0f,0.0f);
   diode.lineTo(8.0f,16.0f);
   diode.lineTo(16.0f,16.0f);
   diode.lineTo(0.0f,16.0f);
   diode.lineTo(8.0f,16.0f);
   diode.lineTo(0.0f,0.0f);
   diode.lineTo(0.0f,0.0f);
   g2d.translate(15.0f,-18.0f);
   g2d.rotate(-Math.PI/4);
   g2d.draw(diode);
   diode.closePath();
   g2d.fill(diode);
  
   g2d.translate(-26.0f,45.0f);
   g2d.rotate(-Math.PI/2);
   g2d.draw(diode);
   diode.closePath();
   g2d.fill(diode);
   
   g2d.setTransform(old);
   g2d.translate(225.0f,170.0f);
   g2d.rotate(-Math.PI/4);
   g2d.draw(diode);
   diode.closePath();
   g2d.fill(diode);

   g2d.setTransform(old);
   g2d.translate(235.0f,138.0f);
   g2d.rotate(-Math.PI*3/4);
   g2d.draw(diode);
   diode.closePath();
   g2d.fill(diode);
   g2d.setTransform(old);
   
   g.drawLine(325,190,325,223);// Capacitor C1
   g.drawLine(320,185,330,185);//
   g.drawArc(315,190,20,20,50,75);//
   g.drawString("C1",295,195);
   
   g.drawLine(370,185,380,185);// Capacitor C2
   g.drawArc(365,190,20,20,50,75);
   g.drawLine(375,190,375,223);
   g.drawString("C2",345,195);
   
   g.drawLine(475,190,475,235);// to ground
   g.drawLine(470,235,480,235);
   g.drawLine(473,238,477,238);
   g.drawLine(474,240,476,240);
   g.drawLine(470,185,480,185);// capacitor C3
   g.drawArc(465,190,20,20,50,75); 
   g.drawString("C3",445,195);
   g.drawString("Ground",450,255);
   
   Polygon polygon2 = new Polygon();// - arrow
   polygon2.addPoint(500,223);
   polygon2.addPoint(495,216);
   polygon2.addPoint(495,230);
   g2d.fillPolygon(polygon2);
   g.setFont(new Font("Serif", PLAIN,10));
   g.drawString("2000\u03BCF",284,210);
   g.drawString("2000\u03BCF",336,210);
   g.drawString("0.1\u03BCF",444,210);
   g.setFont(new Font("Serif", BOLD,16));

   g.drawLine(400,140,450,140);// 7812 
   g.drawLine(400,140,400,180);
   g.drawLine(450,140,450,180);
   g.drawLine(400,180,450,180);
   g.drawLine(425,180,425,223);
   
   g.drawLine(212,223,500,223);
   
    //Switch line & switch
    if(powerOn) {
        g.setColor(Color.RED);
    } else
    g.setColor(Color.BLACK); 
    g.drawString("+",520,150);
    g.drawLine(25,100,45,100);
    g.drawLine(60,100,110,100);
    g.drawLine(25,195,110,195);
    g.fillOval(43,97,4,4);
    g.fillOval(60,97,4,4);
    g.fillOval(258,99,4,4);
    g.fillOval(258,193,4,4);
    g.fillOval(211,145,4,4);
    g.fillOval(303,145,4,4);


    if(!powerOn){
    g.drawLine(43,93,65,93);//
   }
    else {
    g.drawLine(43,98,65,98);//
    }
      // Power info
    g.drawString("120V AC",20,155);
     // Draw 120V AC coils 
    pointX=100;
        int pointY = 100;
        int widthArc = 20;
        int extentAngle = -180;
        for(i=1; i<7; i++)
    {
    g.drawArc(pointX,pointY,widthArc,heightArc,startAngle,extentAngle);  
    pointY=pointY+15; 
    }
    // 
    pointX=108;
    pointY=100;
    for(i=1;i<6;i++){
    pointY=pointY+15;
    g.drawArc(pointX,pointY,4,4,90,180);
    }
   g.drawLine(450,147,500,147);
    
    // Draw 12V AC coil
    pointX=140;
    pointY=120;
    for(i=1;i<4;i++)
    {
    g.drawArc(pointX,pointY,widthArc,heightArc,90,180);  
    pointY=pointY+15;    
    }
    pointX =148;
    pointY=135;
    for(i=1;i<3;i++){
    g.drawArc(pointX,pointY,4,4,90,-180); 
    pointY=pointY+15;
    }
    
    // 12V power line
    g.drawLine(150,120,190,120);
    g.drawLine(150,170,190,170);
    g.drawLine(190,120,190,100);
    g.drawLine(190,100,260,100);
    g.drawLine(190,170,190,195);
    g.drawLine(190,195,260,195);
    g.setFont(new Font("Serif", BOLD,13));
    g.drawString("13.2VAC",153,155);
    
   
   g.drawLine(304,147,400,147);
   g.drawString("7812",404,170);
   
   g.drawLine(475,147,475,185);// C3
  
   
   g.drawLine(325,147,325,185);// capacitor C1

   g.drawLine(375,147,375,185);// capacitor C2
 
   Polygon polygon1 = new Polygon();// + arrow
   polygon1.addPoint(500,147);
   polygon1.addPoint(495,140);
   polygon1.addPoint(495,154);
   g2d.fillPolygon(polygon1);

   
   if (powerOn){
   	g.setColor(Color.red);
        g.drawString("12V DC",490,355);
        g.drawString("12 V DC",490,190);
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.draw(new Line2D.Float(450.0f,320.0f,500.0f,320.0f));
        g.fillOval(496,316,8,8);
	int step=0;	
        int x;
		// Use this to remember the last position so we 
		// can draw a line back to it. We have to give it
		// an initial value or the compiler will complain.
		int oldy = 0;
		// 120V Sine wave
		for (x =5; (x < 110); x += 4) {
			double degrees =j* x + step;
			// Convert degrees to radians
			double radians = degrees * .0174532925;
			int y = (int) (Math.sin(radians) * 90) + 320;
			// Draw a red line from this value to the previous one,
			// if any
			if (x > 10) {
				g.drawLine(x - 4, oldy, x, y);
			}
			// Remember this position for the next line
			oldy = y;
            step=step+36;
		if (step == 360) {
			step = 0;
		}  
		}
                // 13.2V Sine wave
               for (x =0; (x < 90); x += 4) {
			double degrees =j* x + step;
			// Convert degrees to radians
			double radians = degrees * .0174532925;
			int y = (int) (Math.sin(radians) *10) + 320;
			// Draw a red line from this value to the previous one,
			// if any
			if (x > 10) g.drawLine(x + 130 - 4, oldy, x + 130, y);
			// Remember this position for the next line
			oldy = y;
           	step=step+72;
		if (step == 360) {
			step = 0;
		}  
		}
                // Rectified 12V
              oldy=320;
                for (x =0; (x < 90); x += 4) {
			double degrees =j/3* x + step;
			// Convert degrees to radians
			double radians = degrees * .0174532925;
			int y = 320-(int) (Math.sin(radians) * 4) ;
            if (y>320) y=320;
			// Draw a red line from this value to the previous one,
			// if any
            g.drawLine(x+275 - 4, oldy, x+275,y);
			// Remember this position for the next line
			oldy = y;
                      	step=step+36;
		if (step == 180) {
    			step = 0;
                        oldy=290;
		}  
		}
	g.setColor(Color.BLACK);
              // Line at 290 Sine wave
    g.drawLine(10,320,450,320);
              g.fillOval(496,370,8,8);
   g2d.draw(new Line2D.Float(500.0f,370.0f,500.0f,430.0f));
   g2d.draw(new Line2D.Float(495.0f,430.0f,505.0f,430.0f));
   g2d.draw(new Line2D.Float(498.0f,435.0f,502.0f,435.0f));
   g2d.draw(new Line2D.Float(499.0f,440.0f,501.0f,440.0f));
   g.drawString("Ground",475,455);
   //g.drawString("J = "+j,30,480);
   }
    repaint();
    }
   //update(Graphics g);
    }
    private void startDraw(){
              if("Turn ON".equals(jOnOffButton.getText())){
        jOnOffButton.setText("Turn OFF");
        powerOn=true;
        start();
           }
    else 
        if("Turn OFF".equals(jOnOffButton.getText())){
        jOnOffButton.setText("Turn ON");
        powerOn=false;
        start();
           }
    }

   // Responds to Timer's event
   private ActionListener timerListener;


     @Override
     public void actionPerformed(ActionEvent actionEvent) {
         if(timer == null) {
             start();
         } else
             stop();
     }
     // Timer
     private void start(){
         if(timer == null){
             timer= new Timer(100,timerListener);
             timer.start();
         }
         else
             timer.restart();
     }
     private void stop(){
         if(timer!=null){
             timer = null;
         }
     }

    public static void main(String[] args) {

        JFrame frame;

        // frame.pack(); // set window to appropriate size (for its elements)
        frame = new PowerSupply();
        frame.setSize ( 700,600 );
        frame.setLocationRelativeTo(null); // set window to appropriate size (for its elements)
        frame.setVisible(true);   // usual step to make frame visible
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton jOnOffButton;
    // End of variables declaration//GEN-END:variables
    
}
