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

public class RestoreGui extends javax.swing.JPanel {

	private final Gui gui;

	public RestoreGui(Gui gui) {
		this.gui = gui;

		initComponents();
		prefUpdate();
	}

	public void prefUpdate() {
		restoreFromTextField.setText(Main.getProperties().getString(PropertyEnum.TO.toString()));
		restoreToTextField.setText(Main.getProperties().getString(PropertyEnum.FROM.toString()));
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        restoreFromLabel = new javax.swing.JLabel();
        restoreFromTextField = new javax.swing.JTextField();
        advancedSectionPanel = new javax.swing.JPanel();
        restoreButton = new javax.swing.JButton();
        statusScrollPaneContainer = new javax.swing.JScrollPane();
        statusTextArea = new javax.swing.JTextArea();
        restoreToLabel = new javax.swing.JLabel();
        restoreToTextField = new javax.swing.JTextField();

        restoreFromLabel.setText("Restore from");

        restoreFromTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                restoreFromTextFieldMousePressed(evt);
            }
        });
        restoreFromTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                restoreFromTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                restoreFromTextFieldKeyTyped(evt);
            }
        });

        restoreButton.setText("Restore!");
        restoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout advancedSectionPanelLayout = new javax.swing.GroupLayout(advancedSectionPanel);
        advancedSectionPanel.setLayout(advancedSectionPanelLayout);
        advancedSectionPanelLayout.setHorizontalGroup(
            advancedSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(advancedSectionPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(restoreButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        advancedSectionPanelLayout.setVerticalGroup(
            advancedSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, advancedSectionPanelLayout.createSequentialGroup()
                .addComponent(restoreButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        advancedSectionPanel.setVisible(false);

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

        restoreToLabel.setText("Restore to");

        restoreToTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                restoreToTextFieldMousePressed(evt);
            }
        });
        restoreToTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                restoreToTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                restoreToTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusScrollPaneContainer)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(restoreFromLabel)
                                    .addComponent(restoreToLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(restoreFromTextField)
                                    .addComponent(restoreToTextField))))
                        .addContainerGap())
                    .addComponent(advancedSectionPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restoreFromLabel)
                    .addComponent(restoreFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(restoreToLabel)
                    .addComponent(restoreToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(advancedSectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusScrollPaneContainer)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void restoreFromTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreFromTextFieldMousePressed
		JFileChooser fileChooser = new JFileChooser(restoreFromTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				Main.getProperties().set(PropertyEnum.TO.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {}
			gui.prefUpdate();
		}
    }//GEN-LAST:event_restoreFromTextFieldMousePressed

    private void restoreFromTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_restoreFromTextFieldKeyPressed
		evt.consume();
    }//GEN-LAST:event_restoreFromTextFieldKeyPressed

    private void restoreFromTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_restoreFromTextFieldKeyTyped
		evt.consume();
    }//GEN-LAST:event_restoreFromTextFieldKeyTyped

    private void restoreToTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreToTextFieldMousePressed
		JFileChooser fileChooser = new JFileChooser(restoreToTextField.getText());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				Main.getProperties().set(PropertyEnum.FROM.toString(), fileChooser.getSelectedFile().getPath());
			} catch (IOException ex) {}
			gui.prefUpdate();
		}
    }//GEN-LAST:event_restoreToTextFieldMousePressed

    private void restoreToTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_restoreToTextFieldKeyPressed
		evt.consume();
    }//GEN-LAST:event_restoreToTextFieldKeyPressed

    private void restoreToTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_restoreToTextFieldKeyTyped
		evt.consume();
    }//GEN-LAST:event_restoreToTextFieldKeyTyped

    private void restoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreButtonActionPerformed
		if (!restoreFromTextField.getText().isEmpty() && !restoreToTextField.getText().isEmpty()) {
			final File from = new File(restoreFromTextField.getText());
			final File to = new File(restoreToTextField.getText());

			if (!FileUtils.dirContainsFile(from, to) && !FileUtils.dirContainsFile(to, from)) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						gui.getTabbedPane().setEnabled(false);
						RestoreGui.this.statusTextArea.setText(null);
						RestoreGui.this.restoreFromLabel.setEnabled(false);
						RestoreGui.this.restoreFromTextField.setEnabled(false);
						RestoreGui.this.restoreToLabel.setEnabled(false);
						RestoreGui.this.restoreToTextField.setEnabled(false);
						RestoreGui.this.restoreButton.setEnabled(false);
						gui.getStatusProgressBar().setEnabled(true);
						gui.getStatusProgressBar().setIndeterminate(true);
						ArrayList<TreeCopyOption> options = new ArrayList<>();
						options.add(TreeCopyOption.OVERRIDE_IF_NECESSARY);
						options.add(TreeCopyOption.MIRROR_PURGE);
						TreeCopier treeCopier = new TreeCopier(from, to, from.toPath().getRoot().toFile(), options.toArray(new TreeCopyOption[options.size()]));
						treeCopier.addTreeCopyEventListener(new TreeCopier.TreeCopyEventListener() {
							@Override
							public void onEvent(TreeCopyEvent event) {
								if (event instanceof TreeCopier.TreeCopyLogEvent) {
									TreeCopier.TreeCopyLogEvent event_ = (TreeCopier.TreeCopyLogEvent) event;
									if (!event_.isLogAppended() && !RestoreGui.this.statusTextArea.getText().isEmpty()) {
										RestoreGui.this.statusTextArea.append("\n");
									}
									RestoreGui.this.statusTextArea.append(event_.getLog());
								}
								gui.getStatusProgressBar().setValue((int) (100D * event.getFilesProcessed() / event.getFiles()));
							}
						});
						gui.getStatusProgressBar().setIndeterminate(false);
						gui.getStatusProgressBar().setValue(0);
						gui.getStatusProgressBar().setString(null);
						treeCopier.copyTree();
						gui.getStatusProgressBar().setValue(100);
						JOptionPane.showMessageDialog(RestoreGui.this, "Done!", "BackupR", JOptionPane.INFORMATION_MESSAGE);
						gui.getStatusProgressBar().setString("");
						gui.getStatusProgressBar().setEnabled(false);
						RestoreGui.this.restoreFromLabel.setEnabled(true);
						RestoreGui.this.restoreFromTextField.setEnabled(true);
						RestoreGui.this.restoreToLabel.setEnabled(true);
						RestoreGui.this.restoreToTextField.setEnabled(true);
						RestoreGui.this.restoreButton.setEnabled(true);
						gui.getTabbedPane().setEnabled(true);
					}
				}).start();
			} else {
				JOptionPane.showMessageDialog(this, "The two directories cannot contain one each other!", null, JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Please fill out all the requested fields.", null, JOptionPane.WARNING_MESSAGE);
		}
    }//GEN-LAST:event_restoreButtonActionPerformed

    private void statusTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_statusTextAreaKeyPressed
		evt.consume();
    }//GEN-LAST:event_statusTextAreaKeyPressed

    private void statusTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_statusTextAreaKeyTyped
		evt.consume();
    }//GEN-LAST:event_statusTextAreaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel advancedSectionPanel;
    private javax.swing.JButton restoreButton;
    private javax.swing.JLabel restoreFromLabel;
    private javax.swing.JTextField restoreFromTextField;
    private javax.swing.JLabel restoreToLabel;
    private javax.swing.JTextField restoreToTextField;
    private javax.swing.JScrollPane statusScrollPaneContainer;
    private javax.swing.JTextArea statusTextArea;
    // End of variables declaration//GEN-END:variables
}
