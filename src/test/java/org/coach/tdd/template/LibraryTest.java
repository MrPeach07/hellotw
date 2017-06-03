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
}
