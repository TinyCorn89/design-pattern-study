public class Director {
	private Builder builder;
	public Director(Builder builder) {
		this.builder = builder;
	}
	public void construct() {
		builder.makeTitle("Greeting");
		builder.makeString("朝から昼にかけて");
		builder.makeItems(new String[]{
			"おはよう",
			"こんにちわ",
		});
		builder.makeString("夜に");
		builder.makeItems(new String[]{
			"こんばんわ",
			"おやすみ",
			"さよなら",
		});
		builder.close();
	}
}
