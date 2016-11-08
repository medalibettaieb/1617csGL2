package tn.esprit.cs.g2.entities;

public enum Right {
	READ(100), WRITE(200), EDITOR(300);

	private int value;

	Right(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Right parse(int id) {
		Right right = null; // Default
		for (Right item : Right.values()) {
			if (item.getValue() == id) {
				right = item;
				break;
			}
		}
		return right;
	}

}