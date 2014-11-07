
/*
 BackupR
 Copyright (C) 2014 Matteo Morena

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 */
package com.mamoslab.synchronizR.gui;

import com.mamoslab.synchronizR.SynchronizR;
import com.mamoslab.synchronizR.SettingsEnum;
import com.mamoslab.synchronizR.TreeCopier;
import com.mamoslab.synchronizR.TreeCopier.TreeCopyEvent;
import com.mamoslab.synchronizR.TreeCopier.TreeCopyOption;
import com.mamoslab.utils.FileUtils;
import com.mamoslab.utils.GuiUtils;
import com.mamoslab.utils.StringUtils;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

public class SyncGui extends javax.swing.JPanel {

	private final Gui gui;

	private boolean backingUp, cancellingBackup;
	private TreeCopier backup;

	public SyncGui(Gui gui) {
		this.gui = gui;

		initComponents();
		prefUpdate();
	}

	private void prefUpdate() {
		backupFromTextField.setText(SynchronizR.getSettings().getString(SettingsEnum.FROM.toString()));
		backupToTextField.setText(SynchronizR.getSettings().getString(SettingsEnum.TO.toString()));
		advancedCheckBox.setSelected(SynchronizR.getSettings().getBoolean(SettingsEnum.ADVANCED_ENABLED.toString()));
		advancedSectionPanel.setVisible(advancedCheckBox.isSelected());
		copyOnlyNewerFilesCheckBox.setSelected(SynchronizR.getSettings().getBoolean(SettingsEnum.COPY_ONLY_NEWER_FILES.toString()));
		overrideCheckBox.setSelected(SynchronizR.getSettings().getBoolean(SettingsEnum.OVERRIDE_IF_NECESSARY.toString()));
		mirrorCopyCheckBox.setSelected(SynchronizR.getSettings().getBoolean(SettingsEnum.MIRROR_PURGE.toString()));
	}

