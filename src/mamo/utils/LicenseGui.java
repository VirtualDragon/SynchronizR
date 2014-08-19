package mamo.utils;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class LicenseGui extends javax.swing.JDialog {

	public static final int RET_CANCEL = 0;
	public static final int RET_OK = 1;

	public LicenseGui(java.awt.Frame parent, boolean modal, URL license) throws IOException {
		super(parent, modal);
		initComponents();
		licenseTextPane.setPage(license);

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

        licenseLabel.setText("To use this program, you have to accept the following license.");

        licenseTextPane.setEditable(false);
        licenseScrollPane.setViewportView(licenseTextPane);

        denyButton.setText("Deny");
        denyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("Accept");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(licenseScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(licenseLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(denyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(acceptButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(licenseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(licenseScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(denyButton)
                    .addComponent(acceptButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(acceptButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
		doClose(RET_OK);
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void denyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyButtonActionPerformed
		doClose(RET_CANCEL);
    }//GEN-LAST:event_denyButtonActionPerformed

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
    // End of variables declaration//GEN-END:variables

	private int returnStatus = RET_CANCEL;
}
