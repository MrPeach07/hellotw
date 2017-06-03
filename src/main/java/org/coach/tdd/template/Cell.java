package org.coach.tdd.template;

/**
 * Created by lzy on 17-6-3.
 */

/**
 * Cell类存储细胞的坐标，生命状态，周围细胞状态。
 */
public class Cell {
	private int location_x = 0;
	private int location_y = 0;
	private int cellStatus = 0;
	private int[][] aroundCells = new int[3][3];

	/**
	 * 构造方法的描述
	 *
	 * @param location_x 细胞的x坐标
	 * @param location_y 细胞的y坐标
	 * @param cellStatus 细胞的状态
	 */
	public Cell(int location_x, int location_y, int cellStatus) {
		this.location_x = location_x;
		this.location_y = location_y;
		this.cellStatus = cellStatus;
	}

	public int getLocation_x() {
		return location_x;
	}

	public int getLocation_y() {
		return location_y;
	}

	public int getCellStatus() {
		return cellStatus;
	}

	public void setCellStatus(int cellStatus) {
		this.cellStatus = cellStatus;
	}

	/**
	 * 获取更新后的细胞状态
	 *
	 * @return
	 */
	public int getAfterTurnCellStatus() {
		BasicUnit basicUnit = new BasicUnit();
		this.setCellStatus(basicUnit.getUnitCelltatus(aroundCells));
		return this.getCellStatus();
	}
}
