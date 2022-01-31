package menu;

import java.awt.Dimension;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class Animation {

    private final MenuItem item;
    private Animator animator;
    private TimingTarget target;

    public Animation(MenuItem item) {
        this.item = item;
        this.animator = new Animator(200);
        this.animator.setResolution(0);
    }

    public void mouseEnter() {
        stop();
        animator.removeTarget(target);
        target = new PropertySetter(item, "imageSize", item.getImageSize(), new Dimension(55, 55));
        animator.addTarget(target);
        animator.start();
    }

    public void mouseExit() {
        stop();
        animator.removeTarget(target);
        target = new PropertySetter(item, "imageSize", item.getImageSize(), new Dimension(40, 40));
        animator.addTarget(target);
        animator.start();
    }

    public void stop() {
        if (animator.isRunning()) {
            animator.stop();
        }
    }
}
