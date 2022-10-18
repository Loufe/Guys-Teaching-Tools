/*
 * GuyTrigTutor.java
 *
 * Created on June 17, 2004, 9:41 AM
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

import static java.awt.Font.BOLD;

/**
 *
 * @author  Guy Lemire
 */
public class GuyTrigTutor extends JFrame {
    // ViewPanel viewPanel;

    private GuyTrigTutor(){
        JPanel trigValuePanel = new JPanel();
        JLabel sinLabel = new JLabel();
        JLabel cosLabel = new JLabel();
        JLabel tanLabel = new JLabel();
        sinValue = new JTextField();
        cosValue = new JTextField();
        tanValue = new JTextField();
        JLabel cartesLabel1 = new JLabel();
        JLabel cartesLabel2 = new JLabel();
        JLabel xLabel = new JLabel();
        JLabel yLabel = new JLabel();
        xCoordText = new JTextField();
        yCoordText = new JTextField();
/*        JLabel jPolarLabel1 = new JLabel();
        JLabel jPolarLabel2 = new JLabel();*/
        JLabel jRadianLabel = new JLabel();
        jRadianText = new JTextField();
        jRadiusField = new JTextField();
        JPanel degreeControlPanel = new JPanel();
        jSliderDegree = new JSlider();
        jDegreeText = new JTextField();
        JLabel jDegreeLabel = new JLabel();
        JPanel viewPanel1 = new JPanel();

        trigValuePanel.setBorder(BorderFactory.createTitledBorder("Trig Values"));
        trigValuePanel.setPreferredSize(new Dimension(130, 500));
        trigValuePanel.setLayout(null);

        sinLabel.setText("SIN");
        trigValuePanel.add(sinLabel);
        sinLabel.setBounds(10, 30, 40, 14);

        cosLabel.setText("COS");
        trigValuePanel.add(cosLabel);
        cosLabel.setBounds(10, 50, 40, 14);

        tanLabel.setText("TAN");
        trigValuePanel.add(tanLabel);
        tanLabel.setBounds(10, 70, 40, 14);

        sinValue.setEditable(false);
        sinValue.setHorizontalAlignment(JTextField.CENTER);
        sinValue.setPreferredSize(new Dimension(50, 20));
        trigValuePanel.add(sinValue);
        sinValue.setBounds(40, 30, 70, 20);

        cosValue.setEditable(false);
        cosValue.setHorizontalAlignment(JTextField.CENTER);
        trigValuePanel.add(cosValue);
        cosValue.setBounds(40, 50, 70, 20);

        tanValue.setEditable(false);
        tanValue.setHorizontalAlignment(JTextField.CENTER);
        trigValuePanel.add(tanValue);
        tanValue.setBounds(40, 70, 70, 20);

        cartesLabel1.setText("CARTESIAN");
        trigValuePanel.add(cartesLabel1);
        cartesLabel1.setBounds(20, 110, 90, 14);

        cartesLabel2.setText("COORDINATES");
        trigValuePanel.add(cartesLabel2);
        cartesLabel2.setBounds(10, 130, 110, 14);

        xLabel.setText("X=");
        trigValuePanel.add(xLabel);
        xLabel.setBounds(30, 160, 20, 14);

        yLabel.setText("Y=");
        trigValuePanel.add(yLabel);
        yLabel.setBounds(30, 180, 20, 14);

        xCoordText.setEditable(false);
        xCoordText.setHorizontalAlignment(JTextField.CENTER);

        trigValuePanel.add(xCoordText);
        xCoordText.setBounds(50, 160, 50, 20);

        yCoordText.setEditable(false);
        yCoordText.setHorizontalAlignment(JTextField.CENTER);
        trigValuePanel.add(yCoordText);
        yCoordText.setBounds(50, 180, 50, 20);


        jRadianLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        jRadianLabel.setText("ANGLE (RADIANS)");
        trigValuePanel.add(jRadianLabel);
        jRadianLabel.setBounds(10, 270, 11090, 13);

        jRadianText.setEditable(false);
        jRadianText.setHorizontalAlignment(JTextField.CENTER);
        trigValuePanel.add(jRadianText);
        jRadianText.setBounds(20, 290, 70, 20);

        getContentPane().add(trigValuePanel, BorderLayout.WEST);

        degreeControlPanel.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        degreeControlPanel.setPreferredSize(new Dimension(600, 35));

        jSliderDegree.setMaximum(360);
        jSliderDegree.setMinorTickSpacing(5);
        jSliderDegree.setPaintTicks(true);
        jSliderDegree.setValue(45);
        jSliderDegree.addChangeListener(evt1 -> jSliderDegreeStateChanged());
        degreeControlPanel.add(jSliderDegree);

        jDegreeText.setHorizontalAlignment(JTextField.CENTER);
        jDegreeText.setText("45");
        jDegreeText.setPreferredSize(new Dimension(30, 20));
        jDegreeText.addActionListener(evt -> jDegreeTextActionPerformed());
        jDegreeText.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jDegreeTextMouseClicked();
            }
        });
        degreeControlPanel.add(jDegreeText);

        jDegreeLabel.setText("Degrees");
        degreeControlPanel.add(jDegreeLabel);

        getContentPane().add(degreeControlPanel, BorderLayout.SOUTH);

        viewPanel1.setPreferredSize(new Dimension(500, 500));
        ViewPanel viewPanel=new ViewPanel();
        viewPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                viewPanelMousePressed(evt);
            }
            public void mouseReleased(MouseEvent evt) {
                viewPanelMouseReleased(evt);
            }
            public void mouseClicked(MouseEvent evt) {
                viewPanelMouseClicked();
            }
            public void mouseExited(MouseEvent evt) {
                viewPanelMouseExited();
            }
            public void mouseEntered(MouseEvent evt) {
                viewPanelMouseEntered();
            }
        });
        viewPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                viewPanelMouseMoved();
            }
            public void mouseDragged(MouseEvent evt) {
                viewPanelMouseDragged(evt);
            }
        });
        viewPanel.setLayout(null);
        getContentPane().add(viewPanel, BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void viewPanelMouseEntered() {//GEN-FIRST:event_viewPanelMouseEntered
        // Add your handling code here:
    }//GEN-LAST:event_viewPanelMouseEntered

    private void viewPanelMouseExited() {//GEN-FIRST:event_viewPanelMouseExited
        // Add your handling code here:
    }//GEN-LAST:event_viewPanelMouseExited

    private void viewPanelMouseClicked() {//GEN-FIRST:event_viewPanelMouseClicked
        // Add your handling code here:
    }//GEN-LAST:event_viewPanelMouseClicked

    private void viewPanelMouseReleased(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseReleased
        isDraggingDot = false;

        repaint();
        evt.consume();

    }//GEN-LAST:event_viewPanelMouseReleased

    private void viewPanelMousePressed(MouseEvent evt) {//GEN-FIRST:event_viewPanelMousePressed
        int new_x = evt.getX() - width / 2;
        int new_y = height / 2 - evt.getY();

        if (x - 3 < new_x && new_x < x + 3 && y - 3 < new_y && new_y < new_y + 3) {

            isDraggingDot = true;

            repaint();
        }
        evt.consume();

    }//GEN-LAST:event_viewPanelMousePressed

    private void viewPanelMouseDragged(MouseEvent evt) {//GEN-FIRST:event_viewPanelMouseDragged
        // While Mouse is first pressed on "dot" and then dragged
        // get new X and Y coordinates

        if (isDraggingDot) {
            // Get the latest position
            x = evt.getX() - width / 2;
            y = height / 2 - evt.getY();

            // Move and paint the "dot" by the distance moved since last event
            repaint();
            evt.consume();
        }
    }//GEN-LAST:event_viewPanelMouseDragged

    private void viewPanelMouseMoved() {//GEN-FIRST:event_viewPanelMouseMoved
        // Add your handling code here:
    }//GEN-LAST:event_viewPanelMouseMoved

    private void jSliderDegreeStateChanged() {
        // If "slider value changed, update "degree text"
        jDegreeText.setText(String.valueOf(jSliderDegree.getValue()));

        repaint();

    }//GEN-LAST:event_jSliderDegreeStateChanged

    private void jDegreeTextMouseClicked() {//GEN-FIRST:event_jDegreeTextMouseClicked
        // Add your handling code here: // Clear the "degree text" when Mouse clicked on it

        jDegreeText.setText("");

    }//GEN-LAST:event_jDegreeTextMouseClicked

    private void jDegreeTextActionPerformed() {//GEN-FIRST:event_jDegreeTextActionPerformed
        // If new value entered in "degree text", update "slider" value
        jSliderDegree.setValue(Integer.parseInt(jDegreeText.getText()));
        repaint();

    }//GEN-LAST:event_jDegreeTextActionPerformed
    private int width;
    private int height;
    private int x;
    private int y;
    private boolean isDraggingDot = false;

    // Paint panel
    public class ViewPanel extends JPanel {

        public void paintComponent(Graphics g) {

            int hlines, vlines, radius;
            // Get panel size in unit pixels           
            Rectangle r = getBounds();

            height = r.height;
            width = r.width;
            // Move Cartesian X, Y coordinates to centre of panel
            int centreX = r.width / 2;
            int centreY = r.height / 2;
            // Set-up maximum length of radius/hypotenuse
            radius = Math.min(centreX, centreY) - 50;

            g.setColor(new Color(255, 255, 240));// Get new colour
            g.fillRect(0, 0, r.width, r.height);  // Canvas background colour

            // Draw grid
            hlines = height / 10;
            vlines = width / 10;
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
            g2d.setTransform(old);

            // Calculate radian angle of theta
            double theta;
            if (isDraggingDot) {
                // Mouse pressed at "dot" and dragged, change value of angle
                theta = Math.atan2(y, x); // Degree
                // Convert to radians and change Slider value
                while (theta < 0.0) {
                    theta += 2 * Math.PI;
                }

                jSliderDegree.setValue((int) Math.toDegrees(theta));
            } // Mouse released, Mouse dragged "False"
            else {
                theta = (Math.toRadians(jSliderDegree.getValue()));
            }

            // Draw ring
            g.setColor(Color.blue);
            g.drawOval(centreX - radius, centreY - radius, radius * 2, radius * 2);
            g.setColor(Color.red);
            g.fillArc(centreX - 24, centreY - 24, 48, 48, 0, (jSliderDegree.getValue()));

            // Draw dot on circle
            if (isDraggingDot) {
                g.setColor(Color.orange); // Change "dot" colour if Mouse pressed on it
            } else {
                g.setColor(Color.red); // Normal "dot" colour
            }            // Get centre of "dot"
            int arrowTipX = centreX + (int) (radius * Math.cos(theta));
            int arrowTipY = centreY - (int) (radius * Math.sin(theta));
            g.fillOval(arrowTipX - 5, arrowTipY - 5, 10, 10);

            //Draw hypotenuse (radius), side adjacent & side opposite lines
            g.setColor(Color.black);
            g.drawLine(centreX, centreY, arrowTipX, arrowTipY); // Radius
            g.drawLine(centreX, centreY, centreX + (int) (radius * Math.cos(theta)), centreY); // Side Adjacent
            g.drawLine(arrowTipX, arrowTipY, centreX + (int) (radius * Math.cos(theta)), centreY); // Side Opposite


            // Draw PI value labels and dots
            g.drawString("PI /6", centreX + 6 + (int) (radius * Math.cos(.5236)), centreY + 3 - (int) (radius * Math.sin(.5236)));
            g.fillOval(centreX + (int) (radius * Math.cos(.5236)), centreY - (int) (radius * Math.sin(.5236)), 7, 7);
            g.drawString("PI /4", centreX + 6 + (int) (radius * Math.cos(.7854)), centreY + 3 - (int) (radius * Math.sin(.7854)));
            g.fillOval(centreX + (int) (radius * Math.cos(.7854)), centreY - (int) (radius * Math.sin(.7854)), 7, 7);
            g.drawString("PI /3", centreX + 8 + (int) (radius * Math.cos(1.0472)), centreY + 5 - (int) (radius * Math.sin(1.0472)));
            g.fillOval(centreX + (int) (radius * Math.cos(1.0472)), centreY - (int) (radius * Math.sin(1.0472)), 7, 7);
            g.fillOval(centreX -3 + (int) (radius * Math.cos(1.5708)), centreY - 5 - (int) (radius * Math.sin(1.5708)), 8, 8);
            g.drawString("PI 2/3", centreX - 36 + (int) (radius * Math.cos(2.0944)), centreY - 5 - (int) (radius * Math.sin(2.0944)));
            g.fillOval(centreX - 7 + (int) (radius * Math.cos(2.0944)), centreY - (int) (radius * Math.sin(2.0944)), 7, 7);

            g.fillOval(centreX - 4 + (int) (radius * Math.cos(3.1416)), centreY - 4- (int) (radius * Math.sin(0.0)), 8, 8);
            g.fillOval(centreX - 4 + (int) (radius * Math.cos(0.0)), centreY - 4- (int) (radius * Math.sin(0.0)), 8, 8);
            // Draw axes value
            g.setFont(new Font("Serif", BOLD, 14));
            g.drawString("Y", centreX - 11, 15);
            g.drawString("PI/2", centreX - 15, 40);
            g.drawString("-X", 10, centreY - 5);
            g.drawString("(3.1416)", 140, centreY - 5);
            g.drawString("PI (Radian)", 120, centreY +19);
            g.drawString("-Y", centreX - 18, height - 10);
            g.drawString("PI 3/2", centreX - 18, height - 35);
            g.drawString("X", width - 40, centreY - 5);
            g.drawString("0", width - 210, centreY - 5);
            // Display Trig values
            DecimalFormat form1 = new DecimalFormat("#0.0000"); // Round-off values
            // DecimalFormat form2 = new DecimalFormat("#0.0E0");

            jRadianText.setText(String.valueOf(form1.format(theta)));
            sinValue.setText(String.valueOf(form1.format(Math.sin(theta))));
            cosValue.setText(String.valueOf(form1.format(Math.cos(theta))));

            if ((Math.tan(theta)) <= 99.9) {
                jRadiusField.setText(String.valueOf(radius));
                tanValue.setText(String.valueOf(form1.format(Math.tan(theta))));
            } else //tanValue.setText("Infinity");
            {
                tanValue.setText("   \u221E");
            }
            // Calculate X, Y  coordinates
            x = arrowTipX - r.width / 2;
            y = r.height / 2 - arrowTipY;

            // Display X, Y coordinates
            xCoordText.setText(String.valueOf(x));
            yCoordText.setText(String.valueOf(y));

            g.setColor(Color.black);
            g.setFont(new Font("Serif", BOLD,18));
            g.drawString("SIN = SIDE OPPOSITE OVER HYPOTHENUS",10,25);
            g.drawString("COS = SIDE ADJACENT OVER HYPOTHENUS",10,50);
            g.drawString("TAN = SIDE OPPOSITE OVER SIDE ADJACENT",10,75);
            g.setFont(new Font("Serif", BOLD,18));
            g.drawString("Use Mouse Pointer to Move ",centreX+126,25);
            g.setColor(Color.red);
            g.drawString("NOTE:",centreX + 50,25);
            g.drawString("Red Dot",centreX+415,25);
            g.drawString("NOTE:",10,930);
            g.drawString("You can also use the Slider to change angle",96,930);
        }
    }

    public static void main(String[] args) {

        GuyTrigTutor frame = new GuyTrigTutor();

        frame.setSize ( 1400,1000 );
        frame.setLocationRelativeTo(null); // set window to appropriate size (for its elements)
        frame.setVisible(true); // usual step to make frame visible

    }

    private JTextField cosValue;
    private JTextField jDegreeText;
    private JTextField jRadianText;
    private JTextField jRadiusField;
    private JSlider jSliderDegree;
    private JTextField sinValue;
    private JTextField tanValue;
    private JTextField xCoordText;
    private JTextField yCoordText;
    // End of variables declaration//GEN-END:variables
}