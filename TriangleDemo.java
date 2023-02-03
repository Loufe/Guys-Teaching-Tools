/*
 * TriangleDemo.java
 *
 * Created on June 18, 2004, 10:01 AM
 */

package TriangleDemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
/**
 *
 * @author  Guy Lemire
 */
public class TriangleDemo extends JFrame {

    /** Creates new form TriangleDemo */
    public TriangleDemo() {




    //private void initComponents() {//GEN-BEGIN:initComponents
        infoPanel = new JPanel();
        aLabel = new JLabel();
        bLabel = new JLabel();
        bValueLabel = new JLabel();
        cValueLabel = new JLabel();
        radianLabel = new JLabel();
        angleLabel = new JLabel();
        aValueLabel = new JLabel();
        aRadLabel = new JLabel();
        bRadLabel = new JLabel();
        cRadLabel = new JLabel();
        aRadValue = new JLabel();
        bRadValue = new JLabel();
        cRadValue = new JLabel();
        jSides = new JLabel();
        jSideALabel = new JLabel();
        jLabel1 = new JLabel();
        jSideBLabel = new JLabel();
        jSideCLabel = new JLabel();
        jSideAValue = new JLabel();
        jSideBValue = new JLabel();
        jSideCValue = new JLabel();
        jhLabel = new JLabel();
        jhValue = new JLabel();
        cLabel = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        viewPanel = new JPanel();

        ViewPanel viewPanel = new ViewPanel ();
        viewPanel.setSize ( 800,800 );
        infoPanel.setLayout(null);

        infoPanel.setBorder(new javax.swing.border.TitledBorder("Triangle Values"));
        infoPanel.setPreferredSize(new Dimension(140, 500));
        aLabel.setText("a=");
        aLabel.setBorder(new javax.swing.border.LineBorder(new Color(255, 153, 51)));
        aLabel.setFocusable(false);
        aLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoPanel.add(aLabel);
        aLabel.setBounds(20, 80, 30, 18);

        bLabel.setText("b=");
        bLabel.setBorder(new javax.swing.border.LineBorder(new Color(153, 153, 153)));
        bLabel.setFocusable(false);
        bLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoPanel.add(bLabel);
        bLabel.setBounds(20, 100, 30, 18);

        bValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bValueLabel.setText("000");
        bValueLabel.setBorder(new javax.swing.border.LineBorder(new Color(153, 153, 153)));
        bValueLabel.setFocusable(false);
        bValueLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoPanel.add(bValueLabel);
        bValueLabel.setBounds(50, 100, 30, 18);

        cValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cValueLabel.setText("000");
        cValueLabel.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0)));
        cValueLabel.setFocusable(false);
        cValueLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoPanel.add(cValueLabel);
        cValueLabel.setBounds(50, 120, 30, 18);

        radianLabel.setText("Radian");
        radianLabel.setFocusable(false);
        radianLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoPanel.add(radianLabel);
        radianLabel.setBounds(20, 160, 80, 16);

        angleLabel.setText("ANGLES");
        angleLabel.setFocusable(false);
        infoPanel.add(angleLabel);
        angleLabel.setBounds(20, 30, 60, 20);

        aValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        aValueLabel.setText("000");
        aValueLabel.setBorder(new javax.swing.border.LineBorder(new Color(255, 153, 0)));
        aValueLabel.setFocusable(false);
        aValueLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoPanel.add(aValueLabel);
        aValueLabel.setBounds(50, 80, 40, 18);

        aRadLabel.setText("a=");
        aRadLabel.setBorder(new javax.swing.border.LineBorder(new Color(255, 153, 0)));
        infoPanel.add(aRadLabel);
        aRadLabel.setBounds(20, 190, 30, 18);

        bRadLabel.setText("b=");
        bRadLabel.setBorder(new javax.swing.border.LineBorder(new Color(153, 153, 153)));
        infoPanel.add(bRadLabel);
        bRadLabel.setBounds(20, 210, 30, 18);

        cRadLabel.setText("c=");
        cRadLabel.setBorder(new javax.swing.border.LineBorder(new Color(51, 255, 0)));
        infoPanel.add(cRadLabel);
        cRadLabel.setBounds(20, 230, 30, 18);

        aRadValue.setHorizontalAlignment(SwingConstants.CENTER);
        aRadValue.setText("00000");
        aRadValue.setBorder(new javax.swing.border.LineBorder(new Color(255, 153, 0)));
        infoPanel.add(aRadValue);
        aRadValue.setBounds(40, 190, 60, 18);

        bRadValue.setHorizontalAlignment(SwingConstants.CENTER);
        bRadValue.setText("00000");
        bRadValue.setBorder(new javax.swing.border.LineBorder(new Color(153, 153, 153)));
        infoPanel.add(bRadValue);
        bRadValue.setBounds(40, 210, 60, 18);

        cRadValue.setHorizontalAlignment(SwingConstants.CENTER);
        cRadValue.setText("00000");
        cRadValue.setBorder(new javax.swing.border.LineBorder(new Color(51, 255, 0)));
        infoPanel.add(cRadValue);
        cRadValue.setBounds(40, 230, 60, 18);

        jSides.setText("SIDES");
        infoPanel.add(jSides);
        jSides.setBounds(20, 290, 41, 16);

        jSideALabel.setText("A=");
        infoPanel.add(jSideALabel);
        jSideALabel.setBounds(20, 320, 20, 16);

        jLabel1.setText("Degrees");
        infoPanel.add(jLabel1);
        jLabel1.setBounds(20, 60, 70, 16);

        jSideBLabel.setText("B=");
        infoPanel.add(jSideBLabel);
        jSideBLabel.setBounds(20, 340, 20, 16);

        jSideCLabel.setText("C=");
        infoPanel.add(jSideCLabel);
        jSideCLabel.setBounds(20, 360, 30, 16);

        jSideAValue.setText("000");
        infoPanel.add(jSideAValue);
        jSideAValue.setBounds(40, 320, 30, 16);

        jSideBValue.setText("000");
        infoPanel.add(jSideBValue);
        jSideBValue.setBounds(40, 340, 30, 16);

        jSideCValue.setText("000");
        infoPanel.add(jSideCValue);
        jSideCValue.setBounds(40, 360, 30, 16);

        jhLabel.setText("h=");
        infoPanel.add(jhLabel);
        jhLabel.setBounds(20, 400, 20, 16);

        jhValue.setText("000");
        infoPanel.add(jhValue);
        jhValue.setBounds(40, 400, 30, 16);

        cLabel.setText("c=");
        cLabel.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0)));
        cLabel.setFocusable(false);
        cLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoPanel.add(cLabel);
        cLabel.setBounds(20, 120, 30, 18);

        jLabel2.setText("AREA");
        infoPanel.add(jLabel2);
        jLabel2.setBounds(20, 430, 41, 16);

        jLabel3.setText("B x h /2=");
        infoPanel.add(jLabel3);
        jLabel3.setBounds(10, 450, 60, 16);

        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("0000");
        infoPanel.add(jLabel4);
        jLabel4.setBounds(30, 450, 100, 16);

        getContentPane().add(infoPanel, BorderLayout.WEST);

        viewPanel.setPreferredSize(new Dimension(500, 500));

        viewPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                viewPanelMousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                viewPanelMouseReleased(evt);
            }
            public void mouseClicked(MouseEvent evt) {
                viewPanelMouseClicked(evt);
            }
            public void mouseExited(MouseEvent evt) {
                viewPanelMouseExited(evt);
            }
            public void mouseEntered(MouseEvent evt) {
                viewPanelMouseEntered();
            }
        });

        viewPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                viewPanelMouseMoved(evt);
            }
            public void mouseDragged(MouseEvent evt) {
                viewPanelMouseDragged(evt);
            }
        });

        getContentPane().add(viewPanel, BorderLayout.CENTER);

    }//GEN-END:initComponents

    private void viewPanelMouseEntered() {//GEN-FIRST:event_viewPanelMouseEntered
        // Add your handling code here:
    }//GEN-LAST:event_viewPanelMouseEntered

    private void viewPanelMouseExited(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseExited
        // Add your handling code here:
    }//GEN-LAST:event_viewPanelMouseExited

    private void viewPanelMouseClicked(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseClicked
        // Add your handling code here:
    }//GEN-LAST:event_viewPanelMouseClicked

    private void viewPanelMouseReleased(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseReleased
        isDraggingDot1 = false;
        isDraggingDot2 = false;
        isDraggingDot3 = false;
        repaint();

    }//GEN-LAST:event_viewPanelMouseReleased

    private void viewPanelMousePressed(MouseEvent evt) {//GEN-FIRST:event_viewPanelMousePressed
        // Is Mouse pressed on dot1 or dot2 or dot3?
        new_X = evt.getX();
        new_Y = evt.getY();
        if (x1-8 < new_X && new_X < x1+8 && y-8 <new_Y && new_Y <y+8){
        // X dot
        isDraggingDot1 = true;
       }
        else
        // x2 dot
       if (x2-8 < new_X && new_X < x2+8 && y-8 <new_Y && new_Y <y+8){
           isDraggingDot2 = true;
        }
       else
           // y3 dot
     if ((y3+8) > new_Y && (y3-8)<new_Y && x3-8 <new_X && new_X <x3+8)
       isDraggingDot3 = true;
        evt.consume();

    }//GEN-LAST:event_viewPanelMousePressed

    private void viewPanelMouseDragged(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseDragged
       new_X=evt.getX();
       new_Y=evt.getY();
       repaint();
    }//GEN-LAST:event_viewPanelMouseDragged

    private void viewPanelMouseMoved(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseMoved
        // Add your handling code here:
    }//GEN-LAST:event_viewPanelMouseMoved
         // Paint panel
    // Initialize variables

   int width, height,new_X,new_Y, x,y;
   //int lineA=width-100,lineB=width-100,lineC=width-100;
   boolean isDraggingDot1=false;
   boolean isDraggingDot2=false;
   boolean isDraggingDot3=false;
    int x1=650;
    int x2=950;
    int x3=800;
    int y3=100;

     public class ViewPanel extends JPanel{
        public void paintComponent(Graphics g) {
            // Changing Font size
            Font currentFont = g.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
            g.setFont(newFont);
            // Get panel size in unit pixels
            width = getSize().width;
            height = getSize().height;

            // Move Cartesian X, Y coordinates to centre of panel
            g.setColor(new Color(255,255,240));// Get new colour
            g.fillRect(0,0,width,height);  // Set canvas background colour

            x = width/2;
            y = height*1/3;

             // Draw axis
           g.setColor(new Color(255,200,200));
           //g.drawLine(x,0,x,height);
           g.drawLine(0,y,width,y);
           g.setColor(Color.black);

           //Draw triangle
           g.drawLine(x1,y,x3,y3);
           g.drawLine(x3,y3,x2,y);
           g.drawLine(x1,y,x2,y);
           g.setColor(Color.gray);
           // Draw h line
           g.drawLine(x3,y3,x3,y);
           g.drawString("h",x3+5,y-10);
           // Calculate angles
           int h=y-y3;
           jhValue.setText(String.valueOf(h/10));
           double aSqr=(x3-x1)*(x3-x1)+h*h;
           jSideAValue.setText(String.valueOf((int)Math.sqrt(aSqr)/10));
           double bSqr=(x2-x1)*(x2-x1);
           jSideBValue.setText(String.valueOf((int)Math.sqrt(bSqr)/10));
           double cSqr=(x2-x3)*(x2-x3)+h*h;
           jSideCValue.setText(String.valueOf((int)Math.sqrt(cSqr)/10));
           double angleA=(bSqr+cSqr-aSqr)/(2*(x2-x1)*(Math.sqrt(cSqr)));
           double angleB=(aSqr+cSqr-bSqr)/(2*(Math.sqrt(aSqr))*Math.sqrt(cSqr));
           double angleC=(aSqr+bSqr-cSqr)/(2*(Math.sqrt(aSqr))*(x2-x1));

           double radA = Math.acos(angleA);
           double radB = Math.acos(angleB);
           double radC = Math.acos(angleC);
           // Display angle values
           aValueLabel.setText(String.valueOf((int)Math.toDegrees(radA)));
           bValueLabel.setText(String.valueOf((int)Math.toDegrees(radB)));
           cValueLabel.setText(String.valueOf((int)Math.toDegrees(radC)));
           double area=Math.sqrt(bSqr)/10*h/20;
          // double area=Math.sqrt(bSqr)*h/200;
           jLabel4.setText(String.valueOf((int)area));
           // Display radian values
           DecimalFormat form1 = new DecimalFormat("#0.0000"); // Round-off numbers
           aRadValue.setText(String.valueOf(form1.format(radA)));
           bRadValue.setText(String.valueOf(form1.format(radB)));
           cRadValue.setText(String.valueOf(form1.format(radC)));
           double x4=30*Math.cos(radC);
           double y4=30*Math.sin(radC);
           double x5=30*Math.cos(radA);
           double y5=30*Math.sin(radA);
           g.setColor(Color.black);
           g.drawLine(x3,y3,x3+(int)x4,y3-(int)y4);
           g.drawLine(x3,y3,x3-(int)x5,y3-(int)y5);
           g.setColor(Color.orange);
           g.fillArc(x2-13,y-13,26,26,180,(int)-Math.toDegrees(radA));
           g.fillArc(x3-13,y3-13,26,26,0,-(int)Math.toDegrees(radA));
           g.fillArc(x3-13,y3-13,26,26,180,-(int)Math.toDegrees(radA));
           g.setColor(Color.lightGray);
           g.fillArc(x3-13,y3-13,26,26,-(int)Math.toDegrees(radA),(int)-Math.toDegrees(radB));
           g.fillArc(x3-13,y3-13,26,26,(int)Math.toDegrees(radC),(int)Math.toDegrees(radB));
           g.drawLine(x3-30,y3,x3+30,y3);
           g.setColor(Color.green);
           g.fillArc(x1-13,y-13,26,26,0,(int)Math.toDegrees(radC));
           g.fillArc(x3-13,y3-13,26,26,180,(int)Math.toDegrees(radC));
           g.fillArc(x3-13,y3-13,26,26,0,(int)Math.toDegrees(radC));
            //*************
           if (isDraggingDot1){// Left dot pressed?
           // Change to orange is pressed on
            x1 = new_X;
            g.setColor(Color.blue);
           }
           else
           g.setColor(Color.red);
           g.fillOval(x1-3,y-3,7,7);

           if (isDraggingDot2){// Right dot pressed?
           // Change to orange is pressed on
           x2 = new_X;
           g.setColor(Color.blue);
           }
           else
           g.setColor(Color.red);
           g.fillOval(x2-3,y-3,7,7);

           if (isDraggingDot3){// Top dot pressed?
           // Change to orange is pressed on
           x3 = new_X;
           y3 = new_Y;
           g.setColor(Color.blue);
           }
           else
           g.setColor(Color.red);

           g.fillOval((x3-4),y3-4 ,8,8);
           //Display triangle formulas
           g.setColor(Color.red);
           g.drawString("THE SUM of the inside ANGLES is always 180\u2218",10,25);
           g.setColor(Color.black);
           g.drawString("Cos \u03B1 = B\u00B2+C\u00B2-A\u00B2",10,55);
           g.drawLine(85,57,150,57);
           g.drawString("                  2*B*C",10,73);
           // Sine rule
           g.drawString("    SINE RULE",15,100);
           g.drawString("Sin a = Sin b = Sin c",10,115);
            g.drawString("_____    _____     _____",10,115);

           g.drawString("   A          B          C",10,130);
           g.drawString("SIDE 'A ' \u27F6",x1-200,y-(y-y3)/2);
           g.drawString("SIDE 'B' \u2191",(x1+x2-50)/2,y+40);
           g.drawString("\u27F5 SIDE 'C'",x2+200,y-(y-y3)/2);
           g.drawString("Angle'c'",x1+10,y+20);
           g.drawString("Angle'a'",x2-15,y+20);
           g.drawString("Angle'b'",x3-95,y3+20);
           repaint();


    }
}
    public static void main(String[] args) {

       // TriangleDemo JFrame = new TriangleDemo();

        JFrame frame = new JFrame("Triangle Demo by Guy Lemire");

       // frame.pack(); // set window to appropriate size (for its elements)
        frame = new TriangleDemo ();
        frame.setSize ( 2000,1000 );

                frame.setVisible(true);   // usual step to make frame visible


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel jLabel4;
    private JLabel jSideCValue;
    private JLabel bRadLabel;
    private JLabel angleLabel;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel cRadValue;
    private JLabel jSideALabel;
    private JLabel aRadLabel;
    private JLabel jLabel2;
    private JLabel cValueLabel;
    private JLabel aValueLabel;
    private JLabel aLabel;
    private JLabel aRadValue;
    private JLabel jSideAValue;
    private JLabel bValueLabel;
    private JPanel infoPanel;
    private JLabel jSideCLabel;
    private JPanel viewPanel;
    private JLabel jSides;
    private JLabel radianLabel;
    private JLabel jSideBLabel;
    private JLabel bLabel;
    private JLabel bRadValue;
    private JLabel jSideBValue;
    private JLabel cRadLabel;
    private JLabel cLabel;
    private JLabel jhValue;
    private JLabel jhLabel;
    // End of variables declaration//GEN-END:variables
    
}
