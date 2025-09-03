package StateModel;

public class ExpertState extends State{
    public ExpertState(GameCharacter gameCharacter) {
        super(gameCharacter);
    }

    @Override
    void action() {
        String[] options = {"Train", "Meditate", "Fight"};
        switch (this.getGameCharacter().readUserChoice(options)) {
            case 1:
                this.getGameCharacter().addXp(50);
                System.out.println("You have trained and earned 50xp!");
                this.getGameCharacter().setState(new ExpertState(this.getGameCharacter()));
                if (getGameCharacter().getXp() >= 1800) {
                    this.getGameCharacter().setState(new MasterState(this.getGameCharacter()));
                    System.out.println("Dingdingding! You have become... Master! You win!");
                }
                break;
            case 2:
                this.getGameCharacter().addHp(10.0);
                System.out.println("You have meditated and recovered 10hp!");
                this.getGameCharacter().setState(new ExpertState(this.getGameCharacter()));
                break;
            case 3:
                double damag = Math.random()*-50;
                if (this.getGameCharacter().getHp() + damag <= 0) {
                    System.out.println("You fought a fierce beast and lost " + (-damag) + " hp!");
                    System.out.println("You have died. Game over.");
                    System.exit(0);
                }
                this.getGameCharacter().addHp(damag);
                this.getGameCharacter().addXp(160);
                System.out.println("You fought and won a fierce beast and lost " + (-damag) + " hp! You also earned 160xp!");
                this.getGameCharacter().setState(new ExpertState(this.getGameCharacter()));

                if (getGameCharacter().getXp() >= 1800) {
                    this.getGameCharacter().setState(new MasterState(this.getGameCharacter()));
                    System.out.println("Dingdingding! You have become... Master! You win!");
                }

                break;
        }
    }
}
