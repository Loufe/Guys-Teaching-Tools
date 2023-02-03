/*
 * Circle.java
 *
 * Created on August 26, 2004, 1:31 PM
 */

package Circle;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import static java.awt.BorderLayout.*;
import static javax.swing.BorderFactory.*;

/**
 *
 * @author  Guy Lemire
 */
public class Circle extends javax.swing.JFrame implements ActionListener {
    private Timer timer;

    /**
     * Creates new form Circle
     */
    public Circle() {
        start();
        JPanel infoPanel = new JPanel();
        JLabel jLabel2 = new JLabel();

        ViewPanel viewPanel = new ViewPanel();
        viewPanel.setFont( new java.awt.Font( "Dialog", Font.PLAIN, 18 ) );
        viewPanel.setPreferredSize( new Dimension( 1000, 800 ) );
        getContentPane().add( viewPanel, CENTER );

        infoPanel.setLayout( null );

        infoPanel.setBorder( createTitledBorder( "Circle Properties" ) );
        infoPanel.setPreferredSize( new Dimension( 150, 1000 ) );

        JButton circumference = new JButton();
        circumference.setText( "CIRCUMFERENCE" );
        circumference.addActionListener( evt3 -> circumferenceActionPerformed() );

        infoPanel.add( circumference );
        circumference.setBounds( -10, 46, 148, 23 );

        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton area = new JButton();
        area.setText( "AREA" );
        area.addActionListener( evt -> areaActionPerformed() );

        infoPanel.add( area );
        area.setBounds( -10, 77, 148, 23 );

        jLabel2.setText( "SPHERE" );
        infoPanel.add( jLabel2 );
        jLabel2.setBounds( 40, 150, 85, 14 );

        JButton surface = new JButton();
        surface.setText( "SURFACE" );
        surface.addActionListener( evt2 -> surfaceActionPerformed() );

        infoPanel.add( surface );
        surface.setBounds( -10, 170, 148, 23 );

        JButton volume = new JButton();
        volume.setText( "VOLUME" );
        volume.addActionListener( evt1 -> volumeActionPerformed() );

        infoPanel.add( volume );
        volume.setBounds( -10, 200, 148, 23 );
/*
        JButton areaAnimation = new JButton();
        areaAnimation.setText( "PROOF" );
        areaAnimation.addActionListener( evt1 -> areaAnimationActionPerformed( evt1 ) );
        //start2=true;
        infoPanel.add( areaAnimation );
        areaAnimation.setBounds( -10, 110, 148, 23 );*/

        getContentPane().add( infoPanel, WEST );
        setTitle( "Circle Properties" );
        setSize( 2000, 1000 );     //Added setXXX() methods like setSize() etc.
        setVisible( true );
        //start2 = true;
        circ = false;

        j = 3;
        k = 1;
        t = 200;
    }// </editor-fold>//GEN-END:initComponents

    private void areaAnimationActionPerformed() {
        start2 = true;
        are = false;
        surf = false;
        vol = false;
        circ = false;
        start1 = start3 = false;

    }//GEN-LAST:event_areaAnimationActionPerformed

    private void volumeActionPerformed() {
        vol = true;
        surf = false;
        are = false;
        circ = false;
        start1 = start2 = start3 = false;        JButton areaAnimation = new JButton();
        areaAnimation.setText( "PROOF" );
        areaAnimation.addActionListener( evt1 -> areaAnimationActionPerformed() );
        //start2=true;
       // infoPanel.add( areaAnimation );
        areaAnimation.setBounds( -10, 110, 148, 23 );
    }//GEN-LAST:event_volumeActionPerformed

    private void surfaceActionPerformed() {
        surf = true;
        vol = false;
        are = false;
        circ = false;
        start1 = start2 = start3 = false;
    }//GEN-LAST:event_surfaceActionPerformed

    private void areaActionPerformed() {//GEN-FIRST:event_areaActionPerformed
        are = true;
        surf = false;
        vol = false;
        circ = false;

        start1 = start2 = start3 = false;
    }//GEN-LAST:event_areaActionPerformed

    private void circumferenceActionPerformed() {
        circ = true;
        surf = false;
        vol = false;
        are = false;
        start1 = start2 = start3 = false;
    }//GEN-LAST:event_circumferenceActionPerformed

    private int j;
    private int k;
    private int t;

