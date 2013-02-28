package se.uu.it.TaskModel.domain;

public class Task {
	
	private String title;
	private String date;
	private String time;
	private String duration;
	private String priority;
	private String notes;
	private String location;
	private String category;
	private boolean overdue;
	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	 
	
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
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

	public String getPriority() {
		return priority;
	}
	public void setTitle(String title_i){
		title = title_i;
	}
	
	public void setTime(String time_i){
		time = time_i;
	}
	
	public void setPriority(String priority_i){
		priority = priority_i;
	}
	
	public void doneTask() { 
		setPriority("done");
		}


}