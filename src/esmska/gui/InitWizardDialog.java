package esmska.gui;

import esmska.data.Config;
import esmska.data.CountryPrefix;
import esmska.data.Icons;
import esmska.utils.L10N;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import org.openide.awt.Mnemonics;

/** Wizard run on first program start to collect important user settings
 *
 * @author ripper
 */
public class InitWizardDialog extends javax.swing.JDialog {
    private static final ResourceBundle l10n = L10N.l10nBundle;
    private static final Config config = Config.getInstance();

    /** Creates new form InitWizardDialog */
    public InitWizardDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setResizable(true);
        initComponents();

        //focus
        finishButton.requestFocusInWindow();
        this.getRootPane().setDefaultButton(finishButton);

        //set window images
        ArrayList<Image> images = new ArrayList<Image>();
        images.add(Icons.get("esmska-16.png").getImage());
        images.add(Icons.get("esmska-32.png").getImage());
        images.add(Icons.get("esmska-64.png").getImage());
        images.add(Icons.get("esmska.png").getImage());
        setIconImages(images);

        //close on Ctrl+W
        String command = "close";
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(
                KeyEvent.VK_W, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), command);
        getRootPane().getActionMap().put(command, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finishButtonActionPerformed(e);
            }
        });

        //center the dialog
        this.setLocationRelativeTo(parent);
    }

    /** Validate country prefix and save it to config if all ok */
    private void processCountryPrefix() {
        String prefix = countryPrefixPanel.getCountryPrefix();
        if (CountryPrefix.isValidCountryPrefix(prefix)) {
            config.setCountryPrefix(prefix);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        countryPrefixPanel = new CountryPrefixPanel();
        jLabel1 = new JLabel();
        finishButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);

        Mnemonics.setLocalizedText(jLabel1, l10n.getString("InitWizardDialog.jLabel1.text"));
        finishButton.setIcon(new ImageIcon(getClass().getResource("/esmska/resources/next-22.png"))); // NOI18N
        Mnemonics.setLocalizedText(finishButton, l10n.getString("Finish_"));
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(finishButton, Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(countryPrefixPanel, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(countryPrefixPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 46, Short.MAX_VALUE)
                .addComponent(finishButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finishButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        processCountryPrefix();
        this.dispose();
    }//GEN-LAST:event_finishButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CountryPrefixPanel countryPrefixPanel;
    private JButton finishButton;
    private JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
