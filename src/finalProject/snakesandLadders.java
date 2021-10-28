package finalProject;

class snakesandLadders {
	private int Round;
	private int oldStep1;
	private int Dice1;
	private int newStep1;
	private int oldStep2;
	private int Dice2;
	private int newStep2;
	protected int Point1;
	protected int Point2;
	public int getRound() {
		return Round;
	}
	public int getOldStep1() {
		return oldStep1;
	}
	public int getDice1() {
		return Dice1;
	}
	public snakesandLadders(int round, int oldStep1, int dice1, int newStep1, int oldStep2, int dice2, int newStep2) {
		super();
		Round = round;
		this.oldStep1 = oldStep1;
		Dice1 = dice1;
		this.newStep1 = newStep1;
		this.oldStep2 = oldStep2;
		Dice2 = dice2;
		this.newStep2 = newStep2;
	}
	public void setRound(int round) {
		Round = round;
	}
	public void setOldStep1(int oldStep1) {
		this.oldStep1 = oldStep1;
	}
	public void setDice1(int dice1) {
		Dice1 = dice1;
	}
	public void setNewStep1(int newStep1) {
		this.newStep1 = newStep1;
	}
	public void setOldStep2(int oldStep2) {
		this.oldStep2 = oldStep2;
	}
	public void setDice2(int dice2) {
		Dice2 = dice2;
	}
	public void setNewStep2(int newStep2) {
		this.newStep2 = newStep2;
	}
	public int getNewStep1() {
		return newStep1;
	}
	public int getOldStep2() {
		return oldStep2;
	}
	public int getDice2() {
		return Dice2;
	}
	public int getNewStep2() {
		return newStep2;
	}

}

