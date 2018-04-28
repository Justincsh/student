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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Database.MyDataBase;

public class NameJDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    private MyDataBase nd = new MyDataBase();
    private ResultSet res1 = nd.FindDatabase("select *from stu");

    private JLabel imagjl;
    private JPanel namejp;
    private Icon[] icons;
    ArrayList<String> imName = new ArrayList<String>();
    ArrayList<String> imNo = new ArrayList<String>();
    private JButton nextjb = new JButton("Next");
    private JButton lastjb = new JButton("Last");
    private JButton tjb = new JButton("到课");
    private JButton fjb = new JButton("未到");
    private JButton okjb = new JButton("提交");
    private int index = 0;
    private int len = icons.length;

    public NameJDialog() {
        this.icons = new Icon[]{};
        try {
            while (res1.next()) {
                String name1 = res1.getString("sname");
                String no1 = res1.getString("sno");
                imNo.add(no1);
                imName.add(name1);
            }
            res1.close();
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        imagjl = new JLabel(imName.get(index), icons[index], SwingConstants.CENTER);
        imagjl.setVerticalTextPosition(SwingConstants.TOP);
        imagjl.setHorizontalTextPosition(SwingConstants.CENTER);
        add(imagjl, new BorderLayout().CENTER);

        namejp = new JPanel();
        namejp.setLayout(new GridLayout(0, 2));
        namejp.add(tjb);
        namejp.add(fjb);
        namejp.add(lastjb);
        namejp.add(nextjb);

        add(okjb, new BorderLayout().NORTH);
        add(namejp, new BorderLayout().SOUTH);

        setTitle("点名");
        setSize(220, 300);
        setLocation(500, 200);
        setVisible(false);
        AddNameAction();
    }

    private void AddNameAction() {

        okjb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        nextjb.addActionListener(new ActionListener() {//next

            @Override
            public void actionPerformed(ActionEvent e) {
                index++;
                imagjl.setText(imName.get(index));
                imagjl.setIcon(icons[index]);
                if (index == len - 1) {
                    nextjb.setEnabled(false);
                }
                if (index == 1) {
                    lastjb.setEnabled(true);
                }
            }
        });

        lastjb.addActionListener(new ActionListener() {//last

            @Override
            public void actionPerformed(ActionEvent e) {
                index--;
                imagjl.setText(imName.get(index));
                imagjl.setIcon(icons[index]);
                if (index == 0) {
                    lastjb.setEnabled(false);
                }
                if (index == len - 2) {
                    nextjb.setEnabled(true);
                }
            }
        });

        fjb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "update stu set sok=1 where sname=" + "'" + imName.get(index).trim() + "'";
                nd.Setdatabase(s);
            }
        });
    }

    public void Findstudent(String sno1) {
        for (int i = 0; i < imNo.size(); i++) {
            if (sno1.equals(imNo.get(i).trim())) {
                new FindJDialog(imName.get(i), imNo.get(i), icons[i]).setVisible(true);
                break;
            }
        }
    }
}
