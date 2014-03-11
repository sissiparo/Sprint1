package main;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import persistence.PersistenceUtil;
import entity.Manufacturer;

public class ManufacturerConfig extends SuperConfig2 {

	public ManufacturerConfig() {
		super();
		initialise();
	}

	private void initialise() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			if (PersistenceUtil
					.findManufacturerByName(row[ColumnIndexes.UE_MANUFACTURER_COLNO]
							.getContents()) == null) {
				createManufacturer((row[ColumnIndexes.UE_MANUFACTURER_COLNO]
						.getContents()));
			}
		}
	}

	public void createManufacturer(String manufacturerName) {

		Manufacturer manufacturer = new Manufacturer(manufacturerName);
		PersistenceUtil.persist(manufacturer);
	}

}
