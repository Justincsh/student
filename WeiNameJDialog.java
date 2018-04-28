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
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Database.MyDataBase;

public class WeiNameJDialog extends JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextArea jta = new JTextArea("       Name" + "\t        Student Number\n");
    private JScrollPane jsp = new JScrollPane(jta);
    private MyDataBase mdb = new MyDataBase();
    private ResultSet res = mdb.FindDatabase("select *from stu");

    public WeiNameJDialog() {
        setLayout(new GridLayout(0, 1));
        try {
            while (res.next()) {
                String name = res.getString("sname").trim();
                String sno = res.getString("sno");
                int n = res.getInt("sok");
                if (n == 1) {
                    if (name.length() == 3) {
                        jta.setText(jta.getText() + "       " + name + "\t" + sno + "\n");
                    } else {
                        jta.setText(jta.getText() + "       " + name + "\t" + sno + "\n");
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        add(jsp);
        setTitle("Absent");
        setSize(200, 300);
        setLocation(600, 200);
        setVisible(false);
    }
}
