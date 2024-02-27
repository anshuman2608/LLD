public class MagicalArena {
    private Player playerA;
    private Player playerB;
    private Die attackingDie;
    private Die defendingDie;

    public MagicalArena(Player playerA, Player playerB, Die attackingDie, Die defendingDie) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.attackingDie = attackingDie;
        this.defendingDie = defendingDie;
    }

// The edge case when both have equal heath i am assuming player B will attack first
    // beacause no instruction was given for that in the edge case.
    public void playMatch() {
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.getHealth() > 0 && playerB.getHealth() > 0) {
            int attackRoll = attackingDie.roll();
            int defendRoll = defendingDie.roll();

            int damageDealt = attackRoll * attacker.getAttack();
            int damageDefended = defendRoll * defender.getStrength();

            int damageTaken = Math.max(0, damageDealt - damageDefended);
            defender.receiveDamage(damageTaken);

            // Print current game state
            System.out.println(attacker == playerA ? "Player A" : "Player B" + " attacks with roll " + attackRoll);
            System.out.println("Defender's strength: " + defender.getStrength() + ", Defender's health: " + defender.getHealth());
            System.out.println("Damage dealt: " + damageDealt + ", Damage defended: " + damageDefended);
            System.out.println("Defender's health reduced by: " + damageTaken);

            // Switch roles for next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        // Print the winner
        System.out.println(playerA.getHealth() <= 0 ? "Player B wins!" : "Player A wins!");
    }

}

