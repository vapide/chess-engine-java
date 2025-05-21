public class Player {
  private final String name;
  private final boolean color;
  private boolean kingMoved;

  public Player(String name, boolean color) {
    this.name = name;
    this.color = color;
  }

  public String getName() {
    return name;
  }

  public boolean getColor() {
    return color;
  }

  public boolean canCastle() {
    return kingMoved;
  }

}