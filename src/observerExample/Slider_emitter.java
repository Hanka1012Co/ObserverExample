package observerExample;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider_emitter extends JSlider implements ChangeListener, Observable{

	private List<Observer> mListObserver;
	
	public Slider_emitter () {
		mListObserver = new ArrayList<Observer>();
		this.setMinimum(0);
		this.setMaximum(100);
		this.setValue(50);
		this.setPaintTicks(true);
		this.setPaintLabels(true);
		this.setMinorTickSpacing(10);
		this.setMajorTickSpacing(10);
		this.addChangeListener(this);
	}
	
	
	@Override
	public void addObserver(Observer obs) {
		mListObserver.add(obs);
		obs.update(this.getValue());
	}

	@Override
	public void removeObserver(Observer obs) {
		mListObserver.remove(obs);
	}

	@Override
	public void notifyObserver(Object obj) {
		for (Observer obs:mListObserver)
			obs.update(obj);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		notifyObserver(((JSlider)arg0.getSource()).getValue());
	}
}
