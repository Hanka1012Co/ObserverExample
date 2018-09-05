package observerExample;

import javax.swing.JLabel;

public class Label_receiver extends JLabel implements Observer {

	public Label_receiver() {
		
	}
	
	@Override
	public void update(Object o) {
		int nbr;
		if (o instanceof Integer) {
			nbr = (Integer)o;
			this.setText(Integer.toString(nbr));
		}
	}

}
