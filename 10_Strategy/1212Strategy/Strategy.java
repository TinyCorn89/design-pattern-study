/**
戦略のための抽象メソッド
*/

public interface Strategy{
	public abstract Hand nextHand();
	public abstract void study(boolean win);
}