package org.vaadin.addons.thshsh.progress;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;

@CssImport("./segmented-progress-bar.css")
public class SegmentedProgressBar extends HorizontalLayout {

    private static final Logger LOGGER = LoggerFactory.getLogger(SegmentedProgressBar.class);

    private static final long serialVersionUID = -4842099998398517938L;
    
    protected static final String LAST_CSS = "last";
	protected static final String FIRST_CSS = "first";
    protected static final String SEGMENT_PROGRESS_BAR_CSS_CLASS = "segment-progress-bar";
    protected static final String SEGMENTED_PROGRESS_BAR_CSS_CLASS = "segmented-progress-bar";

	protected int max = 1;
	protected int value = 0;
	protected int segmentWidthPercent;
	protected List<ProgressBar> segments = new ArrayList<>();
	protected boolean nextSegmentIndeterminate = false;
	protected String height;
	
	public SegmentedProgressBar() {
    	this.addClassName(SEGMENTED_PROGRESS_BAR_CSS_CLASS);
	}

	
	
	@Override
    public void setHeight(String height) {
        this.height = height;
    }



    public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
		this.segmentWidthPercent = 100/max;
		updateSegments();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		updateValue();
	}
	

	public boolean isNextSegmentIndeterminate() {
        return nextSegmentIndeterminate;
    }

    public void setNextSegmentIndeterminate(boolean nextSegmentIndeterminate) {
        this.nextSegmentIndeterminate = nextSegmentIndeterminate;
    }

    protected void updateValue() {
		for(int i=0;i<max;i++) {
			ProgressBar segmentBar  = segments.get(i);
			if(i<value) {
				segmentBar.setValue(1);
				segmentBar.setIndeterminate(false);
			}
			else if(i>value) {
				segmentBar.setValue(0);
				segmentBar.setIndeterminate(false);
			}
			else {
				if(nextSegmentIndeterminate) segmentBar.setIndeterminate(true);
			}
		}
	}
	
	protected void updateSegments() {
		if(segments.size() != max) {
			this.remove(segments.toArray(new Component[segments.size()]));
			segments.clear();
			for(int i=0;i<max;i++) {
		    	ProgressBar segmentBar = new ProgressBar();
		    	segmentBar.setHeight(height);
		    	segmentBar.addClassName(SEGMENT_PROGRESS_BAR_CSS_CLASS);
		    	if(i==0) segmentBar.addClassName(FIRST_CSS);
		    	if(i+1==max) segmentBar.addClassName(LAST_CSS);
		    	segmentBar.setWidth(segmentWidthPercent+"%");
		    	this.add(segmentBar);
		    	segments.add(segmentBar);
	    	}
			updateValue();
		}
	}
	
	
	
}
