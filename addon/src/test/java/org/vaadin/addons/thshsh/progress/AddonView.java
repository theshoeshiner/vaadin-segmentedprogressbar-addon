package org.vaadin.addons.thshsh.progress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;

@Route("")
public class AddonView extends VerticalLayout {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AddonView.class);

    private static final long serialVersionUID = -5828371605864015426L;

    public AddonView() {
        
        this.setMargin(true);

      int segments = 8;
      String width = "500px";
      String height = "20px";
      ProgressBar normal = new ProgressBar(0, segments);
      normal.setWidth(width);
      normal.setHeight(height);
      add(normal);  
      
      SegmentedProgressBar pbdet = new SegmentedProgressBar();
      pbdet.setNextSegmentIndeterminate(true);
      pbdet.setWidth(width);
      pbdet.setHeight(height);
      pbdet.setMax(segments);
      add(pbdet);
      
      SegmentedProgressBar pb = new SegmentedProgressBar();
      pb.setWidth(width);
      pb.setHeight(height);
      pb.setMax(segments);
      add(pb);
      
      Span message = new Span();
      add(message);
      
      
      Button run = new Button("Run",click -> {
          UI ui = UI.getCurrent();
          SegmentedProgressBarReporter rep = new SegmentedProgressBarReporter(ui, pb, message);
          SegmentedProgressBarReporter rep2 = new SegmentedProgressBarReporter(ui, pbdet, null);
          Thread t = new Thread(() -> {
              LOGGER.info("Running");
              for(int i=0;i<segments;i++) {
                  LOGGER.info("Progress: {}",i);
                  int p = i;
                  ui.access(() -> {
                      rep.increment(1, "Progress is at "+p);
                      rep2.increment(1, null);
                      normal.setValue(p+1);
                      ui.push();
                  });
                  
                  try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                }
              }
          });
          t.start();
      });
      add(run);
    	
    }
    

}
