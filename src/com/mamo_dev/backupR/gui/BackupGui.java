package com.mamo_dev.backupR.gui;

import com.mamo_dev.backupR.FileUtils;
import com.mamo_dev.backupR.BackupR;
import com.mamo_dev.backupR.SettingsEnum;
import com.mamo_dev.backupR.TreeCopier;
import com.mamo_dev.backupR.TreeCopier.TreeCopyEvent;
import com.mamo_dev.backupR.TreeCopier.TreeCopyOption;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

public class BackupGui extends javax.swing.JPanel {

	private final Gui gui;

	private boolean backingUp, cancellingBackup;
	private TreeCopier backup;

	public BackupGui(Gui gui) {
		this.gui = gui;

		initComponents();
		prefUpdate();
	}

	private void prefUpdate() {
		backupFromTextField.setText(BackupR.getSettings().getString(SettingsEnum.FROM.toString()));
		backupToTextField.setText(BackupR.getSettings().getString(SettingsEnum.TO.toString()));
		advancedCheckBox.setSelected(BackupR.getSettings().getBoolean(SettingsEnum.ADVANCED_ENABLED.toString()));
		advancedSectionPanel.setVisible(advancedCheckBox.isSelected());
		copyOnlyNewerFilesCheckBox.setSelected(BackupR.getSettings().getBoolean(SettingsEnum.COPY_ONLY_NEWER_FILES.toString()));
		overrideCheckBox.setSelected(BackupR.getSettings().getBoolean(SettingsEnum.OVERRIDE_IF_NECESSARY.toString()));
		mirrorCopyCheckBox.setSelected(BackupR.getSettings().getBoolean(SettingsEnum.MIRROR_PURGE.toString()));
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

        backupFromLabel.setText("Backup from");

        backupFromTextField.setEditable(false);
        backupFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backupFromTextFieldMousePressed(evt);
            }
        });

        backupToLabel.setText("Backup to");

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

        copyOnlyNewerFilesCheckBox.setText(BackupR.getLang().get("copyOnlyNewerFiles"));
        copyOnlyNewerFilesCheckBox.setToolTipText(BackupR.getLang().get("copyOnlyNewerFilesTooltip"));
        overrideCheckBox.setText(BackupR.getLang().get("overrideIfNecessary"));
        overrideCheckBox.setToolTipText(BackupR.getLang().get("overrideIfNecessaryTooltip"));
        mirrorCopyCheckBox.setText(BackupR.getLang().get("mirrorCopy"));
        mirrorCopyCheckBox.setToolTipText(BackupR.getLang().get("mirrorCopyTooltip"));

        advancedSectionPanel.setVisible(false);

        backupButton.setText("Back it up!");
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusScrollPaneContainer)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backupFromLabel)
                                    .addComponent(backupToLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backupToTextField)
                                    .addComponent(backupFromTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(advancedCheckBox)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
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
                    .addComponent(backupToLabel)
                    .addComponent(backupToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        backupFromLabel.setText(BackupR.getLang().get("backupFrom"));
        backupFromLabel.setToolTipText(BackupR.getLang().get("backupFromTooltip"));
        backupFromTextField.setToolTipText(BackupR.getLang().get("backupFromTooltip"));
        backupToLabel.setText(BackupR.getLang().get("backupTo"));
        backupToLabel.setToolTipText(BackupR.getLang().get("backupToTooltip"));
        backupToTextField.setToolTipText(BackupR.getLang().get("backupToTooltip"));
        advancedCheckBox.setText(BackupR.getLang().get("advanced"));
        backupButton.setText(BackupR.getLang().get("backItUp"));
    }// </editor-fold>//GEN-END:initComponents

    private void backupFromTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupFromTextFieldMousePressed
		JFileChooser fileChooser = new JFileChooser(backupFromTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				BackupR.getSettings().set(SettingsEnum.FROM.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {
			}
			prefUpdate();
		}
    }//GEN-LAST:event_backupFromTextFieldMousePressed

    private void advancedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedCheckBoxActionPerformed
		advancedSectionPanel.setVisible(advancedCheckBox.isSelected());
		try {
			BackupR.getSettings().set(SettingsEnum.ADVANCED_ENABLED.toString(), advancedCheckBox.isSelected());
		} catch (IOException ex) {
		}
		prefUpdate();
    }//GEN-LAST:event_advancedCheckBoxActionPerformed

    private void backupToTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupToTextFieldMousePressed
		JFileChooser fileChooser = new JFileChooser(backupToTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				BackupR.getSettings().set(SettingsEnum.TO.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {
			}
			prefUpdate();
		}
    }//GEN-LAST:event_backupToTextFieldMousePressed

    private void backupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupButtonActionPerformed
		if (!backingUp && !cancellingBackup) {
			final File from = new File(backupFromTextField.getText());
			final File to = new File(backupToTextField.getText());

			if (!FileUtils.dirContainsFile(from, to) && !FileUtils.dirContainsFile(to, from)) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						backingUp = true;
						gui.setEverythingEnabled(false);
						backupButton.setText(BackupR.getLang().get("cancel"));
						backupButton.setEnabled(true);
						statusScrollPaneContainer.setEnabled(true);
						statusTextArea.setEnabled(true);
						BackupGui.this.statusTextArea.setText(null);
						gui.getProgressBar().setIndeterminate(true);
						ArrayList<TreeCopyOption> options = new ArrayList<>();
						if (BackupGui.this.copyOnlyNewerFilesCheckBox.isSelected()) {
							options.add(TreeCopyOption.COPY_ONLY_NEWER_FILES);
						}
						if (BackupGui.this.overrideCheckBox.isSelected()) {
							options.add(TreeCopyOption.OVERRIDE_IF_NECESSARY);
						}
						if (BackupGui.this.mirrorCopyCheckBox.isSelected()) {
							options.add(TreeCopyOption.MIRROR_PURGE);
						}
						backup = new TreeCopier(from, to, from.toPath().getRoot().toFile(), options.toArray(new TreeCopyOption[options.size()]));
						backup.addTreeCopyEventListener(new TreeCopier.TreeCopyEventListener() {
							@Override
							public void onEvent(TreeCopyEvent event) {
								if (event instanceof TreeCopier.TreeCopyLogEvent) {
									TreeCopier.TreeCopyLogEvent event_ = (TreeCopier.TreeCopyLogEvent) event;
									if (!event_.isLogAppended() && !BackupGui.this.statusTextArea.getText().isEmpty()) {
										BackupGui.this.statusTextArea.append("\n");
									}
									BackupGui.this.statusTextArea.append(event_.getLog());
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
							JOptionPane.showOptionDialog(BackupGui.this, BackupR.getLang().get("done2"), "BackupR", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{BackupR.getLang().get("ok2")}, null);
						}
						gui.getProgressBar().setValue(0);
						gui.getProgressBar().setString("");
						backupButton.setText(BackupR.getLang().get("backItUp"));
						gui.setEverythingEnabled(true);
						backingUp = false;
						cancellingBackup = false;
					}
				}).start();
			} else {
				JOptionPane.showOptionDialog(this, BackupR.getLang().get("dirInceptionErr"), "BackupR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{BackupR.getLang().get("ok2")}, null);
			}
		}
		
		if (backingUp && !cancellingBackup) {
			cancellingBackup = true;
			backupButton.setEnabled(false);
			gui.getProgressBar().setString("");
			gui.getProgressBar().setIndeterminate(true);
			backup.cancel();
		}
    }//GEN-LAST:event_backupButtonActionPerformed

    private void copyOnlyNewerFilesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyOnlyNewerFilesCheckBoxActionPerformed
		try {
			BackupR.getSettings().set(SettingsEnum.COPY_ONLY_NEWER_FILES.toString(), copyOnlyNewerFilesCheckBox.isSelected());
		} catch (IOException ex) {
		}
    }//GEN-LAST:event_copyOnlyNewerFilesCheckBoxActionPerformed

    private void overrideCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overrideCheckBoxActionPerformed
		try {
			BackupR.getSettings().set(SettingsEnum.OVERRIDE_IF_NECESSARY.toString(), overrideCheckBox.isSelected());
		} catch (IOException ex) {
		}
    }//GEN-LAST:event_overrideCheckBoxActionPerformed

    private void mirrorCopyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirrorCopyCheckBoxActionPerformed
		try {
			BackupR.getSettings().set(SettingsEnum.MIRROR_PURGE.toString(), mirrorCopyCheckBox.isSelected());
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
