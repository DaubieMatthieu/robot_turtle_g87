package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class Background_panel extends JPanel {
    public static final int CENTERED = 0;
    public static final int SCALED   = 1;

    private Image backgroundImage = null;
    private int   backgroundType  = CENTERED;

    public Background_panel() {
        super();
    }

    public Background_panel(boolean isDoubleBuffered ) {
        super( isDoubleBuffered );
    }

    public Background_panel(LayoutManager layout ) {
        super( layout );
    }

    public Background_panel(LayoutManager layout, boolean isDoubleBuffered ) {
        super( layout, isDoubleBuffered );
    }

    public void setBackgroundImage( String filename ) {
        Image image = java.awt.Toolkit.getDefaultToolkit().getImage(filename);
        backgroundImage = image;
        backgroundType = SCALED;
        repaint();
    }


    public void setBackgroundType( int type ) {
        if ( type == CENTERED || type == SCALED ) {
            backgroundType = type;
            repaint();
        }
        else {
            throw new IllegalArgumentException( "background type should be SCALED or CENTERED." );
        }
    }

    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        if ( backgroundImage != null ) {
            if ( backgroundType == CENTERED ) {
                int imageX = (getWidth() - backgroundImage.getWidth( this )) / 2;
                int imageY = (getHeight() - backgroundImage.getHeight( this )) / 2;
                imageX = Math.max( 0, imageX );
                imageY = Math.max( 0, imageY );
                g.drawImage( backgroundImage, imageX, imageY, this );
            }
            else if ( backgroundType == SCALED ) {
                g.drawImage( backgroundImage, 0, 0, getWidth(), getHeight(), this );
            }
        }
    }
/*
    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame( "BackgroundPanelTest" );


        frame.getContentPane().add( new BackgroundPanel("res/images/background.png") );

        frame.setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE );
        frame.setSize( 620, 802 );
        frame.setVisible( true );
        frame.setLocationRelativeTo(null);
    }

 */
}