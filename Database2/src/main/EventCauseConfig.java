package main;

import persistence.PersistenceUtil;
import entity.EventCause;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class EventCauseConfig extends SuperConfig2 {

	public EventCauseConfig() {
		super();
		initialise();
	}

	private void initialise() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook
				.getSheet(ColumnIndexes.EVENTCAUSE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {

				createEventCause(
						Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_CAUSECODE_COLNO]
								.getContents()),
						Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_EVENTID_COLNO]
								.getContents()),
						row[ColumnIndexes.EVENTCAUSE_DESCRIPTION_COLNO]
								.getContents());

			}

		}
	}

	public void createEventCause(int causeID, int eventID,
			String causeDescription) {
		EventCause eventCause = new EventCause(causeID, eventID,
				causeDescription);
		PersistenceUtil.persist(eventCause);
	}

}
