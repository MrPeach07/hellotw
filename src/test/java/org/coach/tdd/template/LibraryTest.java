package org.coach.tdd.template;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {
    @Test
    public void when_three_cells_around_is_live() {
        LifeGame lifeGame =new LifeGame();
        BasicUnit basicUnit = new BasicUnit();
        int threelive[][] = {{0,0,0},{0,0,1},{1,1,0}};
//        basicUnit.setTestUnit(threelive);
        assertThat(basicUnit.getUnitCelltatus(threelive),is(1));
    }

    @Test
    public void when_two_cells_around_is_keep() {
        LifeGame lifeGame = new LifeGame();
        BasicUnit basicUnit = new BasicUnit();
        int twolive[][] = {{0,0,0},{0,0,1},{0,0,1}};
        assertThat(basicUnit.getUnitCelltatus(twolive),is(0));
    }

    @Test
    public void when_other_numberofcells_around_is_death() {
        LifeGame lifeGame = new LifeGame();
        BasicUnit basicUnit = new BasicUnit();
        int otherNumber1[][]= {{0,0,0},{0,0,1},{0,0,0}};
        int otherNumber4[][]= {{0,0,1},{0,1,1},{1,0,1}};
        int otherNumber5[][]= {{1,0,1},{0,1,1},{1,0,1}};
        assertThat(basicUnit.getUnitCelltatus(otherNumber1),is(0));
        assertThat(basicUnit.getUnitCelltatus(otherNumber4),is(0));
        assertThat(basicUnit.getUnitCelltatus(otherNumber5),is(0));
    }
}
