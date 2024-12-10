//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println(canPack (1, 0, 6));
        System.out.println(canPack (1, 0, 4));
        System.out.println(canPack (1, 0, 5));
        System.out.println(canPack (0, 5, 4));
        System.out.println(canPack (2, 2, 11));
        System.out.println(canPack (-3, 2, 12));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        // declare the size of big and small flour bag
        int bigWeight = 5;
        int smallWeight = 1;

        // In case any parameter passed as negative
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        // If all bag can be packed without any waste space
        if (((bigCount * bigWeight) + (smallCount * smallWeight)) == goal) {
            return true;
        } else {

            // First try to pack big bags
            while (bigCount != 0) {

                if ((bigCount * bigWeight) <= goal) {
                    goal -= bigCount * bigWeight;
                    break;
                }

                bigCount--;
            }

            // Now pack small bags
            while (smallCount != 0) {

                if ((smallCount * smallWeight) <= goal) {
                    goal -= smallCount * smallWeight;
                    break;
                }

                smallCount--;
            }

            // Cannot pack if there is still space
            return goal == 0;
        }
    }
}