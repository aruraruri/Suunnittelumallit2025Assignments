package StateModel;

public class NoviceState extends State{
    public NoviceState(GameCharacter gameCharacter) {
        super(gameCharacter);
    }

    @Override
    void action() {
        String[] options = {"Train"};
        switch (this.getGameCharacter().readUserChoice(options)) {
            case 1:
                this.getGameCharacter().addXp(50);
                System.out.println("You have trained and earned 50xp!");
                this.getGameCharacter().setState(new NoviceState(this.getGameCharacter()));
                if (getGameCharacter().getXp() >= 200) {
                    this.getGameCharacter().setState(new IntermediateState(this.getGameCharacter()));
                    System.out.println("Dingdingding! You have leveled up to Intermediate!");
                }
                break;
        }

    }
}
