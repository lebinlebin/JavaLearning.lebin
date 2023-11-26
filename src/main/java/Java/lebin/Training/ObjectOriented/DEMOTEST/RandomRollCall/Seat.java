package Java.lebin.Training.ObjectOriented.DEMOTEST.RandomRollCall;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Seat extends JPanel {

	private JLabel label = null;
	public Seat(String name) {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setSize(126, 42);
		this.label = new JLabel(name);
		this.add(label);
	}
	
	public void highLight(){
		this.setBorder(new LineBorder(Color.RED, 4));
		this.repaint();
	}
	
	public void notHighLight(){
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.repaint();
	}
	
	@Override
	public String getName(){
		return label.getText();
	}
	
	public boolean hasPeople(){
		String n = label.getText();
		if(n==null ||  "".equals(n.trim())){
			return false;
		}
		return true;
	}

}
