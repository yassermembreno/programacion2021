/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import ni.uni.edu.programacion.views.FrmTreeDemo;

/**
 *
 * @author Sistemas-05
 */
public class TreeDemoController {

    private FrmTreeDemo frmTreeDemo;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;

    public TreeDemoController(FrmTreeDemo frmTreeDemo) {
        this.frmTreeDemo = frmTreeDemo;
        initComponent();
    }

    public void initComponent() {
        root = new DefaultMutableTreeNode("Accounting");
        treeModel = new DefaultTreeModel(root);

        frmTreeDemo.getTreeAccount().setModel(treeModel);

        frmTreeDemo.getBtnAdd().addActionListener((e) -> {
            btnAddActionPerformed(e);
        });

        frmTreeDemo.getBtnRemove().addActionListener((e) -> {
            btnRemoveActionPerformed(e);
        });
        
        frmTreeDemo.getTreeAccount().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                treeAccountMouseClicked(e);
            }
        });

    }

    public void btnAddActionPerformed(ActionEvent e) {
        TreePath treePath = frmTreeDemo.getTreeAccount().getSelectionPath();
        if (treePath == null) {
            return;
        }

        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) treePath.getLastPathComponent();

        String accountName = JOptionPane.showInputDialog(null,
                "Account Name:", "Input Dialog",
                JOptionPane.INFORMATION_MESSAGE);

        if (accountName.isBlank()) {
            return;
        }

        DefaultMutableTreeNode child
                = new DefaultMutableTreeNode(accountName);

        treeModel.insertNodeInto(child, parent, parent.getChildCount());
    }

    public void btnRemoveActionPerformed(ActionEvent e) {
        TreePath treePath = frmTreeDemo.getTreeAccount().getSelectionPath();
        if (treePath == null) {
            return;
        }

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath.getLastPathComponent();
        if(node.isRoot()){
            return;
        }
        
        treeModel.removeNodeFromParent(node);
    }
    
    public void treeAccountMouseClicked(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON3){
            TreePath treePath = frmTreeDemo.getTreeAccount().getPathForLocation(e.getX(), e.getY());
                     
            if(treePath == null){
                return;
            }
            
            frmTreeDemo.getPmnTree().show(frmTreeDemo.getTreeAccount(), e.getX(), e.getY());
            
        }
    }
}