    private boolean circ, are = false, surf = false, vol = false;// ,areAnimation=false
    private boolean start1 = true;  //poligons
    private boolean start2 = false; //area of circle plus tangent line
    private boolean start3 = false;  //first scene with the "THE CIRCLE"

    public class ViewPanel extends JPanel {

        public void paintComponent(Graphics g) {

            Graphics2D g2D = (Graphics2D) g;
            AffineTransform old = g2D.getTransform();
            super.paintComponent( g );
            // Move Cartesian X, Y coordinates to centre of panel
            int width = getSize().width;
            int height;
            height = getSize().height;
            float centerX = width >> 1;
            float centerY = height >> 1;
            //******************************
            if (start1 || start2 || start3) {
                g2D.setTransform( old );
                g2D.setPaint( new GradientPaint( 0, 0, Color.white, width, height, Color.red, true ) );
                g2D.fill( new Rectangle2D.Double( 0, 0, width, height ) );
                g2D.translate( centerX, centerY );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 18 ) );
                // g.setColor(Color.white);
            }
            if (start1) {
                g.setColor( Color.black );
                // Draw polygon
                g2D.draw( makePoly( j ) );

                g2D.drawString( String.valueOf( j ), -64, -10 );
                g2D.drawString( " Sides Polygon", -42, -10 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 30 ) );
                g2D.drawString( "The Infinite Sided Polygon =", -200, 200 );
            }
            float radius = 150;
            repaint();
            if (start3) {
                int k = 1;
                g.setColor( Color.black );
            if (start2) {
                //  for (int k = 1; k<=33; ++k) {
                System.out.println( "k =  " + k + "\n" );

                g.setColor( Color.white );  // changed from white to black

                Polygon polygon1 = new Polygon();// Tangent arrow
                polygon1.addPoint( (int) -((radius - 5) * Math.cos( Math.toRadians( 10 * k + 30 ) - Math.PI )),
                        (int) -((radius - 5) * Math.sin( Math.toRadians( 10 * k + 30 ) - Math.PI )) );
                polygon1.addPoint( (int) -((radius - 20) * Math.cos( Math.toRadians( 10 * k + 40 ) - Math.PI )),
                        (int) -((radius - 20) * Math.sin( Math.toRadians( 10 * k + 40 ) - Math.PI )) );
                polygon1.addPoint( (int) -((radius - 20) * Math.cos( Math.toRadians( 10 * k + 20 ) - Math.PI )),
                        (int) -((radius - 20) * Math.sin( Math.toRadians( 10 * k + 20 ) - Math.PI )) );
                g2D.fillPolygon( polygon1 );
                g2D.drawString( "Tangent Lines", -34, -10 );
                //}
            }
                while (k < 36) {  //Drawing the circle

                    g2D.drawArc( -(int) radius, -(int) radius, 2 * (int) radius, 2 * (int) radius, 0, -10 * k - 30 );
                    k++;
                             }

                g.setFont( new Font( "SansSerif", Font.PLAIN, 40 ) );
                g2D.drawString( "The CIRCLE", -110, -175 );

            }
            if (circ || are || surf || vol)// || areAnimation
            {
                g2D.translate( centerX, centerY );
                // Draw grid
                int hlines = height / 10;
                int vlines = width / 10;
                g.setColor( Color.lightGray );
                for (int i = -hlines / 2; i <= hlines / 2; i++) {
                    g.drawLine( -width / 2, i * 10, width / 2, i * 10 );
                }
                for (int i = -vlines; i <= vlines / 2; i++) {
                    g.drawLine( i * 10, height / 2, i * 10, -height / 2 );
                }
                // Draw Y, X axis
                g.setColor( Color.magenta );
                g.drawLine( -width / 2, 0, width / 2, 0 );    // X axis
                g.drawLine( 0, height / 2, 0, -height / 2 );  // Y axis
                g.setColor( Color.black );
                g.setFont( new Font( "Serif", Font.BOLD, 14 ) );
                g.drawString( "Y", -12, -height / 2 + 15 );
                g.drawString( "-Y", -18, height / 2 - 15 );
                g.drawString( "X", width / 2 - 20, -2 );
                g.drawString( "-X", -width / 2 + 17, -2 );
                g2D.drawOval( -(int) radius, -(int) radius, 2 * (int) radius, 2 * (int) radius );
                repaint();
            }
            if (circ)// circumference
            {
                g.setFont( new Font( "SansSerif", Font.PLAIN, 30 ) );
                g2D.drawString( "Circumference = \u222b\u03c0*dr = 2\u03c0r", -225, -160 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 16 ) );
                g2D.drawString( "2r", 50, -185 );
                g2D.drawString( "o", 49, -148 );
                g2D.drawLine( 0, 0, (int) ((radius) * Math.cos( Math.PI / 4 )), (int) (-(radius) * Math.sin( Math.PI / 4 )) );
                g2D.drawLine( 0, 0, (int) (-(radius) * Math.cos( Math.PI / 4 )), (int) ((radius) * Math.sin( Math.PI / 4 )) );
                g.setColor( Color.yellow );
                g.fillRect( -width / 2 + 10, -height / 2 + 20, 600, 65 );
                g.fillRect( -width / 2 + 10, height / 2 - 80, 600, 50 );
                g.setColor( Color.black );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 20 ) );
                g.drawString( "The constant \u03c0 (PI) is the ratio 'circumference : diameter'", -width / 2 + 15, -height / 2 + 40 );
                g.drawString( "\u03c0 = circumference / diameter = 3.141592.............. ", -width / 2 + 15, -height / 2 + 60 );
                g.drawString( "Circumference = \u03c0*Diameter = 2*\u03c0*Radius", -width / 2 + 15, -height / 2 + 80 );
                g.drawString( "The equation for a Circle with centre at the origin (0,0) is:", -width / 2 + 15, height / 2 - 60 );
                g.drawString( " r\u00b2=y\u00b2+x\u00b2, where r = Radius.", -width / 2 + 15, height / 2 - 40 );
                AffineTransform at = new AffineTransform();
                at.setToRotation( -Math.PI / 4 );
                g2D.transform( at );
                at.setToTranslation( 0.0f, 0.0f );
                g2D.transform( at );
                g.setColor( Color.red );
                g2D.drawLine( 0, -(int) radius - 5, 0, -height / 2 + 15 );
                g2D.drawString( "2*RADIUS (r) = DIAMETER", -140.0f, -5.0f );
                Polygon polygon2 = new Polygon();// Circumference arrow
                polygon2.addPoint( 0, (int) -radius - 2 );
                polygon2.addPoint( -5, (int) -radius - 15 );
                polygon2.addPoint( 5, (int) -radius - 15 );
                g2D.fillPolygon( polygon2 );
                g2D.setTransform( old );
            }
            if (are)// area areAnimation||are
            {
                g.setFont( new Font( "SansSerif", Font.PLAIN, 30 ) );
                g2D.drawString( "AREA = \u222b 2\u03c0r*dr = \u03c0r\u00b2", -170, -160 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 18 ) );
                g2D.drawString( "                            r", -200, -185 );
                g2D.drawString( "                            o", -200, -148 );
                int a = 50;
                float x6 = (float) (radius * Math.cos( a * Math.PI / 180 ));
                float y6 = -(float) (radius * Math.sin( a * Math.PI / 180 ));
                int b = 40;
                float x7 = (float) (radius * Math.cos( b * Math.PI / 180 ));
                float y7 = -(float) (radius * Math.sin( b * Math.PI / 180 ));
                g2D.drawLine( 0, 0, (int) x6, (int) y6 );
                g2D.drawLine( 0, 0, (int) x7, (int) y7 );
                g.drawString( "\u03b8", 25, -3 );// Angle theta
                g.setColor( Color.black );
                float x8 = (float) (radius * Math.cos( 45 * Math.PI / 180 ));
                float y8 = -(float) (radius * Math.sin( 45 * Math.PI / 180 ));

                g.drawString( "E", (int) x6 + 4, (int) y6 - 8 ); // Red pie shape in circle place in program
                g.drawString( "F", (int) x6 + 8, (int) y8 );
                g.drawString( "D", (int) x7 + 8, (int) y7 );
                g.drawString( "C                           B", -12, 14 );
                g.setColor( Color.red );
                Polygon polygon1 = new Polygon();// Pie shape
                polygon1.addPoint( 0, 0 );
                polygon1.addPoint( (int) x6, (int) y6 );
                polygon1.addPoint( (int) x7, (int) y7 );
                g2D.fillPolygon( polygon1 );
                g2D.drawArc( -15, -15, 30, 30, 370, 40 );
                g.setColor( Color.black );
                g2D.drawLine( 0, 0, (int) x8 - 1, (int) y8 + 1 );// CF line
                g2D.drawLine( (int) x6 - 1, (int) y6 + 1, (int) x7 - 1, (int) y7 + 1 );
                g.setColor( Color.yellow );

                g2D.setTransform( old );
                g.fillRect( 30, 4, 550, 130 );
                g.setColor( Color.red );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 20 ) );
                g.drawString( "Area of a Circle", 35, 20 );
                g.setColor( Color.black );
                g.drawRect( 30, 4, 550, 130 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
                g.drawString( "-    Let \u03b8 (theta) denote the angle BCD, then DCE, is the small", 175, 20 );
                g.drawString( "increase in the angle represented by \u0394\u03b8  and the arc DE = radius(r) * \u0394\u03b8.", 35, 35 );
                g.drawString( "The area of the triangle DCE = \u00bd DE * CF where CF is perpendicular to DE.", 35, 50 );
                g.drawString( "When the angle \u0394\u03b8 becomes infinitely small, the arc and the chord DE are equal and", 35, 65 );
                g.drawString( "CF is equal to the radius.", 35, 80 );
                g2D.translate( 0, 15 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 20 ) );
                g.drawString( "\u2234 area = \u222b \u00bd r \u00b2 * d\u03b8 = \u00bdr \u00b2 \u222b * d\u03b8 = \u00bdr \u00b2 [ \u03b8 ] = \u03c0 r \u00b2", 35, 105 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 12 ) );
                g.drawString( "         2\u03c0                                          2\u03c0                                      2\u03c0   ", 95, 87 );
                g.drawString( "          0                                            0                                       0       ", 95, 116 );
                g.setColor( Color.yellow );
                g.fillRect( 30, 570, 550, 130 );
                g.setColor( Color.red );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 20 ) );
                g.drawString( "Interesting way of finding the area of a Circle.", 35, 590 );
                g.setColor( Color.black );
                g.drawString( "The area of an equilateral triangle is the height", 35, 610 );
                g.drawString( "times the base divided by 2.", 35, 630 );
                g.drawString( "Here we substitute 'radius' for 'height' and ", 35, 650 );
                g.drawString( "'circumference' for the 'base' ", 35, 670 );
                g.drawString( "\u2234 area = (r * 2\u03c0r)/2 = \u03c0 r \u00b2", 35, 692 );
                g2D.translate( centerX, centerY );

            }
            if (surf)
            {
                g.setFont( new Font( "SansSerif", Font.PLAIN, 30 ) );
                g2D.drawString( "Sphere Surface = 2\u222b\u03c0*dr = 4\u03c0r", -225, -164 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 18 ) );
                g2D.drawString( "2r", 74, -189 );
                g2D.drawString( "o", 76, -152 );
                g2D.drawString( "\u00b2", 240, -177 );
                float x6=(float)(radius *Math.cos(45*Math.PI/360));
                float y6=-(float)(radius *Math.sin(45*Math.PI/360));
                float x7=(float)(radius *Math.cos(41*Math.PI/360));
                float y7=-(float)(radius *Math.sin(41*Math.PI/360));
                g2D.drawLine(0,0,(int)x6,(int)y6);
                g2D.drawLine(0,0,(int)x7,(int)y7);
                g2D.drawLine((int)x6,(int)y6,(int)-x6,(int)y6);
                g2D.drawLine((int)x7,(int)y7,(int)-x7,(int)y7);

                g.drawString( "\u03b8", 10, -15 );// Angle theta
                g.drawString( "F", -12, -35 );
                g.drawString( "E", -12, -65 );
                g.drawString( "A", 150, -38 );
                g.drawString( "B", 140, -58 );
                g.drawString( "C", -150, -58 );
                g.drawString( "D", -155, -38 );

                g.setColor( Color.red );
                Polygon polygon2 = new Polygon();// Pie shape
                polygon2.addPoint( 144, -52);//A
                polygon2.addPoint( 140,-56); //B
                polygon2.addPoint( -140,-56);//C
                polygon2.addPoint( -142,-52 );//D
                g2D.fillPolygon( polygon2 );
                g2D.drawArc( -15, -15, 30, 30, 30, 60 );
                g.setColor( Color.yellow );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 16 ) );
                g2D.setTransform( old );
                g.drawString( "The surface area of a sphere can be calculated ", 35, 610 );
                g.drawString( "by multiplying the circumference of a circle by", 35, 630 );
                g.drawString( "itself", 35, 650 );
                g.drawString( "2\u03c0r * 2\u03c0r = 4\u03c0r\u00b2 ", 35, 680 );
                g.fillRect( 30, 4, 550, 160 );
                g.setColor( Color.red );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 20 ) );
                g.drawString( "Surface of a Sphere", 35, 22 );
                g.setColor( Color.black );
                g.drawRect( 30, 4, 550, 160 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 18 ) );
                g.drawString( "-    Area of slice ABCD = 2\u03c0*BE*AB", 225, 22 );
                g.drawString( "BE=r*sin\u03b8  and  AB = r * d\u03b8.", 255, 40 );
                g.drawString( "Area of ABCD = 2\u03c0r *sin \u03b8 * r * d\u03b8", 255, 58 );
                g.drawString( "\u2234 Surface of Sphere = 2\u222b \u03c0r\u00b2 * sin*d\u03b8 ", 35, 90 );
                g.drawString( "   = 4πr² \u222b sin \u03b8 d\u03b8 = 4πr² [-cos \u03b8]", 198, 120 );
                g.drawString( "   = 4πr²", 198, 150 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 14 ) );
                g.drawString( "\u00bd\u03c0", 246, 74);
                g.drawString( "\u00bd\u03c0", 275, 104);
                g.drawString( "\u00bd\u03c0", 494, 104);
                g.drawString( "o", 254, 100);
                g.drawString( "o", 286, 129);
                g.drawString( "o", 501, 129);

                g.setColor( Color.yellow );
                g.fillRect( 30, 570, 550, 130 );
                g.setColor( Color.red );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 20 ) );
                g.drawString( "Interesting way of finding the surface area of a Sphere.", 35, 590 );
                g.setColor( Color.black );
                g.drawString( "The surface area of a sphere can be calculated ", 35, 615 );
                g.drawString( "by multiplying the circumference of the circle by", 35, 635 );
                g.drawString( "itself:", 35, 655 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 26 ) );
                g.drawString( "\u2234 Sphere surface area= 2\u03c0r * 2\u03c0r = 4\u03c0r\u00b2 ", 35, 685 );
                g2D.translate( centerX, centerY );

            }
            if (vol)
            {
                g.setFont( new Font( "SansSerif", Font.PLAIN, 30 ) );
                g2D.drawString( "Sphere Volume = \u222b 4*\u03c0r\u00b2*dr = 4\u03c0r", -225, -164 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 18 ) );
                g2D.drawString( "r", 62, -187 );
                g2D.drawString( "o", 58, -148 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 25 ) );
                g2D.drawString( "_ ", 245, -166 );
                g2D.drawString( "3 ", 245, -140 );
                g2D.drawString( "\u00b3", 290, -175 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 18 ) );
                float x6=(float)(radius *Math.cos(45*Math.PI/360));
                float y6=-(float)(radius *Math.sin(45*Math.PI/360));
                float x7=(float)(radius *Math.cos(41*Math.PI/360));
                float y7=-(float)(radius *Math.sin(41*Math.PI/360));
                g2D.drawLine(0,0,(int)x6,(int)y6);
                g2D.drawLine(0,0,(int)x7,(int)y7);
                g2D.drawLine((int)x6,(int)y6,(int)-x6,(int)y6);
                g2D.drawLine((int)x7,(int)y7,(int)-x7,(int)y7);

                g.drawString( "\u03b8", 10, -15 );// Angle theta
                g.drawString( "F", -12, -35 );
                g.drawString( "E", -12, -65 );
                g.drawString( "A", 150, -38 );
                g.drawString( "B", 140, -58 );
                g.drawString( "C", -150, -58 );
                g.drawString( "D", -155, -38 );

                g.setColor( Color.red );
                Polygon polygon2 = new Polygon();// Pie shape
                polygon2.addPoint( 144, -52);//A0
                polygon2.addPoint( 140,-56); //B
                polygon2.addPoint( -140,-56);//C
                polygon2.addPoint( -142,-52 );//D
                g2D.fillPolygon( polygon2 );
                g2D.drawArc( -15, -15, 30, 30, 30, 60 );
                g.setColor( Color.yellow );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 16 ) );
                g2D.setTransform( old );
                g.drawString( "The surface area of a sphere can be calculated ", 35, 610 );
                g.drawString( "by multiplying the circumference of a circle by", 35, 630 );
                g.drawString( "itself", 35, 650 );
                g.drawString( "2\u03c0r * 2\u03c0r = 4\u03c0r\u00b2 ", 35, 680 );
                g.fillRect( 30, 4, 550, 160 );
                g.setColor( Color.red );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 20 ) );
                g.drawString( "Volume of a Sphere", 35, 22 );
                g.setColor( Color.black );
                g.drawString( "   = \u21534\u03c0 r\u00b3", 198, 150 );  //
                g.drawRect( 30, 4, 550, 160 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 18 ) );
                g.drawString( "-    Volume of slice ABCD = \u03c0*BE\u00b2 * dx", 225, 22 );
                g.drawString( "BE=r*sin\u03b8", 255, 40 );
                g.drawString( "Volume of ABCD = \u03c0r\u00b2 *sin\u00b2\u03b8 * r * sin\u03b8 * d\u03b8", 35, 58 );
                g.drawString( "\u2234 Volume of Sphere = 2\u222b \u03c0r\u00b3\u03b8 * sin\u00b3\u03b8 * d\u03b8 ", 35, 90 );
                g.drawString( "   = 2 πr\u00b3 \u222b * sin\u00b3\u03b8 * d\u03b8 ", 198, 120 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 14 ) );
                g.drawString( "\u00bd\u03c0", 246, 74);
                g.drawString( "\u00bd\u03c0", 285, 106);
                g.drawString( "o", 255, 100);
                g.drawString( "o", 292, 130);

                g.setColor( Color.yellow );
                g.fillRect( 30, 570, 560, 140 );
                g.setColor( Color.red );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 20 ) );
                g.drawString( "interesting way of finding the volume of a Sphere.", 35, 590 );
                g.setColor( Color.black );
                g.drawString( "The volume of a tetrahedron is the height * the surface", 35, 615 );
                g.drawString( "area of its triangular base divided by three.", 35, 635 );
                g.drawString( "Substituting radius r for the height & the surface area", 35, 655 );
                g.drawString( "of the sphere and dividing the whole by three.", 35, 675 );
                g.setFont( new Font( "SansSerif", Font.PLAIN, 26 ) );
                g.drawString( "\u2234 volume = (\u2153r * 4\u03c0 r \u00b2 = \u21534\u03c0 r\u00b3", 70, 700 );
                //
                g2D.translate( centerX, centerY );
            }
        }
    }


        // Drawing polygons
        private Path2D makePoly(int nSides){

            // int nSides;
             GeneralPath path = new GeneralPath();
            // Move to first point
            path.moveTo((float) 150,0);
            // Line to remaining points
            float deltaTheta = (float)(2*Math.PI/nSides);
            float theta = deltaTheta;

            for (int i=1;i<nSides; i++) {
                float x =(float)((float) 150 * Math.cos(theta));
                float y =(float)((float) 150 * Math.sin(theta));
                path.lineTo(x,y);
                theta += deltaTheta;
            }
            // Close the path
            path.closePath();
           return path;
        }


  // Responds to Timer's event
  private ActionListener timerListener = new ActionListener(){
         public void actionPerformed(ActionEvent actionEvent) {
            if(start1){
            j++;
           if(j>12) {
             j=j+2;
            if(j>24){
            start1=false;
           //start2=true;
                start3=true; //alert was start2=true;
            }
            }
            }
           else{
           // start2 = false;
            if(start2){
                k++;

            if(k>33){
          start2=false;
          start3=false;
           }
            }
           }
            if(!start1 && !start2)
           timer.stop();
         }
     };
     public void actionPerformed(ActionEvent actionEvent) {
         if(timer == null)
             start();

         else
             stop();
     }
     // Timer
     private void start(){
         if(timer==null){
             int t = 500;
             timer= new Timer(t,timerListener);
             timer.start();
         }
         else
             timer.restart();
     }
     private void stop() {
         if (timer != null) {
             timer = null;
         }
     }
     public static void main(String[] args) {

         JFrame frame;

         // frame.pack(); // set window to appropriate size (for its elements)
         frame = new Circle ();
         frame.setSize ( 1000,800 );
         frame.setLocationRelativeTo(null); // set window to appropriate size (for its elements)
         frame.setVisible(true);   // usual step to make frame visible
     }

}