/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopikopi;

import javax.swing.UIManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alanmsmxyz
 */
public class main {
    public static void main(String args[]) {
        // Set theme according to SystemLookAndFell
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, e);
        }

        // Running mode switcher
        String menu = args.length > 0 ? args[0] : "";
        switch(menu) {
            case "manage-menu":
                new ControllerManageMenu();
                System.out.println("Running in manage-menu mode");
                break;
            case "manage-order":
                new ControllerManageOrder();
                System.out.println("Running in manage-order mode");
                break;
            case "create-order":
                new ControllerCreateOrder();
                System.out.println("Running in create-order mode");
                break;
            default:
                System.out.println("No running mode selected!");
                System.out.println("Usage kopikopi [manage-menu|manage-order|create-order]");
                break;
        }
    }
}
