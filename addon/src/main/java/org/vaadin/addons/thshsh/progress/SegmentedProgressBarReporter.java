package org.vaadin.addons.thshsh.progress;

import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.UI;

public class SegmentedProgressBarReporter extends ProgressReporter {
	
	protected SegmentedProgressBar progressBar;

	public SegmentedProgressBarReporter(UI ui,SegmentedProgressBar progressBar,HasText message) {
		super(ui,message);
		this.progressBar = progressBar;
	}

	
	@Override
	public void increment(double val) {
		increment(val,null);
	}


	@Override
	public void increment(double val,String message) {
		int inc = (int)val;
		ui.access(()->{
			message(message);
			progressBar.setValue(progressBar.getValue()+inc);
		});
	}



	@Override
	public void incrementMax(double val) {
		int inc = (int)val;
		ui.access(()->{
			progressBar.setMax(inc+progressBar.getMax());
		});
	}


	

}
