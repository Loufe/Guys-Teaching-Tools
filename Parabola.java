/*
 * Parabola.java
 *
 * Created on August 3, 2004, 3:55 PM
 * Revised on October 11, 2004
 * @author  Guy Lemire
 */
package Parabola;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;



/** @noinspection ALL*/
class Parabola extends JFrame {
    Timer timer;
    private ActionEvent evt;
    private ActionEvent actionEvent;

    /**
     * Creates new form Parabola
     */
    public Parabola() {

        JPanel infoPanel = new JPanel();
        JButton jResetButton = new JButton();
        JButton jProofButton = new JButton();
        startStopButton = new JButton();
        JLabel jReflectLabel = new JLabel();
        JLabel jTurnLabel = new JLabel();
        jPFvalue = new JLabel();
        jPHvalue = new JLabel();
        jPFlabel = new JLabel();
        jPHlabel = new JLabel();
        jTangentButton = new JButton();
        jTangentLabel = new JLabel();
        jSlopeValue = new JLabel();
        jSlopeLabel = new JLabel();
        JButton jApplications = new JButton();
        ViewPanel viewPanel = new ViewPanel();
        setVisible(true);

        infoPanel.setLayout(null);

        infoPanel.setBorder(new javax.swing.border.TitledBorder("  PARABOLA"));
        infoPanel.setMaximumSize(new Dimension(140, 500));
        infoPanel.setPreferredSize(new Dimension(140, 500));
        jResetButton.setText("RESET");
        jResetButton.setHorizontalTextPosition(SwingConstants.CENTER);
        jResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jResetButtonActionPerformed();
            }
        });

        infoPanel.add(jResetButton);
        jResetButton.setBounds(10, 390, 110, 26);

        jProofButton.setText("PROOF");
        jProofButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jProofButtonActionPerformed(evt);
            }
        });

        infoPanel.add(jProofButton);
        jProofButton.setBounds(10, 60, 110, 26);

        startStopButton.setText("ON");
        startStopButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                startStopButtonActionPerformed(evt);
            }
        });

        Component add = infoPanel.add(startStopButton);
        startStopButton.setBounds(10, 310, 110, 26);

        jReflectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jReflectLabel.setText("REFLECTOR");
        infoPanel.add(jReflectLabel);
        jReflectLabel.setBounds(10, 290, 110, 20);

        jTurnLabel.setText("TURN");
        infoPanel.add(jTurnLabel);
        jTurnLabel.setBounds(50, 280, 41, 16);

        jPFvalue.setMaximumSize(new Dimension(23, 16));
        jPFvalue.setPreferredSize(new Dimension(23, 16));
        infoPanel.add(jPFvalue);
        jPFvalue.setBounds(70, 90, 30, 16);

        jPHvalue.setMaximumSize(new Dimension(23, 16));
        jPHvalue.setPreferredSize(new Dimension(23, 16));
        infoPanel.add(jPHvalue);
        jPHvalue.setBounds(70, 110, 30, 16);

        jPFlabel.setText("         ");
        infoPanel.add(jPFlabel);
        jPFlabel.setBounds(20, 90, 60, 16);

        jPHlabel.setText("        ");
        infoPanel.add(jPHlabel);
        jPHlabel.setBounds(20, 110, 60, 16);

        jTangentButton.setBorder(new javax.swing.border.CompoundBorder(null, new javax.swing.border.EtchedBorder()));
        jTangentButton.setHorizontalTextPosition(SwingConstants.CENTER);
        jTangentButton.setPreferredSize(new Dimension(74, 26));
        jTangentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTangentButtonActionPerformed(evt);
            }
        });

        infoPanel.add(jTangentButton);
        jTangentButton.setBounds(40, 190, 50, 26);

        jTangentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jTangentLabel.setPreferredSize(new Dimension(74, 26));
        jTangentLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        infoPanel.add(jTangentLabel);
        jTangentLabel.setBounds(10, 150, 110, 26);

        jSlopeValue.setPreferredSize(new Dimension(30, 16));
        infoPanel.add(jSlopeValue);
        jSlopeValue.setBounds(86, 220, 50, 16);

        jSlopeLabel.setText("     ");
        infoPanel.add(jSlopeLabel);
        jSlopeLabel.setBounds(10, 220, 90, 16);

        jApplications.setFont(new Font("Arial", Font.BOLD, 10));
        jApplications.setText("APPLICATIONS");
        jApplications.setHorizontalTextPosition(SwingConstants.CENTER);
        jApplications.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jApplicationsActionPerformed(evt);
            }
        });

        infoPanel.add(jApplications);
        jApplications.setBounds(10, 460, 115, 23);

        getContentPane().add(infoPanel, BorderLayout.WEST);

        viewPanel.setBackground(new Color(204, 204, 204));
        //ViewPanel viewPanel = new ViewPanel();
        viewPanel.setBounds(10, 460, 500, 23);
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

        y = 0;
    }   //GEN-END:Parabola()

    private void jApplicationsActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jApplicationsActionPerformed
        applications = true;
        proof = false;
        tangent = false;
        animation = false;
        definition = false;
    }//GEN-LAST:event_jApplicationsActionPerformed

    private void jTangentButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTangentButtonActionPerformed
        if ("ON".equals(jTangentButton.getText())) {
            proof = true;
            tangent = true;
            jTangentButton.setText("OFF");
        } else if ("OFF" == jTangentButton.getText()) {
            proof = false;
            jTangentButton.setText("ON");
        }
        definition = false;
        repaint();
    }//GEN-LAST:event_jTangentButtonActionPerformed

    private void viewPanelMouseMoved(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseMoved

    }//GEN-LAST:event_viewPanelMouseMoved

    private void viewPanelMouseEntered() {//GEN-FIRST:event_viewPanelMouseEntered

    }//GEN-LAST:event_viewPanelMouseEntered

    private void viewPanelMouseExited(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseExited

    }//GEN-LAST:event_viewPanelMouseExited

    private void viewPanelMouseClicked(MouseEvent evt) {//GEN-FIRjPHvalueST:event_viewPanelMouseClicked

    }//GEN-LAST:event_viewPanelMouseClicked

    private void startStopButtonActionPerformed(ActionEvent evt) {
        this.evt = evt;//GEN-FIRST:event_startStopButtonActionPerformed
        definition = false;
        // Animate reflector
        t = 400;
        if ("ON" == startStopButton.getText()) {
            k = 1;
            b = -100;
            px = false;
            applications = false;
            //timer.restart();
            animation = true;
            startStopButton.setText("OFF");
        } else {
            animation = false;
            startStopButton.setText("ON");
        }
        jTangentButton.setText("ON");
        proof = false;
        tangent = false;
        applications = false;
        repaint();
    }//GEN-LAST:event_startStopButtonActionPerformed

    private void jProofButtonActionPerformed() {
        jProofButtonActionPerformed();
    }//GEN-LAST:event_jProofButtonActionPerformed

    private void jProofButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jProofButtonActionPerformed
        // Proof
        proof = true;
        b = 30;
        px = true;
        definition = false;
        animation = false;
        tangent = false;
        applications = false;
        isDraggingDot = false;
        startStopButton.setText("ON");
        jTangentButton.setText("ON");
        jTangentLabel.setText("Tangent Line");
        repaint();
    }//GEN-LAST:event_jProofButtonActionPerformed

    private void jResetButtonActionPerformed() {//GEN-FIRST:event_jResetButtonActionPerformed
        // Plot Curve y^2=4px
        b = 30;
        px = true;
        definition = true;
        proof = false;
        tangent = false;
        animation = false;
        applications = false;
        startStopButton.setText("ON");
        jTangentButton.setText("ON");
        startStopButton.setText("ON");
        repaint();
    }//GEN-LAST:event_jResetButtonActionPerformed

    private void viewPanelMouseDragged(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseDragged
        new_x = evt.getX();
        new_y = evt.getY();
        if (!isDraggingDot) {
            x2 = -evt.getX() + width / 2;
            y2 = height / 2 + evt.getY();
            b = 30;
        }
        //  with Mouse change values of Focus x & y
        if (isDraggingDot) {
            {
                if (new_y < height / 2 - 5 || new_y > height / 2 + 5) {
                    px = true;// Focus on y-axis
                    b = height / 2 - new_y;
                } else {
                    px = false;//Focus on x-axis
                    b = (width / 2 - new_x);
                }
            }
        }
        // Lock focus on x-axis
        if (animation) {
            px = false;
            b = width / 2 - new_x;
        }
        repaint();
        evt.consume();
    }//GEN-LAST:event_viewPanelMouseDragged

    private void viewPanelMouseReleased(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseReleased
        isDraggingDot = false;
        repaint();
        evt.consume();
    }//GEN-LAST:event_viewPanelMouseReleased

    private void viewPanelMousePressed(MouseEvent evt) {//GEN-FIRST:event_viewPanelMousePressed
        definition = false;
        if (!proof) {
            // Get Mouse pointer's new x & y values
            new_x = evt.getX();
            new_y = evt.getY();
            isDraggingDot = true;
        } else {
            isDraggingDot = false;
        }
        repaint();
        evt.consume();
    }//GEN-LAST:event_viewPanelMousePressed

    private int y;
    private int new_x;
    private int new_y;
    private int p;
    private int b = 30;
    private int k = 1;
    private int t;
    private int l;
    private int width, height, i, y2, x2 = 100;
    private boolean isDraggingDot = false, px = true, proof = false, animation = false;
    private boolean tangent = false, applications = false, definition = true;

    public class ViewPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Get panel size in unit pixels
            Rectangle r = getBounds();
            height = r.height;
            width = r.width;
            // Move Cartesian X, Y coordinates to centre of panel
            float centreX = r.width / 2;
            float centreY = r.height / 2;
            // Paint canvas
            g.setColor(new Color(255, 255, 240));// Get new colour
            g.fillRect(0, 0, r.width, r.height);  // Canvas background colour

            // Draw grid
            int hlines = height / 10;
            int vlines = width / 10;
            Graphics2D g2d = (Graphics2D) g;
            AffineTransform old = g2d.getTransform();
            g2d.translate(centreX, centreY);
            g.setColor(Color.lightGray);
            for (int i = -hlines / 2; i <= hlines / 2; i++) {
                g.drawLine(-width / 2, i * 10, width / 2, i * 10);
            }
            for (int i = -vlines; i <= vlines / 2; i++) {
                g.drawLine(i * 10, height / 2, i * 10, -height / 2);
            }
            // Draw Y, X axis
            g.setColor(Color.magenta);
            g.drawLine(-width / 2, 0, width / 2, 0); // X axis
            g.drawLine(0, height / 2, 0, -height / 2);  // Y axis
            // Instruction
            g.setColor(Color.white);
            g.setFont(new Font("Serif", Font.BOLD, 16));
            g.fillRect(-250, -height / 2 + 15, 430, 20);
            g.setColor(Color.red);
            g.drawString("NOTE: ", -240, -height / 2 + 30);
            g.drawString("Red Dots", 87, -height / 2 + 30);
            g.setColor(Color.black);
            g.drawString("Use Mouse Pointer to move", -175, -height / 2 + 30);
            g.drawRect(-250, -height / 2 + 15, 430, 20);
            if (definition) {
                g.setColor(Color.white);
                g.fillRect(-360, height / 2 - 175, 700, 140);
                g.setColor(Color.black);
                g.drawRect(-360, height / 2 - 175, 700, 140);
                g.drawString("A locus of points is a collection of points that satisfies a given equation.", -355, height / 2 - 160);
                g.drawString("A parabola is a collection of points (a locus) such that the moving locus", -355, height / 2 - 130);
                g.drawString("point P(x,y) is always equidistant from the focus and the directrix.", -355, height / 2 - 115);
                g.drawString("A focus is the point used to determine the parabola's openness and", -355, height / 2 - 85);
                g.drawString("distance from the directrix.", -355, height / 2 - 70);
                g.drawString("A directrix is a fixed line that serves as a guide in creating our parabola.", -355, height / 2 - 40);

                g.fillOval(-x2 - 4, (int) -f(x2) - 4, 8, 8);
                g.drawString(" P(x,y)", -x2 - 7, (int) -f(x2) - 5);
                g.setColor(Color.blue);
                g.drawString("Directrix", 155, b);
                g.setColor(Color.red);
                g.drawString("Focus", 4, -b - 4);
            }
            // ****** If mouse pressed, change colour on Focus dot?
            if (isDraggingDot)
                g.setColor(Color.orange);
            else
                g.setColor(Color.red);
            int x1 = 0;
            if (px) {
                g.fillOval(x1 - 4, y - b - 4, 8, 8);// red dot Focus on y axis*
                // Directrix
                g.setColor(Color.blue);
                g.drawLine(-150, b, 150, b);
            }
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.BOLD, 18));
            for (int x = -200; x < 200; x++) {
                if (px) {
                    g.drawLine(x, -(int) f(x), x + 1, -(int) f(x + 1));// Draw curve

                    if (b > 0) {// Focus above the X axis.....x^2=4py
                        g.setColor(Color.white);
                        g.fillRect(-30, -height / 2 + 75, 85, 20);
                        g.setColor(Color.red);
                        g.drawString("x\u00b2= 4py", -25, -height / 2 + 90);//x^2=4py
                        g.setColor(Color.black);
                        g.drawRect(-30, -height / 2 + 75, 85, 20);
                    } else {// Focus below the X axis.... x^2= -4py
                        g.setColor(Color.white);
                        g.fillRect(-30, height / 2 - 85, 88, 20);
                        g.setColor(Color.red);
                        g.drawString("x\u00b2= -4py", -25, height / 2 - 70);// x^2= -4py
                        g.setColor(Color.black);
                        g.drawRect(-30, height / 2 - 85, 88, 20);
                    }
                } else {// px== false, draw y^2=-4px
                    g.setColor(Color.red);
                    g.fillOval(-b - 4, -4, 8, 8);// red dot (p) on x axis
                    // Directrix
                    g.setColor(Color.blue);
                    g.drawLine(b, -150, b, 150);
                    g.setColor(Color.black);
                    g.drawLine(-(int) f(x), x, -(int) f(x + 1), x + 1);// Draw curve
                    if (b < 0) {// Focus on left side of  X origin
                        g.setColor(Color.white);
                        g.fillRect(width / 2 - 145, -25, 85, 20);
                        g.setColor(Color.red);
                        g.drawString("y\u00b2= 4px", width / 2 - 140, -10);// y^2=4px
                        g.setColor(Color.black);
                        g.drawRect(width / 2 - 145, -25, 85, 20);
                    } else {// Focus on right side of X origin
                        g.setColor(Color.white);
                        g.fillRect(-width / 2 + 55, -25, 85, 20);
                        g.setColor(Color.red);
                        g.drawString("y\u00b2= -4px", -width / 2 + 60, -10);// y^2=-4px
                        g.setColor(Color.black);
                        g.drawRect(-width / 2 + 55, -25, 85, 20);
                    }
                }
            }
            g.setColor(Color.black);
            g.setFont(new Font("Serif", Font.BOLD, 14));
            g.drawString("Y", -12, -height / 2 + 50);
            g.drawString("X", width / 2 - 20, -2);
            //**************** PROOF **********************
            if (proof && px) {
                // The Focus(x,y) is locked but P(x,y) can be moved
                g.setColor(Color.black);
                // Draw line from P(x,y)to half distance from H to Ft, tangent to P(x,y)
                g.drawLine(-x2, (int) -f(x2), -x2 / 2, 0);
                DecimalFormat form1 = new DecimalFormat("0.0");
                // Values of P (x,y)
                g.drawString("P(" + form1.format((float) -x2 / 10) + "," + (form1.format(f(x2) / 10)) + ")", -x2 - 5, (int) -f(x2) - 5);
                g.setColor(Color.red);
                g.drawLine(-x2, (int) -f(x2), -x2, b - 4);// Draw line from directrix H(x,-b)
                g.drawLine(0, -b, -x2, (int) -f(x2));// Draw line from Focus to Point(x,y)
                g.fillOval(-x2 - 4, (int) -f(x2) - 4, 8, 8);// Draw oval at P(x,y)
                g.setColor(Color.magenta);
                g.fillOval(y - 4, x1 - b - 4, 8, 8);// Draw oval at Focus
                g.fillOval(-x2 - 3, b - 4, 8, 8);// Draw oval at H(x,-b)
                // *********Display proof************************************
                g.setColor(Color.black);
                double k = Point2D.distance(-x2, (int) -f(x2), -x2, b);// Distance from Directrix to P
                double k2 = Point2D.distance(0, -b, -x2, (int) -f(x2));// Distance from Focus to P
                //double k3 = Point2D.distance(0, -b - 4, -x2, b + 4);// Distance from Focus to H
               // double h = Math.sqrt(k2 * k2 - k3 * k3 / 4);
                double slope = (k - b) / (x2 / 2);

                jPFlabel.setText("P\u2192 F= ");// P (unicode symbol right arrow) F=
                jPFvalue.setText(String.valueOf((int) k / 10));// Display distance value
                jPHlabel.setText("P\u2192 H= ");// P (unicode symbol right arrow) H=
                jPHvalue.setText(String.valueOf((int) k2 / 10));
                // Describe the Parabola
                if (!tangent) {
                    g.setColor(Color.white);
                    g.fillRect(-250, 80, 500, 160);
                    g.setColor(Color.lightGray);
                    g.drawLine(-x2, b, 0, -b);
                    g.setColor(Color.black);
                    g.drawRect(-250, 80, 500, 160);
                    g.drawString("Focus(a,p)", 4, -b - 4);
                    g.drawString("H(x,-p)", -x2, b + 10);
                    g.drawString("Directrix", 130, b - 8);
                    g.setColor(Color.red);
                    g.drawString("PARABOLA", -245, 100);
                    g.setColor(Color.black);
                    g.drawString("The properties: ", -150, 100);
                    g.drawString("The distances from a point P on the parabola to the focus F", -245, 115);
                    g.drawString("or to a point H on the  directrix are the same \u2234 P\u2192F=P\u2192H.", -245, 130);
                    g.drawString("Let the coordinates of F, P and H be (a,p), (x,y) and (x,-p).", -245, 145);
                    g.drawString("Since P \u2192 F=P \u2192 H  \u2234 (x-a)\u00B2 + (y-p)\u00B2 = (y+p)\u00B2", -245, 175);
                    g.drawString("In this case the vertex is at the origin (0,0) therefore a=0", -245, 190);
                    g.drawString(" and p is equal to the distance of F from the origin.", -245, 205);
                    g.drawString("The equation of parabola is:y=x\u00B2/4p  or x\u00b2=4py", -245, 225);
                }
                // ********Draw moving tangent. Calculate coordinates********
                else {
                    //if(tangent is true, draw tangent line
                    double theta = Math.atan2(k - b, x2 / 2);// Calculate angle in radian of tangent line
                    g.setColor(new Color(0, 130, 130));
                    int temp = 180 - (int) Math.toDegrees(theta);// Slope
                    g.fillArc(-x2 / 2 - 13, -13, 26, 26, 0, temp);
                    g.drawString("\u03b8", -x2 / 2, -15);
                    g.setFont(new Font("Serif", Font.BOLD, 16));
                    g.setColor(Color.black);
                    g.drawString("Angle \u03b8 (" + temp + "\u00b0) = the slope of the tangent line in degrees", -150, b + 20);

                    double x4 = -x2 + (100 * Math.cos(Math.PI - theta));// Tangent extension line above P(x,y)
                    double y4 = -(int) f(x2) - (100 * Math.sin(Math.PI - theta));
                    g.drawLine(-x2, -(int) f(x2), (int) x4, (int) y4);//
                    g.setFont(new Font("Serif", Font.BOLD, 14));

                    double x5 = -x2 + (1000 * Math.cos(2 * Math.PI - theta));// Tangent extension below P(x,y)
                    double y5 = -(int) f(x2) - (1000 * Math.sin(2 * Math.PI - theta));
                    g.drawLine(-x2, -(int) f(x2), (int) x5, (int) y5);
                    jSlopeLabel.setText("Slope m = ");
                    DecimalFormat form2 = new DecimalFormat("0.000");
                    jSlopeValue.setText(String.valueOf(form2.format(-slope)));
                    g.setColor(Color.red);
                    g.fillRect(-90, b + 22, 30, 4);
                    g.setColor(Color.white);
                    g.fillRect(-250, 180, 450, 60);
                    g.setColor(Color.black);
                    g.drawString("TANGENT - The line with slope m at P(x,y):", -240, 200);
                    g.drawString("The equation for the tangent line is y=mx+b", -240, 215);
                    g.drawString("where b=p/m,  p= distance from origin to the Focus", -240, 230);
                    g.drawRect(-250, 180, 450, 60);
                }
            }
            // if(!proof) clear values
            else {
                jPFvalue.setText("");
                jPFlabel.setText("     ");
                jPHvalue.setText("");
                jPHlabel.setText("     ");
                jSlopeValue.setText("");
                jSlopeLabel.setText("     ");
                jTangentButton.setText("");
                jTangentLabel.setText("");
            }
            repaint();
            // ***************************************
            t = 100; // Timer interval
            if (animation) {  // Used in reflector....


                if (b <= 0) {
                    g.setColor(Color.black);
                    // draw reflector lines
                    for (i = -200; i <= 200; i += 40) {
                        g2d.draw(new Line2D.Double(centreX, i, -(int) f(i), i));
                        g2d.drawLine(-b, 0, -(int) f(i), i);
                        g2d.setStroke(new BasicStroke(3.0f));
                        g2d.draw(new Line2D.Double(centreX - 700 - (int) f(i), i, centreX - 690 - (int) f(i), i + 6));// Arrows
                        g2d.draw(new Line2D.Double(centreX - 700 - (int) f(i), i, centreX - 690 - (int) f(i), i - 6));
                        g2d.setStroke(new BasicStroke(2.0f));
                        repaint();
                    }
                }
                else // b> 0
                {
                    centreX = -centreX;
                    for (i = -200; i <= 200; i += 40) {
                        g2d.draw(new Line2D.Double(centreX, i, -(int) f(i), i));
                        g2d.drawLine(-b, 0, -(int) f(i), i);
                        g2d.setStroke(new BasicStroke(3.0f));
                        g2d.draw(new Line2D.Double(centreX + 700 - (int) f(i), i, centreX + 690 - (int) f(i), i + 6));
                        g2d.draw(new Line2D.Double(centreX + 700 - (int) f(i), i, centreX + 690 - (int) f(i), i - 6));
                        g2d.setStroke(new BasicStroke(2.0f));
                    }
                }
                g.setColor(Color.red);
                g.fillOval(-b - 4, -4, 8, 8);// Focus red dot
            }
            // Enter list of applications using the parabolic shapes
            if (applications) {
                g2d.setTransform(old);
                g.setColor(new Color(255, 255, 240));// Get new colour
                g.fillRect(0, 0, width, height);
                g.setColor(Color.black);
                g.drawString("APPLICATIONS", 210, 30);
                g.drawString("Parabolic dishes to receive satellite signals for radio and television.", 40, 60);
                g.drawString("Parabolic reflectors in car headlights.", 40, 80);
                g.drawString("Parabolic structures in bridges.", 40, 100);
                g.drawString("Parabolic dome in large buildings such as arenas.", 40, 120);
                g.drawString("Parabolic mirrors in telescopes.", 40, 140);
                g.drawString("Parabolic curve of flight.", 40, 160);
            }
        }
    }

    // Responds to Timer's event
    private final ActionListener timerListener = new ActionListener() {
        public ActionEvent getActionEvent() {
            return actionEvent;
        }

        private ActionEvent actionEvent;

        public void actionPerformed(ActionEvent actionEvent) {
            this.actionEvent = actionEvent;
            k++;
            if (k > (int) 24) {

                timer.stop();
            }
        }
    };

    public void actionPerformed(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
        // Start time for reflector
        if (animation) {

        if (timer == null) {
            start();
        } else
            timer.stop();
    }
}
          private void start(){
              if(timer==null){
                  timer=new Timer(t,timerListener);
                  timer.start();
              }
               else timer.restart();
              }
          public void stopAnimation(){
          if(timer!=null){
          timer = null;
          }
          }

          private double f(double x) {// Function x and y calculation
         return -(x*x/(-4*b)); 
         }

    public static void main(String[] args) {


        JFrame frame;
        frame = new Parabola ();   //"Parabola by Guy Lemire, 2004, rev. 2018"
        frame.setSize ( 2000,1000 );

        frame.setVisible(true); // usual step to make frame visible

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel jSlopeValue;
    private JLabel jPHvalue;
    private JButton jTangentButton;
    private JButton startStopButton;
    private JLabel jPFlabel;
    private JLabel jPFvalue;
    private JLabel jSlopeLabel;
    private JLabel jPHlabel;
    private JLabel jTangentLabel;


    // End of variables declaration//GEN-END:variables
    
}
