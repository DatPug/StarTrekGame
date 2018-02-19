package CombatSpace;

import java.io.IOException;
import java.util.Scanner;

public class Game {

  public static void main(String[] args) throws IOException, InterruptedException {

    OnePlayerTurn opt = new OnePlayerTurn();
    ChooseShips choose = new ChooseShips();
    Game game = new Game();

    choose.chooseShips();
    Object Ship1 = ChooseShips.x;
    Object Ship2 = ChooseShips.y;

    opt.onePlayerTurn(Ship1, Ship2);

    game.pause();

  }

  private void pause() {
    System.out.println("\nPress enter to close");
    @SuppressWarnings("resource")
    Scanner pause = new Scanner(System.in);
    pause.nextLine();

  }
}
