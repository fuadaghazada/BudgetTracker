package keeper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

	/**
	 	DataSet keeps the list of DataItems. It also reads/writes from/to a file.
	
		@authors 	Fuad Aghazada 
					Fatih Özgür Ardıç 
					Babanazar Gutlygeldiyev 
					Haya Shamim Khan Khattak 
					Orcan Yazıcı
	@version 1.00 
	*/
public class DataSet 
{
	// Class variables.
    private ArrayList<DataItem> dataItems;
    private String path;

    private File file;
    private Scanner fileReader;
    private FileWriter fileWriter;
    /*
     * Constructs a DataSet and a file.
     * @param path- file name.
     */
    public DataSet(String path)
    {
        this.setPath(path);

        dataItems = new ArrayList<>();

        file = new File(path);

    }

   
    /*
     * Writes into the file. Handles exceptions if the file does not exists.
     */
    public void writeToFile()
    {
        try 
        {
            fileWriter = new FileWriter(file);
            
            for (DataItem eachItem : dataItems) {
                String stringToWrite = eachItem.stringForDatabase();
                fileWriter.write(stringToWrite + "\n");
            }

            fileWriter.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /*
     * Writes into the file.(For reminder) Handles exceptions if the file does not exists.
     */    
    public void writeToFile2()
    {
        try 
        {
            fileWriter = new FileWriter(file);
            
            for (DataItem eachItem : dataItems) 
            {
                String stringToWrite = eachItem.stringForDatabaseReminder();
                fileWriter.write(stringToWrite + "\n");
            }

            fileWriter.close();
        }

        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    /*
     * Reads from the file. Handles exceptions if the file does not exists.
     */    
    public void readFromFile()
    {
        dataItems.clear();

        try {
            fileReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(fileReader.hasNext())
        {
            String line;

            line = fileReader.nextLine();

            String[] splitted = line.split("###");

            DataItem dataItem = new DataItem(splitted[0], splitted[1], splitted[2]);
            
            dataItems.add(dataItem);
        }

        fileReader.close();

    }
    /*
     * Reads from the file.(For reminder) Handles exceptions if the file does not exists.
     */
    public void readFromFile2()
    {
        dataItems.clear();

        try 
        {
            fileReader = new Scanner(file);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        while(fileReader.hasNext())
        {
            String line;

            line = fileReader.nextLine();

            String[] splitted = line.split("###");

            DataItem dataItem = new DataItem(splitted[0], splitted[1], splitted[2], splitted[3]);
            
            dataItems.add(dataItem);
        }

        fileReader.close();

    }
    /*
     * Clears the DataItem list before writing to the file.
     */
    public void prepareToWrite()
    {
    	dataItems.clear();
    }
    /*
     Adds a DataItem to the list.
     * @param category- category of dataItem.
     * @param amount- amount of dataItem.
     * @param date- date of dataItem.
     */
    public void add(String category, String amount, String date)
    {
        dataItems.add(new DataItem(category, amount, date));
    }
    /*
     Adds a DataItem to the list.(For reminder.)
     * @param category- category of dataItem.
     * @param amount- amount of dataItem.
     * @param date- date of dataItem.
     * @ param time- time of the data.
     */
    public void add(String category, String amount, String date, String time)
    {
        dataItems.add(new DataItem(category, amount, date, time));
    }
	/*
	 * Getters and setters.
	 */
	public ArrayList<DataItem> getDataItems() 
	{
		return dataItems;
	}

	public String getPath() 
	{
		return path;
	}

	public void setPath(String path) 
	{
		this.path = path;
	}

    
    
}
