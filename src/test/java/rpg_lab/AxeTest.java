package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void Test_IfWeapon_LosesDurability_AfterEachAttack() {
        axe.attack(dummy);
        Assert.assertEquals(EXPECTED_DURABILITY, axe.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class)
    public void Test_BrokenWeapon_CannotAttack() {

        int durability = 0;
        Axe axe = new Axe(AXE_ATTACK, durability);
        Assert.assertEquals(0, axe.getDurabilityPoints());

        axe.attack(dummy);
    }

    @Test
    public void testAxeCreation() {
        Assert.assertEquals(AXE_ATTACK, axe.getAttackPoints());
        Assert.assertEquals(AXE_DURABILITY, axe.getDurabilityPoints());
    }

}
