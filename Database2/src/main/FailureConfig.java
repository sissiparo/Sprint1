package main;

import persistence.PersistenceUtil;
import entity.Failure;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class FailureConfig extends SuperConfig {

	public FailureConfig() {
		super();
		initialise();
	}

	private void initialise() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook
				.getSheet(ColumnIndexes.FAILURECLASS__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {

				createFailure(
						Integer.parseInt(row[ColumnIndexes.FAILURECLASS_FAILURECLASS_COLNO]
								.getContents()),
						row[ColumnIndexes.FAILURECLASS_DESCRIPTION_COLNO]
								.getContents());
			}
		}
	}

	public void createFailure(int failureID, String failureDescription) {
		Failure failure = new Failure(failureID, failureDescription);
		PersistenceUtil.persist(failure);
	}

}
