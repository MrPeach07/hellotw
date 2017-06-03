package org.coach.tdd.template;

/**
 * Created by lzy on 17-6-3.
 */
public class Cell {
	private int location_x=0;
	private  int location_y=0;
	private int cellStatus=0;
	private int[][] aroundCells=new int[3][3];
	public Cell(int location_x, int location_y, int cellStatus) {
		this.location_x = location_x;
		this.location_y = location_y;
		this.cellStatus = cellStatus;
	}

	public int getLocation_x() {
		return location_x;
	}

	public void setLocation_x(int location_x) {
		this.location_x = location_x;
	}

	public int getLocation_y() {
		return location_y;
	}

	public void setLocation_y(int location_y) {
		this.location_y = location_y;
	}

	public int getCellStatus() {
		return cellStatus;
	}

	public void setCellStatus(int cellStatus) {
		this.cellStatus = cellStatus;
	}

	public int[][] getAroundCells() {
		return aroundCells;
	}

	public void setAroundCells(int[][] aroundCells) {
		this.aroundCells = aroundCells;
	}
	public int getAfterTurnCellStatus(){
		BasicUnit basicUnit=new BasicUnit();
		this.setCellStatus(basicUnit.getUnitCelltatus(aroundCells));
		return this.getCellStatus();
	}
}
