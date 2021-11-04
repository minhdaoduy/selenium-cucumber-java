package info.seleniumcucumber.managers;

import info.seleniumcucumber.utils.dataproviders.ConfigFileReader;
import info.seleniumcucumber.utils.dataproviders.ExcelDataReader;
import info.seleniumcucumber.utils.dataproviders.JsonDataReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static ExcelDataReader excelDataReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
	 }

	 public JsonDataReader getJsonReader(){
		 return (jsonDataReader == null) ? jsonDataReader = new JsonDataReader() : jsonDataReader;
	}

	 public ExcelDataReader getExcelReader(){
		 return(excelDataReader == null) ? excelDataReader = new ExcelDataReader() : excelDataReader;
	 }
}
