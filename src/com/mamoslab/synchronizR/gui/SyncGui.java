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
		syncFromTextField.setText(SynchronizR.getSettings().getString(SettingsEnum.FROM.toString()));
		syncToTextField.setText(SynchronizR.getSettings().getString(SettingsEnum.TO.toString()));
		advancedCheckBox.setSelected(SynchronizR.getSettings().getBoolean(SettingsEnum.ADVANCED_ENABLED.toString()));
		copyWholeDirectoryTreeCheckBox.setSelected(SynchronizR.getSettings().getBoolean(SettingsEnum.COPY_WHOLE_DIRECTORY_TREE.toString()));
		advancedSectionPanel.setVisible(SynchronizR.getSettings().getBoolean(SettingsEnum.ADVANCED_ENABLED.toString()));
		copyWholeDirectoryTreeCheckBox.setSelected(SynchronizR.getSettings().getBoolean(SettingsEnum.COPY_WHOLE_DIRECTORY_TREE.toString()));
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

        syncFromLabel = new javax.swing.JLabel();
        syncFromTextField = new javax.swing.JTextField();
        syncToLabel = new javax.swing.JLabel();
        syncToTextField = new javax.swing.JTextField();
        swapFromToButton = new javax.swing.JButton();
        advancedCheckBox = new javax.swing.JCheckBox();
        advancedSectionPanel = new javax.swing.JPanel();
        copyWholeDirectoryTreeCheckBox = new javax.swing.JCheckBox();
        copyOnlyNewerFilesCheckBox = new javax.swing.JCheckBox();
        overrideCheckBox = new javax.swing.JCheckBox();
        mirrorCopyCheckBox = new javax.swing.JCheckBox();
        syncButton = new javax.swing.JButton();
        statusScrollPaneContainer = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();

        syncFromLabel.setText("Sync from");

        syncFromTextField.setEditable(false);
        syncFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                syncFromTextFieldMousePressed(evt);
            }
        });

        syncToLabel.setText("Sync to");

        syncToTextField.setEditable(false);
        syncToTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                syncToTextFieldMousePressed(evt);
            }
        });

        swapFromToButton.setText("↕ Swap");
        swapFromToButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swapFromToButtonActionPerformed(evt);
            }
        });

        advancedCheckBox.setText("Advanced");
        advancedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedCheckBoxActionPerformed(evt);
            }
        });

        copyWholeDirectoryTreeCheckBox.setText("Copy whole directory tree");
        copyWholeDirectoryTreeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyWholeDirectoryTreeCheckBoxActionPerformed(evt);
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
                    .addComponent(copyWholeDirectoryTreeCheckBox)
                    .addComponent(copyOnlyNewerFilesCheckBox)
                    .addComponent(overrideCheckBox)
                    .addComponent(mirrorCopyCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        advancedSectionPanelLayout.setVerticalGroup(
            advancedSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advancedSectionPanelLayout.createSequentialGroup()
                .addComponent(copyWholeDirectoryTreeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyOnlyNewerFilesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overrideCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mirrorCopyCheckBox))
        );

        copyWholeDirectoryTreeCheckBox.setText(SynchronizR.getLang().get("copyWholeDirectoryTree"));
        copyWholeDirectoryTreeCheckBox.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("copyWholeDirectoryTreeTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        copyOnlyNewerFilesCheckBox.setText(SynchronizR.getLang().get("copyOnlyNewerFiles"));
        copyOnlyNewerFilesCheckBox.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("copyOnlyNewerFilesTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        overrideCheckBox.setText(SynchronizR.getLang().get("overrideIfNecessary"));
        overrideCheckBox.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("overrideIfNecessaryTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        mirrorCopyCheckBox.setText(SynchronizR.getLang().get("mirrorCopy"));
        mirrorCopyCheckBox.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("mirrorCopyTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");

        advancedSectionPanel.setVisible(false);

        syncButton.setText("Synchronize!");
        syncButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syncButtonActionPerformed(evt);
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
                                    .addComponent(syncFromLabel)
                                    .addComponent(syncToLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(syncFromTextField)
                                    .addComponent(syncToTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(swapFromToButton))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(advancedSectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(syncButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(syncFromLabel)
                            .addComponent(syncFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(syncToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(syncToLabel)))
                    .addComponent(swapFromToButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advancedCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(advancedSectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(syncButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusScrollPaneContainer)
                .addContainerGap())
        );

        syncFromLabel.setText(SynchronizR.getLang().get("syncFrom"));
        syncFromLabel.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("syncFromTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        syncFromTextField.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("syncFromTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        syncToLabel.setText(SynchronizR.getLang().get("syncTo"));
        syncToLabel.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("syncToTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        syncToTextField.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("syncToTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        swapFromToButton.setText(SynchronizR.getLang().get("swap"));
        swapFromToButton.setToolTipText("<html><body><p>" + StringUtils.autoReturn(SynchronizR.getLang().get("swapTooltip"), 100).replaceAll("\n", "<br />") + "</p></body></html>");
        advancedCheckBox.setText(SynchronizR.getLang().get("advanced"));
        syncButton.setText(SynchronizR.getLang().get("synchronize2"));
    }// </editor-fold>//GEN-END:initComponents

    private void syncFromTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_syncFromTextFieldMousePressed
		if (!syncFromTextField.isEnabled()) {
			return;
		}

		JFileChooser fileChooser = new JFileChooser(syncFromTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				SynchronizR.getSettings().set(SettingsEnum.FROM.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {
			}
			prefUpdate();
		}
    }//GEN-LAST:event_syncFromTextFieldMousePressed

    private void advancedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedCheckBoxActionPerformed
		advancedSectionPanel.setVisible(advancedCheckBox.isSelected());
		try {
			SynchronizR.getSettings().set(SettingsEnum.ADVANCED_ENABLED.toString(), advancedCheckBox.isSelected());
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_advancedCheckBoxActionPerformed

    private void syncToTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_syncToTextFieldMousePressed
		if (!syncToTextField.isEnabled()) {
			return;
		}

		JFileChooser fileChooser = new JFileChooser(syncToTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				SynchronizR.getSettings().set(SettingsEnum.TO.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {
			}
			prefUpdate();
		}
    }//GEN-LAST:event_syncToTextFieldMousePressed

    private void syncButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syncButtonActionPerformed
		if (!backingUp && !cancellingBackup) {
			if (syncFromTextField.getText().isEmpty() || syncToTextField.getText().isEmpty()) {
				JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("fillOutAllTheFields"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				return;
			}

			final File from = new File(syncFromTextField.getText());

			if (!from.exists()) {
				JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("syncFromFolderDoesntExist"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				return;
			} else if (!from.isDirectory()) {
				JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("syncFromIsntDir"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				return;
			}

			final File to = new File(syncToTextField.getText());

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
					syncButton.setText(SynchronizR.getLang().get("cancel"));
					GuiUtils.setEverythingEnabled(syncButton, true);
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
					if (SyncGui.this.copyWholeDirectoryTreeCheckBox.isSelected()) {
						if (System.getProperty("os.name").toLowerCase().contains("win")) {
							to_ = new File(to_, from.toPath().getRoot().toString().replace(":", ""));
						}
						backup = new TreeCopier(SynchronizR.getLang(), from, to_, from.toPath().getRoot().toFile(), options.toArray(new TreeCopyOption[options.size()]));
					} else {
						backup = new TreeCopier(SynchronizR.getLang(), from, to_, from, options.toArray(new TreeCopyOption[options.size()]));
					}
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
					syncButton.setText(SynchronizR.getLang().get("synchronize2"));
					GuiUtils.setEverythingEnabled(gui, true);
					backingUp = false;
					cancellingBackup = false;
				}
			}).start();
		}

		if (backingUp && !cancellingBackup) {
			cancellingBackup = true;
			GuiUtils.setEverythingEnabled(syncButton, false);
			gui.getProgressBar().setString("");
			gui.getProgressBar().setIndeterminate(true);
			backup.cancel();
		}
    }//GEN-LAST:event_syncButtonActionPerformed

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
		prefUpdate();
    }//GEN-LAST:event_overrideCheckBoxActionPerformed

    private void mirrorCopyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirrorCopyCheckBoxActionPerformed
		try {
			SynchronizR.getSettings().set(SettingsEnum.MIRROR_PURGE.toString(), mirrorCopyCheckBox.isSelected());
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_mirrorCopyCheckBoxActionPerformed

    private void swapFromToButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapFromToButtonActionPerformed
		if (syncFromTextField.getText().isEmpty() || syncToTextField.getText().isEmpty()) {
			JOptionPane.showOptionDialog(this, SynchronizR.getLang().get("fillOutAllTheFields"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
			return;
		}

		String temp = syncFromTextField.getText();
		try {
			SynchronizR.getSettings().set(SettingsEnum.FROM.toString(), syncToTextField.getText());
			SynchronizR.getSettings().set(SettingsEnum.TO.toString(), temp);
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_swapFromToButtonActionPerformed

    private void copyWholeDirectoryTreeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyWholeDirectoryTreeCheckBoxActionPerformed
		try {
			SynchronizR.getSettings().set(SettingsEnum.COPY_WHOLE_DIRECTORY_TREE.toString(), copyWholeDirectoryTreeCheckBox.isSelected());
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_copyWholeDirectoryTreeCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox advancedCheckBox;
    private javax.swing.JPanel advancedSectionPanel;
    private javax.swing.JCheckBox copyOnlyNewerFilesCheckBox;
    private javax.swing.JCheckBox copyWholeDirectoryTreeCheckBox;
    private javax.swing.JCheckBox mirrorCopyCheckBox;
    private javax.swing.JCheckBox overrideCheckBox;
    private javax.swing.JScrollPane statusScrollPaneContainer;
    private javax.swing.JTextArea statusTextArea;
    private javax.swing.JButton swapFromToButton;
    private javax.swing.JButton syncButton;
    private javax.swing.JLabel syncFromLabel;
    private javax.swing.JTextField syncFromTextField;
    private javax.swing.JLabel syncToLabel;
    private javax.swing.JTextField syncToTextField;
    // End of variables declaration//GEN-END:variables
}
