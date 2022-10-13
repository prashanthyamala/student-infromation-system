package com.blog.codingdeeps.bean;

public class terms {

	private int id;
	private String termName;
	private String termStartDate;
	private String termEndDate;
	private int termYear;
	private String termSeason;

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTermStartDate() {
		return termStartDate;
	}

	public void setTermStartDate(String termStartDate) {
		this.termStartDate = termStartDate;
	}

	public String getTermEndDate() {
		return termEndDate;
	}

	public void setTermEndDate(String termEndDate) {
		this.termEndDate = termEndDate;
	}

	public int getTermYear() {
		return termYear;
	}

	public void setTermYear(int termYear) {
		this.termYear = termYear;
	}

	public String getTermSeason() {
		return termSeason;
	}

	public void setTermSeason(String termSeason) {
		this.termSeason = termSeason;
	}

}
