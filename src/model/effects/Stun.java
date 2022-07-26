package model.effects;

import model.world.Champion;
import model.world.Condition;

public class Stun extends Effect {
    public Stun(int duration) {
        super("Stun", duration, EffectType.DEBUFF);
    }
    public void apply(Champion c) {
//		c.getAppliedEffects().add(this);
        c.setCondition(Condition.INACTIVE);
    }
    public void remove(Champion c) {
        if (c.searchEffectByName("Stun") == -1) {
            if (c.searchEffectByName("Root") >= 0)
                c.setCondition(Condition.ROOTED);
            else
                c.setCondition(Condition.ACTIVE);
        }
    }

}
