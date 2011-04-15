package exemplo.jsf.richfaces4.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import exemplo.jsf.richfaces4.dao.ContaPagarDao;
import exemplo.jsf.richfaces4.modelo.Fornecedor;

public class ChartMaker {

	public static JFreeChart geraGrafico(DefaultPieDataset ds) throws IOException {
		JFreeChart grafico = ChartFactory.createPieChart3D(
				"Contas Pagar", ds, true, false, false);
		grafico.getPlot().setForegroundAlpha(0.4f);
		return grafico;
	}
	
	
	public static void main(String[] args) throws IOException {
		ContaPagarDao dao = new ContaPagarDao(HibernateUtil.openSession());
		
		List<Object[]> data = dao.listaFornecedorValor(1000);
		DefaultPieDataset ds = new DefaultPieDataset();
		
		for (Object [] objeto : data) {
			Fornecedor f = (Fornecedor) objeto[0];
			ds.setValue(f.getNome(), (Number) objeto[1]);
		}
		
		JFreeChart grafico = ChartMaker.geraGrafico(ds);
		ChartUtilities.saveChartAsJPEG(new File("image.jpg"), grafico, 640, 480);
	}
}
