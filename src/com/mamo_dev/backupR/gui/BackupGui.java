package com.mamo_dev.backupR.gui;

import com.mamo_dev.backupR.FileUtils;
import com.mamo_dev.backupR.Main;
import com.mamo_dev.backupR.PropertyEnum;
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

	public BackupGui(Gui gui) {
		this.gui = gui;

		initComponents();
		prefUpdate();
	}

	private void prefUpdate() {
		backupFromTextField.setText(Main.getProperties().getString(PropertyEnum.FROM.toString()));
		backupToTextField.setText(Main.getProperties().getString(PropertyEnum.TO.toString()));
		advancedCheckBox.setSelected(Main.getProperties().getBoolean(PropertyEnum.ADVANCED_ENABLED.toString()));
		advancedSectionPanel.setVisible(advancedCheckBox.isSelected());
		copyOnlyNewerFilesCheckBox.setSelected(Main.getProperties().getBoolean(PropertyEnum.COPY_ONLY_NEWER_FILES.toString()));
		overrideCheckBox.setSelected(Main.getProperties().getBoolean(PropertyEnum.OVERRIDE_IF_NECESSARY.toString()));
		mirrorCopyCheckBox.setSelected(Main.getProperties().getBoolean(PropertyEnum.MIRROR_PURGE.toString()));
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
        backItUpButton = new javax.swing.JButton();
        statusScrollPaneContainer = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();

        backupFromLabel.setText("Backup from");

        backupFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backupFromTextFieldMousePressed(evt);
            }
        });
        backupFromTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backupFromTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                backupFromTextFieldKeyTyped(evt);
            }
        });

        backupToLabel.setText("Backup to");

        backupToTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backupToTextFieldMousePressed(evt);
            }
        });
        backupToTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backupToTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                backupToTextFieldKeyTyped(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        advancedSectionPanel.setVisible(false);

        backItUpButton.setText("Back it up!");
        backItUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backItUpButtonActionPerformed(evt);
            }
        });

        statusScrollPaneContainer.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        ((DefaultCaret) statusTextArea.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        statusTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                statusTextAreaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                statusTextAreaKeyTyped(evt);
            }
        });
        statusScrollPaneContainer.setViewportView(statusTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(21, 21, 21)
                        .addComponent(advancedSectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(advancedCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backItUpButton)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(backItUpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusScrollPaneContainer)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backupFromTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupFromTextFieldMousePressed
		JFileChooser fileChooser = new JFileChooser(backupFromTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				Main.getProperties().set(PropertyEnum.FROM.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {}
			prefUpdate();
		}
    }//GEN-LAST:event_backupFromTextFieldMousePressed

    private void backupFromTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backupFromTextFieldKeyPressed
		evt.consume();
    }//GEN-LAST:event_backupFromTextFieldKeyPressed

    private void backupFromTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backupFromTextFieldKeyTyped
		evt.consume();
    }//GEN-LAST:event_backupFromTextFieldKeyTyped

    private void advancedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedCheckBoxActionPerformed
		advancedSectionPanel.setVisible(advancedCheckBox.isSelected());
		try {
			Main.getProperties().set(PropertyEnum.ADVANCED_ENABLED.toString(), advancedCheckBox.isSelected());
		} catch (IOException ex) {}
		prefUpdate();
    }//GEN-LAST:event_advancedCheckBoxActionPerformed

    private void backupToTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupToTextFieldMousePressed
		JFileChooser fileChooser = new JFileChooser(backupToTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				Main.getProperties().set(PropertyEnum.TO.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {}
			prefUpdate();
		}
    }//GEN-LAST:event_backupToTextFieldMousePressed

    private void backupToTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backupToTextFieldKeyPressed
		evt.consume();
    }//GEN-LAST:event_backupToTextFieldKeyPressed

    private void backupToTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backupToTextFieldKeyTyped
		evt.consume();
    }//GEN-LAST:event_backupToTextFieldKeyTyped

    private void backItUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backItUpButtonActionPerformed
		if (!backupFromTextField.getText().isEmpty() && !backupToTextField.getText().isEmpty()) {
			final File from = new File(backupFromTextField.getText());
			final File to = new File(backupToTextField.getText());

			if (!FileUtils.dirContainsFile(from, to) && !FileUtils.dirContainsFile(to, from)) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						gui.getTabbedPane().setEnabled(false);
						BackupGui.this.statusTextArea.setText(null);
						BackupGui.this.backupFromLabel.setEnabled(false);
						BackupGui.this.backupFromTextField.setEnabled(false);
						BackupGui.this.advancedCheckBox.setEnabled(false);
						BackupGui.this.backupToLabel.setEnabled(false);
						BackupGui.this.backupToTextField.setEnabled(false);
						BackupGui.this.copyOnlyNewerFilesCheckBox.setEnabled(false);
						BackupGui.this.overrideCheckBox.setEnabled(false);
						BackupGui.this.mirrorCopyCheckBox.setEnabled(false);
						BackupGui.this.backItUpButton.setEnabled(false);
						gui.getStatusProgressBar().setEnabled(true);
						gui.getStatusProgressBar().setIndeterminate(true);
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
						TreeCopier treeCopier = new TreeCopier(from, to, from.toPath().getRoot().toFile(), options.toArray(new TreeCopyOption[options.size()]));
						treeCopier.addTreeCopyEventListener(new TreeCopier.TreeCopyEventListener() {
							@Override
							public void onEvent(TreeCopyEvent event) {
								if (event instanceof TreeCopier.TreeCopyLogEvent) {
									TreeCopier.TreeCopyLogEvent event_ = (TreeCopier.TreeCopyLogEvent) event;
									if (!event_.isLogAppended() && !BackupGui.this.statusTextArea.getText().isEmpty()) {
										BackupGui.this.statusTextArea.append("\n");
									}
									BackupGui.this.statusTextArea.append(event_.getLog());
								}
								gui.getStatusProgressBar().setValue((int) (100D * event.getFilesProcessed() / event.getFiles()));
							}
						});
						gui.getStatusProgressBar().setIndeterminate(false);
						gui.getStatusProgressBar().setValue(0);
						gui.getStatusProgressBar().setString(null);
						treeCopier.copyTree();
						gui.getStatusProgressBar().setValue(100);
						JOptionPane.showMessageDialog(BackupGui.this, "Done!", "BackupR", JOptionPane.INFORMATION_MESSAGE);
						gui.getStatusProgressBar().setString("");
						gui.getStatusProgressBar().setEnabled(false);
						BackupGui.this.backupFromLabel.setEnabled(true);
						BackupGui.this.backupFromTextField.setEnabled(true);
						BackupGui.this.advancedCheckBox.setEnabled(true);
						BackupGui.this.backupToLabel.setEnabled(true);
						BackupGui.this.backupToTextField.setEnabled(true);
						BackupGui.this.copyOnlyNewerFilesCheckBox.setEnabled(true);
						BackupGui.this.overrideCheckBox.setEnabled(true);
						BackupGui.this.mirrorCopyCheckBox.setEnabled(true);
						BackupGui.this.backItUpButton.setEnabled(true);
						gui.getTabbedPane().setEnabled(true);
					}
				}).start();
			} else {
				if (!advancedCheckBox.isSelected()) {
					JOptionPane.showMessageDialog(this, "Please select a directory not contained in- and which doesn't contain \"" + backupToTextField.getText() + "\"!", null, JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "The two directories cannot contain one each other!", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please fill out all the requested fields.", null, JOptionPane.WARNING_MESSAGE);
		}
    }//GEN-LAST:event_backItUpButtonActionPerformed

    private void statusTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_statusTextAreaKeyPressed
		evt.consume();
    }//GEN-LAST:event_statusTextAreaKeyPressed

    private void statusTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_statusTextAreaKeyTyped
		evt.consume();
    }//GEN-LAST:event_statusTextAreaKeyTyped

    private void copyOnlyNewerFilesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyOnlyNewerFilesCheckBoxActionPerformed
		try {
			Main.getProperties().set(PropertyEnum.COPY_ONLY_NEWER_FILES.toString(), copyOnlyNewerFilesCheckBox.isSelected());
		} catch (IOException ex) {}
    }//GEN-LAST:event_copyOnlyNewerFilesCheckBoxActionPerformed

    private void overrideCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overrideCheckBoxActionPerformed
		try {
			Main.getProperties().set(PropertyEnum.OVERRIDE_IF_NECESSARY.toString(), overrideCheckBox.isSelected());
		} catch (IOException ex) {}
    }//GEN-LAST:event_overrideCheckBoxActionPerformed

    private void mirrorCopyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirrorCopyCheckBoxActionPerformed
		try {
			Main.getProperties().set(PropertyEnum.MIRROR_PURGE.toString(), mirrorCopyCheckBox.isSelected());
		} catch (IOException ex) {}
    }//GEN-LAST:event_mirrorCopyCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox advancedCheckBox;
    private javax.swing.JPanel advancedSectionPanel;
    private javax.swing.JButton backItUpButton;
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
