package org.coach.tdd.template;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {
    @Test
    public void when_three_cells_around_is_live() {
        BasicUnit basicUnit = new BasicUnit();
        int threelive[][] = {{0,0,0},{0,0,1},{1,1,0}};
//        basicUnit.setTestUnit(threelive);
        assertThat(basicUnit.getUnitCelltatus(threelive),is(1));
    }

    @Test
    public void when_two_cells_around_is_keep() {
        BasicUnit basicUnit = new BasicUnit();
        int twolive[][] = {{0,0,0},{0,0,1},{0,0,1}};
        assertThat(basicUnit.getUnitCelltatus(twolive),is(0));
    }

    @Test
    public void when_other_numberofcells_around_is_death() {
        BasicUnit basicUnit = new BasicUnit();
        int otherNumber1[][]= {{0,0,0},{0,0,1},{0,0,0}};
        int otherNumber4[][]= {{0,0,1},{0,1,1},{1,0,1}};
        int otherNumber5[][]= {{1,0,1},{0,1,1},{1,0,1}};
        assertThat(basicUnit.getUnitCelltatus(otherNumber1),is(0));
        assertThat(basicUnit.getUnitCelltatus(otherNumber4),is(0));
        assertThat(basicUnit.getUnitCelltatus(otherNumber5),is(0));
    }

    @Test
	public void get_lifegame_cell_around_of_4_corner_msg(){
    	LifeGame lifeGame = new LifeGame(4);
    	lifeGame.init();
		Cell cell1 =new Cell(0,2,1);
		Cell cell2 =new Cell(1,2,1);
		lifeGame.putCell(cell1);
		lifeGame.putCell(cell2);
    	int[][] result = {{1,1,0},{0,0,0},{0,0,0}};
//    	assertArrayEquals(lifeGame.getAroundStatus(0,0),result);
		assertThat(lifeGame.getAroundStatus(0,3),is(result));
	}
	@Test
	public void get_lifegame_cell_around_of_4_line_msg(){
		LifeGame lifeGame = new LifeGame(4);
		lifeGame.init();
		Cell cell1 =new Cell(0,0,1);
		Cell cell2 =new Cell(1,0,1);
		Cell cell3 =new Cell(1,1,1);
		Cell cell4 =new Cell(1,2,1);
		lifeGame.putCell(cell1);
		lifeGame.putCell(cell2);
		lifeGame.putCell(cell3);
		lifeGame.putCell(cell4);
		int[][] result = {{1,0,1},{1,0,1},{0,0,0}};
//    	assertArrayEquals(lifeGame.getAroundStatus(0,0),result);
		assertThat(lifeGame.getAroundStatus(0,1),is(result));
	}
	@Test
	public void get_lifegame_cell_around_other_up_test(){
		LifeGame lifeGame = new LifeGame(4);
		lifeGame.init();
		Cell cell1 =new Cell(1,1,1);
		Cell cell2 =new Cell(1,2,1);
		Cell cell3 =new Cell(1,3,1);
		Cell cell4 =new Cell(2,1,1);
		lifeGame.putCell(cell1);
		lifeGame.putCell(cell2);
		lifeGame.putCell(cell3);
		lifeGame.putCell(cell4);
		int[][] result = {{1,1,1},{1,0,0},{0,0,0}};
//    	assertArrayEquals(lifeGame.getAroundStatus(0,0),result);
		assertThat(lifeGame.getAroundStatus(2,2),is(result));
	}
    @Test
	public void lifegame_run_init_1_cell_live() {
    	LifeGame lifeGame=new LifeGame(4);
    	lifeGame.init();
    	Cell cell1 =new Cell(1,2,1);
//    	Cell cell2 =new Cell(2,2,1);
//    	Cell cell3 =new Cell(2,3,1);
    	lifeGame.putCell(cell1);
//    	lifeGame.init(cell2);
//    	lifeGame.init(cell3);
		assertThat(lifeGame.isfreshFrame(),is(true));

	}
	@Test
	public void lifegame_run_init_2_cell_live(){
		LifeGame lifeGame=new LifeGame(4);
		lifeGame.init();
		Cell cell1 =new Cell(1,2,1);
    	Cell cell2 =new Cell(2,2,1);
//    	Cell cell3 =new Cell(2,3,1);
		lifeGame.putCell(cell1);
    	lifeGame.putCell(cell2);
//    	lifeGame.init(cell3);
		assertThat(lifeGame.isfreshFrame(),is(true));
	}
	@Test
	public void lifegame_run_3_cell_live() {

		LifeGame lifeGame=new LifeGame(4);
		lifeGame.init();
		Cell cell1 =new Cell(1,2,1);
		Cell cell2 =new Cell(2,2,1);
		Cell cell3 =new Cell(2,1,1);
//    	Cell cell3 =new Cell(2,3,1);
		lifeGame.putCell(cell1);
		lifeGame.putCell(cell2);
		lifeGame.putCell(cell3);
//    	lifeGame.init(cell3);
		assertThat(lifeGame.isfreshFrame(),is(true));

	}
}
