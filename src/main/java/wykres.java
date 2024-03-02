import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class wykres {
	
	public static void createAndShowGUI() {
		String[] A = {"xd1", "xd2", "xd3"};
		int[] B = {1,2,3};
		JFrame frame = new JFrame();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0; i<3; i++) {
			dataset.setValue(B[i], "xd", A[i]);
		}
		JFreeChart chart = ChartFactory.createLineChart("tytul", "os x", "os y", dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		frame.add(chartPanel);
		
		frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });

	}

}
