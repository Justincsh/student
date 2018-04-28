/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Database.MyDataBase;

/**
 *
 * @author Chan
 */
public class gui extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private MyDataBase md = new MyDataBase();

    private NameJDialog njd = new NameJDialog();
    private JPanel mainjp;
    private JButton mainjb1;
    private JButton mainjb2;
    private JButton mainjb3;
    private JButton mainjb4;

    public gui() {
        mainjb1 = new JButton("Search");
        mainjb2 = new JButton("Taking Attendence");
        mainjb3 = new JButton("Absent List");
        mainjb4 = new JButton("Exit");
        mainjp = new JPanel();
        mainjp.setLayout(new GridLayout(0, 2));
        mainjp.add(mainjb1);
        mainjp.add(mainjb2);
        mainjp.add(mainjb3);
        mainjp.add(mainjb4);
        add(mainjp, new BorderLayout().NORTH);
        setTitle("Attendence Checking");
        ImageIcon img = new ImageIcon("");//set logo as you want
        JLabel jl = new JLabel(img);
        add(jl, new BorderLayout().CENTER);

        setSize(300, 370);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(400, 100);
        setResizable(false);
        setVisible(true);
        AddMainAction();
    }

    private void AddMainAction() {
        mainjb4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                md.Setdatabase("update stu set sok=0");
                System.exit(0);
            }
        });

        mainjb3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new WeiNameJDialog().setVisible(true);;
            }
        });

        mainjb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                njd.setVisible(true);
            }
        });

        mainjb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String findno;
                int selection;
                findno = JOptionPane.showInputDialog("Pls enter Student Number：");
                selection = JOptionPane.showConfirmDialog(null, "Student Number：" + findno + "?", "Verify", JOptionPane.YES_NO_OPTION);
                if (selection == JOptionPane.YES_OPTION) {
                    try {
                        ResultSet res = md.FindDatabase("select *from stu");
                        while (res.next()) {
                            String sno1 = res.getString("sno").trim();
                            if (findno.equals(sno1)) {
                                njd.Findstudent(sno1);
                                break;
                            }
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}
