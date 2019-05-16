package com.ictexpertsgroup.practice;

public class ToDo {
	   private final long id;
	    private String summary;
	    private String description;
	    private int year;

	    public ToDo(long id, String summary, String description) {
	        this.id = id;
	        this.summary = summary;
	        this.description = description;
	    }

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public long getId() {
			return id;
		}
}
