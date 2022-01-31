package menu;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MenuItem extends JButton {

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Dimension getImageSize() {
        return imageSize;
    }

    public void setImageSize(Dimension imageSize) {
        this.imageSize = imageSize;
        repaint();
    }

    private final Animation animation;
    private Image image;
    private Dimension imageSize = new Dimension(40, 40);

    public MenuItem() {
        setContentAreaFilled(false);
        setBorder(null);
        animation = new Animation(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                animation.mouseEnter();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                animation.mouseExit();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        int width = getWidth();
        int height = getHeight();
        int x = (width - imageSize.width) / 2;
        int y = (height - imageSize.height) / 2;
        g2.drawImage(image, x, y, imageSize.width, imageSize.height, null);
        g2.dispose();
        super.paintComponent(grphcs);
    }
}
