/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import ni.uni.edu.programacion.views.FrmTreeDemo;

/**
 *
 * @author Sistemas-05
 */
public class FrmTreeController {
    private FrmTreeDemo frmTreeDemo;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;
    
    public FrmTreeController(FrmTreeDemo frmTreeDemo) {
        this.frmTreeDemo = frmTreeDemo;
        initComponent();
    }
    
    public void initComponent(){
        root = new DefaultMutableTreeNode("Accounting", true);
        treeModel = new DefaultTreeModel(root);
        
        frmTreeDemo.getTreeAccount().setModel(treeModel);
        frmTreeDemo.getTreeAccount().setExpandsSelectedPaths(true);
        frmTreeDemo.getBtnAdd().addActionListener((e) -> {
            btnAddActionListener(e);
        });
        
        frmTreeDemo.getBtnRemove().addActionListener((e) -> {
            btnRemoveActionListener(e);
        });
        
        frmTreeDemo.getTreeAccount().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                treeAccountMouseListener(e);
            }
        });
        
        frmTreeDemo.getMniAdd().addActionListener((e) -> {
            btnAddActionListener(e);
        });
        
        frmTreeDemo.getMniRemove().addActionListener((e) -> {
            btnRemoveActionListener(e);
        });

    }
        
    public void btnAddActionListener(ActionEvent e){
        DefaultMutableTreeNode node = getSelectedNode();
        if(node == null){
            return;
        }
        String accountName = JOptionPane.showInputDialog(null, "Account name", "Input Dialog", 
                JOptionPane.INFORMATION_MESSAGE);
        int childCount = node.getChildCount();
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(accountName);
        treeModel.insertNodeInto(child, node, childCount);
    }
    
    public void btnRemoveActionListener(ActionEvent e){
        DefaultMutableTreeNode node = getSelectedNode();
        if(node == null || node.isRoot()){
            return;
        }
        
        treeModel.removeNodeFromParent(node);
    }
    
    public void treeAccountMouseListener(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON3 ){
             
            TreePath c =  frmTreeDemo.getTreeAccount().getPathForLocation(e.getX(), e.getY());
            if(c == null){
                return;
            }
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) c.getLastPathComponent();         
            frmTreeDemo.getPmnTree().show(frmTreeDemo.getTreeAccount(), e.getX(), e.getY());
        }
    }
    
    private DefaultMutableTreeNode getSelectedNode(){
        TreePath treePath = frmTreeDemo.getTreeAccount().getSelectionPath();
        if(treePath == null){
            return null;
        }
        return (DefaultMutableTreeNode) treePath.getLastPathComponent();
    }
}
