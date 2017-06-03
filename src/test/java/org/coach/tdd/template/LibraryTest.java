package org.coach.tdd.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {
    @Test
    public void when_three_cells_around_is_live() {
        LifeGame lifeGame =new LifeGame();
        BasicUnit basicUnit = new BasicUnit();
        int threelive[][] = {{0,0,0},{0,0,1},{1,1,0}};
        basicUnit.setTestUnit(threelive);
        assertEquals(basicUnit.getStatus(),1);
    }
}
