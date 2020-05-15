package app.Model;

public abstract class Faction {

    public abstract void useSpecialAction( Player player);
    public abstract void useAbility( Player player);
    public abstract void useAfterStrongHold( Player player);
    public abstract int getDwellings();
    public abstract String getName();

    
}