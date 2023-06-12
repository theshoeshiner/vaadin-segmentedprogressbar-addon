package org.vaadin.addons.thshsh.progress;

import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.UI;

/** 
 * Utility class to auto update a progress bar and a message component
 */
public abstract class ProgressReporter {
    
    protected HasText message;
    protected UI ui;
    
	public ProgressReporter(UI ui, HasText message) {
        super();
        this.ui = ui;
        this.message = message;
    }
	
    public abstract void increment(double val);
	public abstract void increment(double val,String message);
	public abstract void incrementMax(double val);
	
    public void message(String message) {
        if(message != null) {
            ui.access(()->{
                this.message.setText(message);
            });
        }
    }
	
}
