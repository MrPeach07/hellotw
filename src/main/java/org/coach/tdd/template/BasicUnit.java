package org.coach.tdd.template;

/**
 * Created by lzy on 17-6-3.
 */

/**
 * BasicUnit类判断单元细胞的生命状态。
 */
public class BasicUnit {
	private static final int DEATH = 0;
	private static final int LIVE = 1;
	private int[][] testUnit = new int[3][3]; //将一个细胞及其周围相邻细胞看作一个基本单元
	private int status = DEATH;

	public void setTestUnit(int[][] testUnit) {
		this.testUnit = testUnit;
	}

	/**
	 * .
	 * 获得单元细胞生命状态
	 *
	 * @param basicUnit 该细胞周围细胞生命状态
	 * @return 该细胞生命状态
	 */
	public int getUnitCelltatus(int[][] basicUnit) {
		int numberofcell = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (1 == basicUnit[i][j]) {
					if (1 == i && 1 == j) {
					} else {
						numberofcell += 1;
					}
				}
			}
		}
		if (3 == numberofcell) {
			return 1;
		} else if (2 == numberofcell) {
			return basicUnit[1][1];
		}
		return 0;
	}
}