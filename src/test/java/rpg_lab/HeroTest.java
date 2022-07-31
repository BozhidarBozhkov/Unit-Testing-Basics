package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    private static class FakeWeapon implements Weapon{
        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {
        }
    }

//    @Test
//    public void testHeroGainsExperienceWhenTargetDies() {
//        Weapon weapon = new Axe(13, 42);
//
//        Hero hero = new Hero("TestHero", weapon);
//
//        assertEquals(0, hero.getExperience());
//
//        Target fakeTarget = new Dummy(13, 200);
//
//        hero.attack(fakeTarget);
//
//        assertEquals(45, hero.getExperience());
//    }

    @Test
    public void testHeroGainsXPWhenKillingTarget() {
        Hero hero = new Hero("Pesho", new FakeWeapon());

        String name = hero.getName();
        Weapon weapon = hero.getWeapon();

        Target target = new Target() {
            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public int giveExperience() {
                return 200;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }

    @Test
    public void testHeroGainsXP_MockingExample() {
        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Gosho", weapon);

        assertEquals(0, hero.getExperience());

        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(200);

        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }
}
