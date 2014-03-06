package main;

public class SuperConfig {
	String workbookFileName;

	public SuperConfig() {
		workbookFileName = "C:/Users/c09409661/Desktop/NewWorkspace/Database2/*.xls";
	}

	public SuperConfig(String workbookfilename) {
		workbookFileName = workbookfilename;
	}

}
