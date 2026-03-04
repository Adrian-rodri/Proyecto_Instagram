
package proyecto_instagram;

/**
 *
 * @author adria
 */
import javax.swing.*;
public abstract class MenuBase extends JPanel { 
   MenuBase(){
       this.setLayout(null);
       this.setSize(1366,768);
       this.setVisible(true);
   }
   
   public abstract void cargarComponentes();
   public abstract void refresh();
   
}
