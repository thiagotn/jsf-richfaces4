package exemplo.jsf.richfaces4.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import exemplo.jsf.richfaces4.dao.ContaPagarDao;
import exemplo.jsf.richfaces4.modelo.Fornecedor;

@SuppressWarnings("serial")
public class ChartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ContaPagarDao dao = new ContaPagarDao(HibernateUtil.currentSession());
		
		List<Object[]> data = dao.listaFornecedorValor(1000);
		DefaultPieDataset ds = new DefaultPieDataset();
		
		for (Object [] objeto : data) {
			Fornecedor f = (Fornecedor) objeto[0];
			ds.setValue(f.getNome(), (Number) objeto[1]);
		}
		
		JFreeChart grafico = ChartMaker.geraGrafico(ds);
		resp.setContentType("image/jpeg");
		ChartUtilities.writeChartAsJPEG(resp.getOutputStream(), grafico, 300, 200);
	}
	
}