	public boolean isBackingUp() {
		return backingUp;
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backupFromLabel = new javax.swing.JLabel();
        backupFromTextField = new javax.swing.JTextField();
        backupToLabel = new javax.swing.JLabel();
        backupToTextField = new javax.swing.JTextField();
        advancedCheckBox = new javax.swing.JCheckBox();
        advancedSectionPanel = new javax.swing.JPanel();
        copyOnlyNewerFilesCheckBox = new javax.swing.JCheckBox();
        overrideCheckBox = new javax.swing.JCheckBox();
        mirrorCopyCheckBox = new javax.swing.JCheckBox();
        backupButton = new javax.swing.JButton();
        statusScrollPaneContainer = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();

        backupFromLabel.setText("Sync from");

        backupFromTextField.setEditable(false);
        backupFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backupFromTextFieldMousePressed(evt);
            }
        });

        backupToLabel.setText("Sync to");

        backupToTextField.setEditable(false);
        backupToTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backupToTextFieldMousePressed(evt);
            }
        });

        advancedCheckBox.setText("Advanced");
        advancedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedCheckBoxActionPerformed(evt);
            }
        });

        copyOnlyNewerFilesCheckBox.setText("Copy only newer files");
        copyOnlyNewerFilesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyOnlyNewerFilesCheckBoxActionPerformed(evt);
            }
        });

        overrideCheckBox.setText("Override if necessary");
        overrideCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overrideCheckBoxActionPerformed(evt);
            }
        });

        mirrorCopyCheckBox.setText("Mirror copy");
        mirrorCopyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mirrorCopyCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout advancedSectionPanelLayout = new javax.swing.GroupLayout(advancedSectionPanel);
        advancedSectionPanel.setLayout(advancedSectionPanelLayout);
        advancedSectionPanelLayout.setHorizontalGroup(
            advancedSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advancedSectionPanelLayout.createSequentialGroup()
                .addGroup(advancedSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(copyOnlyNewerFilesCheckBox)
                    .addComponent(overrideCheckBox)
                    .addComponent(mirrorCopyCheckBox))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        advancedSectionPanelLayout.setVerticalGroup(
            advancedSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advancedSectionPanelLayout.createSequentialGroup()
                .addComponent(copyOnlyNewerFilesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overrideCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mirrorCopyCheckBox))
        );

        copyOnlyNewerFilesCheckBox.setText(com.mamoslab.synchronizR.SynchronizR.getLang().get("copyOnlyNewerFiles"));
        copyOnlyNewerFilesCheckBox.setToolTipText("<html><body><p>" + StringUtils.autoReturn(com.mamoslab.synchronizR.SynchronizR.getLang().get("copyOnlyNewerFilesTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        overrideCheckBox.setText(com.mamoslab.synchronizR.SynchronizR.getLang().get("overrideIfNecessary"));
        overrideCheckBox.setToolTipText("<html><body><p>" + StringUtils.autoReturn(com.mamoslab.synchronizR.SynchronizR.getLang().get("overrideIfNecessaryTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        mirrorCopyCheckBox.setText(com.mamoslab.synchronizR.SynchronizR.getLang().get("mirrorCopy"));
        mirrorCopyCheckBox.setToolTipText("<html><body><p>" + StringUtils.autoReturn(com.mamoslab.synchronizR.SynchronizR.getLang().get("mirrorCopyTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");

        advancedSectionPanel.setVisible(false);

        backupButton.setText("Synchronize!");
        backupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupButtonActionPerformed(evt);
            }
        });

        statusScrollPaneContainer.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        statusTextArea.setEditable(false);
        ((DefaultCaret) statusTextArea.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        statusScrollPaneContainer.setViewportView(statusTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backupButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statusScrollPaneContainer))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(advancedCheckBox)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backupFromLabel)
                                    .addComponent(backupToLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backupToTextField)
                                    .addComponent(backupFromTextField)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(advancedSectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backupFromLabel)
                    .addComponent(backupFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backupToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backupToLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advancedCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advancedSectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusScrollPaneContainer)
                .addContainerGap())
        );

        backupFromLabel.setText(com.mamoslab.synchronizR.SynchronizR.getLang().get("syncFrom"));
        backupFromLabel.setToolTipText("<html><body><p>" + StringUtils.autoReturn(com.mamoslab.synchronizR.SynchronizR.getLang().get("syncFromTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        backupFromTextField.setToolTipText("<html><body><p>" + StringUtils.autoReturn(com.mamoslab.synchronizR.SynchronizR.getLang().get("syncFromTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        backupToLabel.setText(com.mamoslab.synchronizR.SynchronizR.getLang().get("syncTo"));
        backupToLabel.setToolTipText("<html><body><p>" + StringUtils.autoReturn(com.mamoslab.synchronizR.SynchronizR.getLang().get("syncToTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        backupToTextField.setToolTipText("<html><body><p>" + StringUtils.autoReturn(com.mamoslab.synchronizR.SynchronizR.getLang().get("syncToTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        advancedCheckBox.setText(com.mamoslab.synchronizR.SynchronizR.getLang().get("advanced"));
        backupButton.setText(com.mamoslab.synchronizR.SynchronizR.getLang().get("synchronize2"));
    }// </editor-fold>//GEN-END:initComponents

    private void backupFromTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupFromTextFieldMousePressed
		if (!backupFromTextField.isEnabled()) {
			return;
		}

		JFileChooser fileChooser = new JFileChooser(backupFromTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				SynchronizR.getSettings().set(SettingsEnum.FROM.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {
			}
			prefUpdate();
		}
    }//GEN-LAST:event_backupFromTextFieldMousePressed

    private void advancedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedCheckBoxActionPerformed
		advancedSectionPanel.setVisible(advancedCheckBox.isSelected());
		try {
			SynchronizR.getSettings().set(SettingsEnum.ADVANCED_ENABLED.toString(), advancedCheckBox.isSelected());
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_advancedCheckBoxActionPerformed

    private void backupToTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupToTextFieldMousePressed
		if (!backupToTextField.isEnabled()) {
			return;
		}

		JFileChooser fileChooser = new JFileChooser(backupToTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				SynchronizR.getSettings().set(SettingsEnum.TO.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {
			}
			prefUpdate();
		}
    }//GEN-LAST:event_backupToTextFieldMousePressed

    private void backupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupButtonActionPerformed
		if (!backingUp && !cancellingBackup) {
			if (backupFromTextField.getText().isEmpty() || backupToTextField.getText().isEmpty()) {
				JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("fillOutAllTheFields"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				return;
			}

			final File from = new File(backupFromTextField.getText());

			if (!from.exists()) {
				JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("syncFromFolderDoesntExist"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				return;
			} else if (!from.isDirectory()) {
				JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("syncFromIsntDir"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				return;
			}

			final File to = new File(backupToTextField.getText());

			if (to.exists() && to.isFile()) {
				JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("syncToIsFile"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				return;
			}
			if (FileUtils.dirContainsFile(from, to) || FileUtils.dirContainsFile(to, from)) {
				JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("dirInceptionErr"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				return;
			}

			new Thread(new Runnable() {
				@Override
				public void run() {
					backingUp = true;
					GuiUtils.setEverythingEnabled(gui, false);
					backupButton.setText(SynchronizR.getLang().get("cancel"));
					GuiUtils.setEverythingEnabled(backupButton, true);
					GuiUtils.setEverythingEnabled(statusScrollPaneContainer, true);
					GuiUtils.setEverythingEnabled(gui.getProgressBar(), true);
					SyncGui.this.statusTextArea.setText(null);
					gui.getProgressBar().setIndeterminate(true);
					ArrayList<TreeCopyOption> options = new ArrayList<TreeCopyOption>();
					if (SyncGui.this.copyOnlyNewerFilesCheckBox.isSelected()) {
						options.add(TreeCopyOption.COPY_ONLY_NEWER_FILES);
					}
					if (SyncGui.this.overrideCheckBox.isSelected()) {
						options.add(TreeCopyOption.OVERRIDE_IF_NECESSARY);
					}
					if (SyncGui.this.mirrorCopyCheckBox.isSelected()) {
						options.add(TreeCopyOption.MIRROR_PURGE);
					}
					File to_ = to;
					try {
						to_ = new File(to_, InetAddress.getLocalHost().getHostName());
					} catch (UnknownHostException ex) {
					}
					if (System.getProperty("os.name").toLowerCase().contains("win")) {
						to_ = new File(to_, from.toPath().getRoot().toString().replace(":", ""));
					}
					backup = new TreeCopier(SynchronizR.getLang(), from, to_, from.toPath().getRoot().toFile(), options.toArray(new TreeCopyOption[options.size()]));
					backup.addTreeCopyEventListener(new TreeCopier.TreeCopyEventListener() {
						@Override
						public void onEvent(TreeCopyEvent event) {
							if (event instanceof TreeCopier.TreeCopyLogEvent) {
								TreeCopier.TreeCopyLogEvent event_ = (TreeCopier.TreeCopyLogEvent) event;
								if (!event_.isLogAppended() && !SyncGui.this.statusTextArea.getText().isEmpty()) {
									SyncGui.this.statusTextArea.append("\n");
								}
								SyncGui.this.statusTextArea.append(event_.getLog());
							}
							gui.getProgressBar().setValue((int) (100D * event.getFilesProcessed() / event.getFiles()));
						}
					});
					gui.getProgressBar().setIndeterminate(false);
					gui.getProgressBar().setValue(0);
					gui.getProgressBar().setString(null);
					backup.copyTree();
					gui.getProgressBar().setIndeterminate(false);
					gui.getProgressBar().setString(null);
					gui.getProgressBar().setValue(100);
					if (!cancellingBackup) {
						JOptionPane.showOptionDialog(SyncGui.this, SynchronizR.getLang().get("done2"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
					}
					gui.getProgressBar().setValue(0);
					gui.getProgressBar().setString("");
					backupButton.setText(SynchronizR.getLang().get("synchronize2"));
					GuiUtils.setEverythingEnabled(gui, true);
					backingUp = false;
					cancellingBackup = false;
				}
			}).start();
		}

		if (backingUp && !cancellingBackup) {
			cancellingBackup = true;
			GuiUtils.setEverythingEnabled(backupButton, false);
			gui.getProgressBar().setString("");
			gui.getProgressBar().setIndeterminate(true);
			backup.cancel();
		}
    }//GEN-LAST:event_backupButtonActionPerformed

    private void copyOnlyNewerFilesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyOnlyNewerFilesCheckBoxActionPerformed
		try {
			SynchronizR.getSettings().set(SettingsEnum.COPY_ONLY_NEWER_FILES.toString(), copyOnlyNewerFilesCheckBox.isSelected());
		} catch (IOException ex) {
		}
    }//GEN-LAST:event_copyOnlyNewerFilesCheckBoxActionPerformed

    private void overrideCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overrideCheckBoxActionPerformed
		try {
			SynchronizR.getSettings().set(SettingsEnum.OVERRIDE_IF_NECESSARY.toString(), overrideCheckBox.isSelected());
		} catch (IOException ex) {
		}
    }//GEN-LAST:event_overrideCheckBoxActionPerformed

    private void mirrorCopyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirrorCopyCheckBoxActionPerformed
		try {
			SynchronizR.getSettings().set(SettingsEnum.MIRROR_PURGE.toString(), mirrorCopyCheckBox.isSelected());
		} catch (IOException ex) {
		}
    }//GEN-LAST:event_mirrorCopyCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox advancedCheckBox;
    private javax.swing.JPanel advancedSectionPanel;
    private javax.swing.JButton backupButton;
    private javax.swing.JLabel backupFromLabel;
    private javax.swing.JTextField backupFromTextField;
    private javax.swing.JLabel backupToLabel;
    private javax.swing.JTextField backupToTextField;
    private javax.swing.JCheckBox copyOnlyNewerFilesCheckBox;
    private javax.swing.JCheckBox mirrorCopyCheckBox;
    private javax.swing.JCheckBox overrideCheckBox;
    private javax.swing.JScrollPane statusScrollPaneContainer;
    private javax.swing.JTextArea statusTextArea;
    // End of variables declaration//GEN-END:variables
}
