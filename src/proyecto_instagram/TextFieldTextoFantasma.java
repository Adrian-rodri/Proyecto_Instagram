package proyecto_instagram;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldTextoFantasma extends JTextField {
    private String placeholder;
    private Color placeholderColor = new Color(150, 150, 150); // gris suave

    public TextFieldTextoFantasma(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Solo dibuja el placeholder si el campo está vacío y sin foco
        if (getText().isEmpty() && !isFocusOwner()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(placeholderColor);
            g2.setFont(getFont());

            Insets insets = getInsets();
            int x = insets.left;
            int y = (getHeight() - g2.getFontMetrics().getHeight()) / 2 + g2.getFontMetrics().getAscent();

            g2.drawString(placeholder, x, y);
            g2.dispose();
        }
    }
}
