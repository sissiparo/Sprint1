package loader;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Manufacturer;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class ManufacturerConfig {

	String workbookFileName = "/home/group5/workspace/Database3/LargeData.xls";
	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addManufacturers() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			System.out.println(row[ColumnIndexes.UE_MANUFACTURER_COLNO]
					.getContents());
			if (em.createNamedQuery("Manufacturer.findByName")
					.setParameter(
							"manufacturerName",
							row[ColumnIndexes.UE_MANUFACTURER_COLNO]
									.getContents()).getResultList().size() == 0) {
				Manufacturer man = new Manufacturer(row[ColumnIndexes.UE_MANUFACTURER_COLNO]
						.getContents());
				em.persist(man);
			}
		}
	}
}
