package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest{

    private static final int ALIVE_HEALTH = 10;
    private static final int EXPERIENCE = 10;
    private static final int ATTACK = 2;
    private static final int DEAD_HEALTH = 0;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        this.aliveDummy = new Dummy(ALIVE_HEALTH, EXPERIENCE);
        this.deadDummy = new Dummy(DEAD_HEALTH, EXPERIENCE);
    }



    @Test
    public void testLosesHealthIfAttacked() {
        aliveDummy.takeAttack(ATTACK);

        Assert.assertEquals(8, aliveDummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void testDeadDummyThrow() {
        deadDummy.takeAttack(ATTACK);

    }

    @Test
    public void testDeadDummyCanGiveXP() {
        int actual = deadDummy.giveExperience();

        Assert.assertEquals(EXPERIENCE * 2 , actual);
    }

    @Test (expected = IllegalStateException.class)
    public void testAliveDummyCannotGiveXP() {
        aliveDummy.giveExperience();
    }

    @Test
    public void testDummyIsAlive() {
        Assert.assertFalse(aliveDummy.isDead());
    }

    @Test
    public void testDeadDummy_IsDead() {
        Assert.assertTrue(deadDummy.isDead());
    }
}