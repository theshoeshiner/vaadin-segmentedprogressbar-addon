# vaadin-segmentedprogressbar-addon
Vaadin Segmented ProgressBar Add-on

Simple ProgressBar replacement that renders a series of segments rather than a continuous bar. Useful when you want to explictly convey that an operation is a discrete series of steps.

Progress values are integers. Can configure if currently _active_ step is individually rendered as indeterminate or not. (See Screenshot)

```
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
```

![image](https://github.com/theshoeshiner/vaadin-segmentedprogressbar-addon/assets/2922868/8ed56944-2831-4e71-8a8e-dbf7d98dc25d)

