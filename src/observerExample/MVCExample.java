package observerExample;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MVCExample {

	public static void main(String[] args) {
		JFrame mFenetre = new JFrame();
		JPanel mPanel = new  JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		
		Slider_emitter mSlider_emitter = new Slider_emitter();
		ProgressBar_receiver mProgressBar_receiver = new ProgressBar_receiver();
		Label_receiver mLabel_receiver = new Label_receiver();
		
		mSlider_emitter.addObserver(mProgressBar_receiver);
		mSlider_emitter.addObserver(mLabel_receiver);
		
		mFenetre.setTitle("Observer example");
		mFenetre.setSize(new Dimension(500,200));
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		mPanel.setLayout(new GridBagLayout());
		mPanel.add(mSlider_emitter, gbc);
		gbc.gridy = 1;
		mPanel.add(mLabel_receiver);
		gbc.gridy = 2;
		mPanel.add(mProgressBar_receiver,gbc);
		
		mFenetre.add(mPanel);
		mFenetre.setLocationRelativeTo(null);
		mFenetre.setVisible(true);
	}

}
