abstract class Fighter {

    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

    @Override
    public String toString() {
        return "Fighter is a ";
    }
    
}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return super.toString() + this.getClass().getName();
    }

    @Override
    int damagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter {

    private boolean hasSpell;
    
    @Override
    boolean isVulnerable() {
        return !hasSpell;
    }

    @Override
    int damagePoints(Fighter fighter) {
        return hasSpell ? 12 : 3;
    }

    void prepareSpell() {
        hasSpell = true;
    }

    @Override
    public String toString() {
        return super.toString() + this.getClass().getName();
    }

}
