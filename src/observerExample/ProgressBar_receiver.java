package observerExample;

import javax.swing.JProgressBar;

public class ProgressBar_receiver extends JProgressBar implements Observer {

	private Slider_emitter mEmitter;
	
	public ProgressBar_receiver() {
		this.setMinimum(0);
		this.setMaximum(100);
		this.setStringPainted(true);
	}
	@Override
	public void update(Object o) {
		int value;
		if (o instanceof Integer) {
			value = (Integer)o;
			this.setValue(value);
		}
	}

}
