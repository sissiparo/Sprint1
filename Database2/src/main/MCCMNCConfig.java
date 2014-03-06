package main;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import persistence.PersistenceUtil;
import entity.MCCMNC;

public class MCCMNCConfig extends SuperConfig {

	public MCCMNCConfig() {
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

				createMCCMNC(
						Integer.parseInt(row[ColumnIndexes.MCCMNC_MCC_COLNO]
								.getContents()),
						Integer.parseInt(row[ColumnIndexes.MCCMNC_MNC_COLNO]
								.getContents()),
						row[ColumnIndexes.MCCMNC_OPERATOR_COLNO].getContents());
			}
		}
	}

	public void createMCCMNC(int mcc, int mnc, String operator) {
		MCCMNC mccmnc = new MCCMNC(mcc, mnc, operator);
		PersistenceUtil.persist(mccmnc);
	}

}
