package Interfaz.Diseno;

import javax.swing.border.Border;
import java.awt.*;

public class RoundBtn implements Border {

    private int radio;

    public RoundBtn(int Pradio)
    {
        radio = Pradio;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radio, radio);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radio+1, radio+1, radio+2, radio);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
