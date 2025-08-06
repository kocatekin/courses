import java.time.LocalDate;

public class DiaryRecord {
	
	private LocalDate date;
	private String text;
	
	DiaryRecord(String text) {
		this.date = LocalDate.now();
		this.text = text;	
	}

	
	DiaryRecord(LocalDate date, String text) {
		this.date = date;
		this.text = text;
	}
	
	//getters and setters
	
	public String getText() {
		return text;
	}
	
	public String getDate() {
		return date.toString();
	}
	

}
