package main;

import persistence.PersistenceUtil;
import entity.Country;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class CountryConfig extends SuperConfig2 {

	public CountryConfig() {
		super();
		initialise();
	}

	private void initialise() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.MCCMNC__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			if (row.length > 0) {
				int mcc = Integer.parseInt(row[ColumnIndexes.MCCMNC_MCC_COLNO]
						.getContents());
				if (PersistenceUtil.findCountry(mcc) == null) {
					createCountry(mcc,
							row[ColumnIndexes.MCCMNC_COUNTRY_COLNO]
									.getContents());
				}
			}
		}
	}

	public void createCountry(int mcc, String countryName) {
		Country country = new Country(mcc, countryName);
		PersistenceUtil.persist(country);
	}

}
