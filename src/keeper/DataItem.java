package keeper;

/**
	DataItem creates dataItem which contains category, amount and date.

	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
	*/
public class DataItem 
{
	//Class variables
    private String category;
    private String amount;
    private String date;
    private String time;
	/*
	 * Constructs DataItem with three parameters.
	 * @param category- Category of the data.
	 * @param amount- amount of the data.
	 * @param date- date of the data.
	 */
    public DataItem(String category, String amount, String date) 
    {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
    /*
	 * Constructs DataItem with three parameters.(For reminder which includes time.)
	 * @param category- Category of the data.
	 * @param amount- amount of the data.
	 * @param date- date of the data.
	 * @param time- time of the data in the reminder.
	 */
    public DataItem(String category, String amount, String date, String time) 
    {
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

	/*
	 * Returns the data in string format.
	 * @return- data in string format.
	 */ 
    public String stringForDatabase()
    {
        String str = "";

        str += category;
        str += "###";
        str += amount;
        str += "###";
        str += date;

        return str;
    }
	/*
	 * Returns the data in string format.(For reminder.)
	 * @return- data in string format.
	 */     
    public String stringForDatabaseReminder()
    {
        String str = "";

        str += category;
        str += "###";
        str += amount;
        str += "###";
        str += date;
        str += "###";
        str += time;

        return str;
    }

	/*
	 * Getters and setter for properties.
	 */
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
    
    

}
