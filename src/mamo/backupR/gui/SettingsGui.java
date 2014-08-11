package mamo.backupR.gui;

import mamo.backupR.BackupR;
import mamo.backupR.SettingsEnum;
import java.io.IOException;

public class SettingsGui extends javax.swing.JPanel {

	public SettingsGui() {
		initComponents();
		prefUpdate();
	}

	private void prefUpdate() {
		boolean automaticUpdateCheck = BackupR.getSettings().getBoolean(SettingsEnum.AUTOMATIC_UPDATE_CHECK.toString());
		automaticUpdateCheckCheckBox.setSelected(automaticUpdateCheck);
		automaticUpdateInstallationRadioButton.setEnabled(automaticUpdateCheck);
		confirmUpdateInstallationRadioButton.setEnabled(automaticUpdateCheck);
		if (BackupR.getSettings().getBoolean(SettingsEnum.AUTOMATIC_UPDATE_INSTALLATION.toString())) {
			automaticUpdateInstallationRadioButton.setSelected(true);
		} else {
			confirmUpdateInstallationRadioButton.setSelected(true);
		}
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateOptionsButtonGroup = new javax.swing.ButtonGroup();
        automaticUpdateCheckCheckBox = new javax.swing.JCheckBox();
        automaticUpdateInstallationRadioButton = new javax.swing.JRadioButton();
        confirmUpdateInstallationRadioButton = new javax.swing.JRadioButton();

        automaticUpdateCheckCheckBox.setText("Automatically check for updates");
        automaticUpdateCheckCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automaticUpdateCheckCheckBoxActionPerformed(evt);
            }
        });

        updateOptionsButtonGroup.add(automaticUpdateInstallationRadioButton);
        automaticUpdateInstallationRadioButton.setText("Automatically install updates");
        automaticUpdateInstallationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                automaticUpdateInstallationRadioButtonActionPerformed(evt);
            }
        });

        updateOptionsButtonGroup.add(confirmUpdateInstallationRadioButton);
        confirmUpdateInstallationRadioButton.setText("Ask for confirm before installing update");
        confirmUpdateInstallationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmUpdateInstallationRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(automaticUpdateCheckCheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmUpdateInstallationRadioButton)
                            .addComponent(automaticUpdateInstallationRadioButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(automaticUpdateCheckCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(automaticUpdateInstallationRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmUpdateInstallationRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        automaticUpdateCheckCheckBox.setText(BackupR.getLang().get("automaticallyCheckForUpdates"));
        automaticUpdateInstallationRadioButton.setText(BackupR.getLang().get("automaticallyInstallUpdates"));
        confirmUpdateInstallationRadioButton.setText(BackupR.getLang().get("askForConfirmBeforeInstallingUpdate"));
    }// </editor-fold>//GEN-END:initComponents

    private void automaticUpdateCheckCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automaticUpdateCheckCheckBoxActionPerformed
		try {
			BackupR.getSettings().set(SettingsEnum.AUTOMATIC_UPDATE_CHECK.toString(), automaticUpdateCheckCheckBox.isSelected());
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_automaticUpdateCheckCheckBoxActionPerformed

    private void automaticUpdateInstallationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_automaticUpdateInstallationRadioButtonActionPerformed
		try {
			BackupR.getSettings().set(SettingsEnum.AUTOMATIC_UPDATE_INSTALLATION.toString(), true);
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_automaticUpdateInstallationRadioButtonActionPerformed

    private void confirmUpdateInstallationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmUpdateInstallationRadioButtonActionPerformed
		try {
			BackupR.getSettings().set(SettingsEnum.AUTOMATIC_UPDATE_INSTALLATION.toString(), false);
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_confirmUpdateInstallationRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox automaticUpdateCheckCheckBox;
    private javax.swing.JRadioButton automaticUpdateInstallationRadioButton;
    private javax.swing.JRadioButton confirmUpdateInstallationRadioButton;
    private javax.swing.ButtonGroup updateOptionsButtonGroup;
    // End of variables declaration//GEN-END:variables
}
