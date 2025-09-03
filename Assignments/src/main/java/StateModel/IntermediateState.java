package StateModel;

public class IntermediateState extends State{
    public IntermediateState(GameCharacter gameCharacter) {
        super(gameCharacter);
    }

    @Override
    void action() {
        String[] options = {"Train", "Meditate"};
        switch (this.getGameCharacter().readUserChoice(options)) {
            case 1:
                this.getGameCharacter().addXp(50);
                System.out.println("You have trained and earned 50xp!");
                this.getGameCharacter().setState(new IntermediateState(this.getGameCharacter()));
                if (getGameCharacter().getXp() >= 600) {
                    this.getGameCharacter().setState(new ExpertState(this.getGameCharacter()));
                    System.out.println("Dingdingding! You have leveled up to Expert!");
                }
                break;
            case 2:
                this.getGameCharacter().addHp(10.0);
                System.out.println("You have meditated and recovered 10hp!");
                this.getGameCharacter().setState(new IntermediateState(this.getGameCharacter()));
                break;

        }
    }
}
