package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import uebungsblatt2.StockTick;

public class GUI extends JFrame implements ActionListener {

	Aktien aktien = new Aktien();
	
	JButton button = new JButton();
	JButton button2 = new JButton();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	
	// Konstruktor
	public GUI (){
		
		this.setTitle("Aktienkursanalyse");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		label.setText("Aktienkurse anlegen");
		this.add(label);
		
		button.setText("Anlegen");
		button.addActionListener(this);
		this.add(button);
		
		label2.setText("Aktienkurse analysieren");
		this.add(label2);
		
		button2.setText("Ausrechnen");
		button2.addActionListener(this);
		this.add(button2);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
    if(e.getSource() == this.button){
        aktien.AktienAnlegen(aktien.Aktienkurse, 20);;
    }
    else if(e.getSource() == this.button2){
        aktien.DifferenzenRechner(aktien.Aktienkurse);;
    }
	}
	
}
