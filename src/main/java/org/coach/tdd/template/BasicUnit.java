package org.coach.tdd.template;

/**
 * Created by lzy on 17-6-3.
 */

public class BasicUnit {
	private int [][] testUnit = new int[3][3]; //将一个细胞及其周围相邻细胞看作一个基本单元
	private int status = 0; //基本单元内细胞生死状态，0代表死，1代表生

	public int[][] getTestUnit() {
		return testUnit;
	}

	public void setTestUnit(int[][] testUnit) {
		this.testUnit = testUnit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}