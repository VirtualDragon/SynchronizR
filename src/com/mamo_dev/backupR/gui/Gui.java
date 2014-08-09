package com.mamo_dev.backupR.gui;

import com.mamo_dev.backupR.Lang;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JProgressBar;

public class Gui extends javax.swing.JPanel {

	public Gui() {
		initComponents();
	}

	public void setEverythingEnabled(boolean enabled) {
		setEverythingEnabled(this, enabled);
	}

	private void setEverythingEnabled(Component component, boolean enabled) {
		if (component instanceof Container) {
			for (Component component_ : ((Container) component).getComponents()) {
				setEverythingEnabled(component_, enabled);
			}
		}
		component.setEnabled(enabled);
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        tabbedPanel = new javax.swing.JTabbedPane();
        progressBar = new javax.swing.JProgressBar();

        titleLabel.setText("<html><body><p style=\"font-size: 1.5em;\">BackupR</p></body></html>");

        tabbedPanel.addTab(Lang.get("backup"), new BackupGui(this));
        tabbedPanel.addTab(Lang.get("settings"), new SettingsGui());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPanel)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
