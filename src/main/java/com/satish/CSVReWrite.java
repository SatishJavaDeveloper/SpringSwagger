package com.satish;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVReWrite {

	
	public static void main(String args[]) throws IOException
	{
		
		
		String csvFilename = "test123.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		String csv = "output.csv";
		
		FileWriter writers=new FileWriter(csv);
		CSVWriter writer = new CSVWriter(writers,',',CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER,System.getProperty("line.separator"));
	
		writer.writeNext(csvReader.readNext(),false);
	//	writers.append("\n");
		String[] row = null;
//		csvReader.readNext();
		while((row = csvReader.readNext()) != null) {
			
			if(row[5].startsWith("Employee Thread Group"))
			{
				row[2]="Employee";
			}
			else if(row[5].startsWith("Users Thread Group"))
			{
				row[2]="User Request";
				
			}
			writer.writeNext(row,false);
		//	writers.append("\n");
			/*System.out.println(row[0]
			          + " # " + row[1]
			          + " #  " + row[2]);*/
		}
		//...
		csvReader.close();
		writer.close();
	}
	
	
}
