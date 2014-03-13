package main;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;

class WorkbookSingleton {
	// singleton
	private static Workbook workbook;

	public static Workbook getWorkbook(String workbookFileName) {
		try {
			if (workbook == null) {
				WorkbookSettings workbookSettings = new WorkbookSettings();
				workbookSettings.setLocale(new Locale("en", "EN"));
				workbook = Workbook.getWorkbook(new File(workbookFileName),
						workbookSettings);
			}
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.toString());
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return workbook;
	}
}
