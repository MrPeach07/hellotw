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
	public int getUnitCelltatus(int[][] basicUnit){
		int numberofcell=0;
		for (int i =0 ;i<3;i++){
			for(int j =0;j<3;j++){
				if(1==basicUnit[i][j])
					if(1==i&&1==j) {}
					else
						numberofcell+=1;
			}
		}
		if(3==numberofcell)
			return 1;
		else if(2==numberofcell)
			return basicUnit[1][1];
		return 0;
	}
}