package com.mamo_dev.backupR.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class LicenseGui extends javax.swing.JDialog {

	public static final int RET_CANCEL = 0;
	public static final int RET_OK = 1;

	public LicenseGui(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();

		String cancelName = "cancel";
		InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
		ActionMap actionMap = getRootPane().getActionMap();
		actionMap.put(cancelName, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doClose(RET_CANCEL);
			}
		});
	}

	public int getReturnStatus() {
		return returnStatus;
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        licenseLabel = new javax.swing.JLabel();
        licenseScrollPane = new javax.swing.JScrollPane();
        licenseTextPane = new javax.swing.JTextPane();
        denyButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        titleLabel.setText("<html><body><p style=\"font-size: 1.5em;\">BackupR</p></body></html>");

        licenseLabel.setText("To use this program, you have to accept the following license.");

        licenseTextPane.setEditable(false);
        licenseTextPane.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut semper ligula lectus, eget convallis magna dignissim eget. Aliquam ut ligula congue, porttitor felis vitae, aliquam risus. Suspendisse risus sapien, pretium ut ligula eget, hendrerit tincidunt arcu. Sed elit nulla, eleifend quis augue sed, vestibulum placerat lorem. Maecenas molestie fringilla venenatis. Vestibulum at dolor augue. Duis convallis porttitor cursus. Cras a ipsum in lorem congue interdum. Aliquam ultricies, justo non pharetra auctor, metus nulla sollicitudin tellus, quis porta lectus velit ac lectus.\n\nMauris sollicitudin eros at leo venenatis lobortis. Nulla facilisi. Nunc scelerisque leo non pretium vulputate. Donec posuere est erat, in tincidunt leo scelerisque nec. Fusce libero arcu, ornare non adipiscing ac, euismod et justo. Donec sed erat sit amet odio interdum dapibus et non nulla. Mauris fermentum posuere lectus, at semper diam vestibulum et. Nulla diam ipsum, consequat quis massa quis, tempor porta quam. Integer nulla lacus, tincidunt id tempus vulputate, convallis pharetra elit. Duis sed adipiscing nunc. Integer suscipit orci ac enim pulvinar tempus. In tempor nec lorem cursus molestie. Aenean vitae odio suscipit, interdum dui et, ultricies diam. Vestibulum non pretium augue, eget gravida ipsum. Mauris sed nisi nec urna lobortis hendrerit quis porta ante.\n\nClass aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec bibendum imperdiet congue. Nunc dapibus, leo in tincidunt consequat, felis mauris vulputate massa, vitae commodo ipsum urna sit amet justo. Quisque ac massa sit amet tortor porttitor commodo sit amet vel nibh. Integer malesuada arcu vitae rutrum congue. In sodales eros leo, et volutpat augue mattis vitae. Quisque rutrum, elit in posuere feugiat, dui dui cursus eros, quis blandit purus nisi at diam. Curabitur nec condimentum neque, eget suscipit magna. Nunc ac vehicula orci, dapibus sollicitudin velit. Curabitur posuere odio id mauris sollicitudin iaculis. Morbi pulvinar orci eu vestibulum congue. Pellentesque est nibh, luctus id justo eu, imperdiet luctus odio. Vestibulum a imperdiet purus. Phasellus elit leo, iaculis sit amet nisi at, auctor interdum leo. In at facilisis leo. Morbi accumsan cursus mauris vitae varius.\n\nPraesent aliquet iaculis porttitor. Maecenas id metus adipiscing neque dictum volutpat. Ut ipsum dolor, ullamcorper mollis dapibus sed, congue vel justo. Sed quis arcu diam. Donec mattis ultrices lacus sed feugiat. Nullam ornare scelerisque est. Proin rutrum elit sagittis, rhoncus neque ac, faucibus nisl. Suspendisse euismod odio vel velit pretium ullamcorper. Donec id lacus porttitor, fringilla erat in, consectetur erat. Nam nec ligula quis elit lacinia suscipit a eget nisi. In non sem sed odio aliquam volutpat non at arcu. Fusce ac mattis lorem, ac aliquet risus.\n\nNam et sapien non elit hendrerit facilisis ut id sem. Quisque congue orci eu nisi sagittis, id ultrices mi consequat. Phasellus vulputate faucibus nisi, a sagittis purus interdum et. Sed ornare sagittis accumsan. Proin tortor sem, rhoncus eget lobortis quis, placerat commodo ligula. Morbi sagittis scelerisque odio vitae suscipit. Donec suscipit eleifend augue eget dapibus. Quisque pulvinar mattis placerat. ");
        licenseScrollPane.setViewportView(licenseTextPane);
        try {
            licenseTextPane.setPage(LicenseGui.class.getResource("/license.html"));
        } catch (IOException e) {}

        denyButton.setText("Accept");
        denyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("Deny");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(licenseScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(acceptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(denyButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(licenseLabel)
                        .addGap(0, 175, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(licenseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(licenseScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton)
                    .addComponent(denyButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(denyButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void denyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyButtonActionPerformed
		doClose(RET_OK);
    }//GEN-LAST:event_denyButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
		doClose(RET_CANCEL);
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
		doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

	private void doClose(int retStatus) {
		returnStatus = retStatus;
		setVisible(false);
		dispose();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton denyButton;
    private javax.swing.JLabel licenseLabel;
    private javax.swing.JScrollPane licenseScrollPane;
    private javax.swing.JTextPane licenseTextPane;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

	private int returnStatus = RET_CANCEL;
}
