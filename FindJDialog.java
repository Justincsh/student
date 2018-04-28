/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Chan
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FindJDialog extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel jname;
    private JLabel jno;
    private JPanel jptop;
    private JLabel jlicon;

    public FindJDialog(String name, String no, Icon icon) {
        jname = new JLabel(name, SwingConstants.CENTER);
        jno = new JLabel(no, SwingConstants.CENTER);
        jptop = new JPanel();
        jptop.setLayout(new GridLayout(0, 1));
        jptop.add(jname);
        jptop.add(jno);
        add(jptop, new BorderLayout().NORTH);
        jlicon = new JLabel(icon);
        add(jlicon, new BorderLayout().CENTER);

        setTitle("Search");
        setLocation(500, 200);
        setSize(200, 250);
        setVisible(false);
    }
}
