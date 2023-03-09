public class Player {
  private String name;
  private boolean color;
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