package com.rev.utility;

public class StudentBuilder extends Builder {

	@Override
	public void addExpenses() {
		student.setExpenses(1000);

	}

	@Override
	public void distinctions() {
		student.setDistinctionCount(2);

	}

}
