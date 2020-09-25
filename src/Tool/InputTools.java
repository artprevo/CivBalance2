package Tool;

import java.util.Scanner;

public class InputTools {

    public int tierInput() {
        Scanner scanner = new Scanner(System.in);
        int tierChosen = scanner.nextInt();
        while (tierChosen > 7 || tierChosen < 1) {
            System.out.println("Why u so smart");
            tierChosen = scanner.nextInt();
        }
        return tierChosen;
    }
}
