import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Main {
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void createAndShowGUI() {
		
		logger.trace("Entering application.");
		
		Currency[] currency = new Currency[33];
		
		GoldData goldData = new GoldData();
		Float gold = 0.0f;
		
		PlotGold[] plotGold = new PlotGold[30];
		
		PlotCurrency[] thb = new PlotCurrency[30];
		PlotCurrency[] usd = new PlotCurrency[30];
		PlotCurrency[] aud = new PlotCurrency[30];
		PlotCurrency[] hkd = new PlotCurrency[30];
		PlotCurrency[] cad = new PlotCurrency[30];
		PlotCurrency[] nzd = new PlotCurrency[30];
		PlotCurrency[] sgd = new PlotCurrency[30];
		PlotCurrency[] eur = new PlotCurrency[30];
		PlotCurrency[] huf = new PlotCurrency[30];
		PlotCurrency[] chf = new PlotCurrency[30];
		PlotCurrency[] gbp = new PlotCurrency[30];
		PlotCurrency[] uah = new PlotCurrency[30];
		PlotCurrency[] jpy = new PlotCurrency[30];
		PlotCurrency[] czk = new PlotCurrency[30];
		PlotCurrency[] dkk = new PlotCurrency[30];
		PlotCurrency[] isk = new PlotCurrency[30];
		PlotCurrency[] nok = new PlotCurrency[30];
		PlotCurrency[] sek = new PlotCurrency[30];
		PlotCurrency[] ron = new PlotCurrency[30];
		PlotCurrency[] bgn = new PlotCurrency[30];
		PlotCurrency[] tryy = new PlotCurrency[30];
		PlotCurrency[] ils = new PlotCurrency[30];
		PlotCurrency[] clp = new PlotCurrency[30];
		PlotCurrency[] php = new PlotCurrency[30];
		PlotCurrency[] mxn = new PlotCurrency[30];
		PlotCurrency[] zar = new PlotCurrency[30];
		PlotCurrency[] brl = new PlotCurrency[30];
		PlotCurrency[] myr = new PlotCurrency[30];
		PlotCurrency[] idr = new PlotCurrency[30];
		PlotCurrency[] inr = new PlotCurrency[30];
		PlotCurrency[] krw = new PlotCurrency[30];
		PlotCurrency[] cny = new PlotCurrency[30];
		PlotCurrency[] xdr = new PlotCurrency[30];
		
		//CONNECTION CHECK
		int intCode;
		ConnectionCheck connectionCheck = new ConnectionCheck();
		connectionCheck.connect();
		intCode = connectionCheck.getCode();
		logger.trace("Connection Code " + intCode);
		
		if (intCode == 200) {
			//CURRENCY
			CurrencyData currencyData = new CurrencyData();
			currencyData.connect();
			currencyData.getCurrency(currency);
			//GOLD
			goldData.connect();
			gold = goldData.getCurrency();
			//PLOT GOLD
			PlotData plotData = new PlotData();
			plotData.connect("http://api.nbp.pl/api/cenyzlota/last/30/");
			plotData.getPlot(plotGold);
			//PLOT CURRENCY
			PlotDataCurrency plotDataCurrency = new PlotDataCurrency();
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/thb/last/30/");
			plotDataCurrency.getPlotCurrency(thb);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/usd/last/30/");
			plotDataCurrency.getPlotCurrency(usd);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/aud/last/30/");
			plotDataCurrency.getPlotCurrency(aud);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/hkd/last/30/");
			plotDataCurrency.getPlotCurrency(hkd);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/cad/last/30/");
			plotDataCurrency.getPlotCurrency(cad);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/nzd/last/30/");
			plotDataCurrency.getPlotCurrency(nzd);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/sgd/last/30/");
			plotDataCurrency.getPlotCurrency(sgd);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/eur/last/30/");
			plotDataCurrency.getPlotCurrency(eur);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/huf/last/30/");
			plotDataCurrency.getPlotCurrency(huf);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/chf/last/30/");
			plotDataCurrency.getPlotCurrency(chf);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/30/");
			plotDataCurrency.getPlotCurrency(gbp);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/uah/last/30/");
			plotDataCurrency.getPlotCurrency(uah);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/jpy/last/30/");
			plotDataCurrency.getPlotCurrency(jpy);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/czk/last/30/");
			plotDataCurrency.getPlotCurrency(czk);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/dkk/last/30/");
			plotDataCurrency.getPlotCurrency(dkk);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/isk/last/30/");
			plotDataCurrency.getPlotCurrency(isk);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/nok/last/30/");
			plotDataCurrency.getPlotCurrency(nok);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/sek/last/30/");
			plotDataCurrency.getPlotCurrency(sek);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/ron/last/30/");
			plotDataCurrency.getPlotCurrency(ron);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/bgn/last/30/");
			plotDataCurrency.getPlotCurrency(bgn);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/try/last/30/");
			plotDataCurrency.getPlotCurrency(tryy);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/ils/last/30/");
			plotDataCurrency.getPlotCurrency(ils);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/clp/last/30/");
			plotDataCurrency.getPlotCurrency(clp);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/php/last/30/");
			plotDataCurrency.getPlotCurrency(php);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/mxn/last/30/");
			plotDataCurrency.getPlotCurrency(mxn);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/zar/last/30/");
			plotDataCurrency.getPlotCurrency(zar);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/brl/last/30/");
			plotDataCurrency.getPlotCurrency(brl);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/myr/last/30/");
			plotDataCurrency.getPlotCurrency(myr);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/idr/last/30/");
			plotDataCurrency.getPlotCurrency(idr);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/inr/last/30/");
			plotDataCurrency.getPlotCurrency(inr);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/krw/last/30/");
			plotDataCurrency.getPlotCurrency(krw);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/cny/last/30/");
			plotDataCurrency.getPlotCurrency(cny);
			plotDataCurrency.connect("http://api.nbp.pl/api/exchangerates/rates/a/xdr/last/30/");
			plotDataCurrency.getPlotCurrency(xdr);
			logger.trace("Data downloaded");
			
			JFrame jf = new JFrame("Kursy walut");
			jf.setLayout(new BorderLayout());
			jf.setPreferredSize(new Dimension(1120, 645));
			
			JTabbedPane tp = new JTabbedPane();
			tp.setFont(new Font("Arial",Font.PLAIN,18));
	        tp.setBackground(Color.WHITE);
			//CARD1
			JPanel card1 = new JPanel();
			card1.setLayout(new BorderLayout());
			//TABLE
			JPanel tableJP1 = new JPanel();
			card1.add(tableJP1, BorderLayout.WEST);
			String[] columnNames = {"Waluta","Kod","Cena [pln]"};
			String[][] tableData = new String[34][3];
			for (int i=0; i<33; i++) {
				tableData[i][0] = currency[i].getCurrency();
				tableData[i][1] = currency[i].getCode();
				tableData[i][2] = (currency[i].getMid()).toString();
			}
			tableData[33][0] = "złoto";
			tableData[33][1] = "1g";
			tableData[33][2] = gold.toString();
			JTable table1 = new JTable(tableData,columnNames);
			TableColumn column = null;
			column = table1.getColumnModel().getColumn(0);
			column.setPreferredWidth(190);
			JPanel tableHeader = new JPanel();
			tableHeader.setLayout(new BorderLayout());
			tableHeader.add(table1, BorderLayout.CENTER);
			tableHeader.add(table1.getTableHeader(), BorderLayout.NORTH);
			tableJP1.add(tableHeader);
			logger.trace("Table displayed");
			//DIALOG
			JPanel right = new JPanel();
			right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
			JPanel choicePlot = new JPanel();
			choicePlot.setLayout(new BorderLayout());
			choicePlot.add(right, BorderLayout.NORTH);
			card1.add(choicePlot, BorderLayout.CENTER);
			//String test = (currency[28].getMid()).toString();
			//Double test12 = Double.parseDouble(test);
			//System.out.println(test12);
			//System.out.println(String.format("%.5%n", (currency[28].getMid()).toString()));
	        final Label label = new Label();
	        label.setAlignment(Label.CENTER); 
	        label.setFont(new Font("Arial",Font.PLAIN,18));
	        label.setSize(400, 100);
	        label.setText("Wybierz walutę, aby zobaczyć średni kurs ostatnich 30 notowań");
	        JButton plot = new JButton("Wybierz");
	        plot.setFont(new Font("Arial",Font.PLAIN,18));
	        plot.setBackground(Color.WHITE);
	        plot.setPreferredSize(new Dimension(100, 30));  
	        final Choice choice = new Choice();
	        choice.setPreferredSize(new Dimension(200, 50));  
	        
	        //choice.add("bat");    
	        choice.add("dolar amerykański");    
	        //choice.add("dolar australijski");    
	        //choice.add("dolar Hongkongu");    
	        //choice.add("doalr kanadyjski");
	        //choice.add("dolar nowozelandzki");    
	        //choice.add("doalr singapurski");    
	        choice.add("euro");    
	        //choice.add("forint");    
	        choice.add("frank szwajcarski");
	        choice.add("funt szterling");    
	        //choice.add("hrywna");    
	        //choice.add("jen");    
	        //choice.add("korona czeska");    
	        //choice.add("korona duńska");
	        //choice.add("korona islandzka");    
	        //choice.add("korona norweska");    
	        //choice.add("korona szwedzka");    
	        //choice.add("lej rumuński");    
	        //choice.add("lew");
	        choice.add("lira turecka");    
	        //choice.add("nowy izraelski szekel");    
	        //choice.add("peso chilijskie");    
	        //choice.add("peso filipińskie");    
	        //choice.add("peso meksykańskie");
	        //choice.add("rand");    
	        //choice.add("real");    
	        //choice.add("ringgit");    
	        //choice.add("rupia indonezyjska");    
	        //choice.add("rupia indyjska");
	        //choice.add("won południowokoreański");    
	        //choice.add("yuan renminbi");    
	        //choice.add("SDR");
	  
	        // adding above components into the frame   
	        right.add(label); 
	        right.add(choice);   
	        right.add(plot);    
	        
	        //CARDS
	        JPanel cardPanel = new JPanel();
	        CardLayout cd = new CardLayout();
	        cardPanel.setLayout(cd);
	        choicePlot.add(cardPanel, BorderLayout.SOUTH);
	        //DOLAR
	        JPanel dolar = new JPanel();
	        PlotCurrency[] realPlot = new PlotCurrency[30];
	        for (int i=0; i<30; i++) {
    			realPlot[i] = usd[i];
    		}
        	String[] osX = new String[30];
        	Float[] osY = new Float[30];
        	for(int i=0; i<30; i++) {
        		osX[i] = Integer.toString(i+1);
        		osY[i] = realPlot[i].getMid();
        	}
        	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    		for(int i=0; i<30; i++) {
    			dataset.setValue(osY[i], "", osX[i]);
    		}
    		JFreeChart chart = ChartFactory.createLineChart("", "30 ostatnich notowań", "Wartość [pln]", dataset);
    		ChartPanel chartPanel = new ChartPanel(chart);
    		chartPanel.setPreferredSize(new Dimension(700, 450));
    		dolar.add(chartPanel);
    		cardPanel.add(dolar, "dolar amerykański");
    		
    		//EURO
	        JPanel euro = new JPanel();
	        PlotCurrency[] realPlot2 = new PlotCurrency[30];
	        for (int i=0; i<30; i++) {
    			realPlot2[i] = eur[i];
    		}
        	String[] osX2 = new String[30];
        	Float[] osY2 = new Float[30];
        	for(int i=0; i<30; i++) {
        		osX2[i] = Integer.toString(i+1);
        		osY2[i] = realPlot2[i].getMid();
        	}
        	DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
    		for(int i=0; i<30; i++) {
    			dataset2.setValue(osY2[i], "", osX2[i]);
    		}
    		JFreeChart chart2 = ChartFactory.createLineChart("", "30 ostatnich notowań", "Wartość [pln]", dataset2);
    		ChartPanel chartPanel2 = new ChartPanel(chart2);
    		chartPanel2.setPreferredSize(new Dimension(700, 450));
    		euro.add(chartPanel2);
    		cardPanel.add(euro, "euro");
    		
    		//LIRA
	        JPanel lira = new JPanel();
	        PlotCurrency[] realPlot3 = new PlotCurrency[30];
	        for (int i=0; i<30; i++) {
    			realPlot3[i] = tryy[i];
    		}
        	String[] osX3 = new String[30];
        	Float[] osY3 = new Float[30];
        	for(int i=0; i<30; i++) {
        		osX3[i] = Integer.toString(i+1);
        		osY3[i] = realPlot3[i].getMid();
        	}
        	DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
    		for(int i=0; i<30; i++) {
    			dataset3.setValue(osY3[i], "", osX3[i]);
    		}
    		JFreeChart chart3 = ChartFactory.createLineChart("", "30 ostatnich notowań", "Wartość [pln]", dataset3);
    		ChartPanel chartPanel3 = new ChartPanel(chart3);
    		chartPanel3.setPreferredSize(new Dimension(700, 450));
    		lira.add(chartPanel3);
    		cardPanel.add(lira, "lira turecka");
    		
    		//FRANK
	        JPanel frank = new JPanel();
	        PlotCurrency[] realPlot4 = new PlotCurrency[30];
	        for (int i=0; i<30; i++) {
    			realPlot4[i] = chf[i];
    		}
        	String[] osX4 = new String[30];
        	Float[] osY4 = new Float[30];
        	for(int i=0; i<30; i++) {
        		osX4[i] = Integer.toString(i+1);
        		osY4[i] = realPlot4[i].getMid();
        	}
        	DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();
    		for(int i=0; i<30; i++) {
    			dataset4.setValue(osY4[i], "", osX4[i]);
    		}
    		JFreeChart chart4 = ChartFactory.createLineChart("", "30 ostatnich notowań", "Wartość [pln]", dataset4);
    		ChartPanel chartPanel4 = new ChartPanel(chart4);
    		chartPanel4.setPreferredSize(new Dimension(700, 450));
    		frank.add(chartPanel4);
    		cardPanel.add(frank, "frank szwajcarski");
    		
    		//FUNT
	        JPanel funt = new JPanel();
	        PlotCurrency[] realPlot5 = new PlotCurrency[30];
	        for (int i=0; i<30; i++) {
    			realPlot5[i] = gbp[i];
    		}
        	String[] osX5 = new String[30];
        	Float[] osY5 = new Float[30];
        	for(int i=0; i<30; i++) {
        		osX5[i] = Integer.toString(i+1);
        		osY5[i] = realPlot5[i].getMid();
        	}
        	DefaultCategoryDataset dataset5 = new DefaultCategoryDataset();
    		for(int i=0; i<30; i++) {
    			dataset5.setValue(osY5[i], "", osX5[i]);
    		}
    		JFreeChart chart5 = ChartFactory.createLineChart("", "30 ostatnich notowań", "Wartość [pln]", dataset5);
    		ChartPanel chartPanel5 = new ChartPanel(chart5);
    		chartPanel5.setPreferredSize(new Dimension(700, 450));
    		funt.add(chartPanel5);
    		cardPanel.add(funt, "funt szterling");
	  
	        plot.addActionListener(new ActionListener() {
	        	
	        public void actionPerformed(ActionEvent e) {
	        	String data = choice.getItem(choice.getSelectedIndex());    
	        	logger.trace("Chosen currency" + data);
	        	cd.show(cardPanel, data);
	        }    
	        });             
	  		
			//JPanel card2 = new JPanel();
			//card2.add(new JTextField("TextField", 20));
			
			tp.addTab("Aktualne kursy walut obcych i złota", card1);
	        //tp.addTab("Symulator inwestycyjnego portfela walutowego", card2);
			
	        jf.add(tp, BorderLayout.CENTER);	
			
	        jf.pack();
	        jf.setLocationRelativeTo(null);
	        jf.setVisible(true);
	        jf.setResizable(false);
	        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else {
			logger.error("Connection error");
			JFrame jfError = new JFrame("Kurs Walut - błąd połączenia sieciowego");
			jfError.setLayout(new BorderLayout());
			
			final Label label = new Label();
	        label.setAlignment(Label.CENTER); 
	        label.setFont(new Font("Arial",Font.PLAIN,18));
	        label.setSize(400, 100);
	        label.setText("Błąd połączenia z siecią. Sprawdz połączenie i spróbuj ponownie");
	        
	        jfError.add(label, BorderLayout.CENTER);
		}
		
		  
        logger.trace("Exiting application.");
    }


	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
	}

}
