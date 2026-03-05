
package proyecto_instagram;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
public abstract class MenuBase extends JPanel { 
   MenuBase(){
       this.setBackground(new Color(0xFFFFFF));
       this.setLayout(null);
       this.setSize(1366,768);
       this.setVisible(true);
   }
   
   public abstract void cargarComponentes();
   public abstract void refresh();
   
}
