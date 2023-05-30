package trabajo3bases;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI {
	
	JFrame frame;
	JPanel panel;
	JLabel label1;
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		
		JButton generate = new JButton("Generate");
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OracleConnection conn = new OracleConnection();
				conn.oracleConn();
			}
        });
		
		JButton button2 = new JButton("List");
		button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label1.setText("1");
            }
        });
		
		JButton mongo = new JButton("Mongo");
		mongo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MongoConnection connMon = new MongoConnection();
                connMon.mongoConn();
            }
        });
		
		
		label1 = new JLabel("Welcum");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));
		panel.setLayout(new GridLayout(0,1));
		panel.add(generate);
		panel.add(button2);
		panel.add(mongo);
		panel.add(label1);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Connection to databases aligator");
		frame.pack();
		frame.setVisible(true);
	}
		
}
