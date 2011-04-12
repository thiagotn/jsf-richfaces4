package exemplo.jsf.richfaces4.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraBanco {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SchemaExport ex = new SchemaExport(cfg);
		ex.create(true, true);
	}
}
