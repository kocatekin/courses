import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Diary {
	
	private User owner;
	private List<DiaryRecord> records = new ArrayList<>();
	
	Diary(User owner) {
		this.owner = owner;
	}
	
	public void addRecord(DiaryRecord record) {
		records.add(record);
	}
	

	public List<DiaryRecord> listAll() {
		return records;
	}
	

}
