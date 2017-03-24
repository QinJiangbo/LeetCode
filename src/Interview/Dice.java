package Interview;

/**
 * @date: 24/03/2017 8:11 PM
 * @author: qinjiangbo@github.io
 */
public class Dice {

    private int left;
    private int right;
    private int front;
    private int behind;
    private int top;
    private int bottom;

    public Dice(int left, int right, int front, int behind, int top, int bottom) {
        this.left = left;
        this.right = right;
        this.front = front;
        this.behind = behind;
        this.top = top;
        this.bottom = bottom;
    }

    private void L() {
        int tmp = this.left;
        this.left = this.top;
        this.top = this.right;
        this.right = this.bottom;
        this.bottom = tmp;
    }

    private void R() {
        int tmp = this.right;
        this.right = this.top;
        this.top = this.left;
        this.left = this.bottom;
        this.bottom = tmp;
    }

    private void F() {
        int tmp = this.front;
        this.front = this.top;
        this.top = this.behind;
        this.behind = this.bottom;
        this.bottom = tmp;
    }

    private void B() {
        int tmp = this.behind;
        this.behind = this.top;
        this.top = this.front;
        this.front = this.bottom;
        this.bottom = tmp;
    }

    private void C() {
        int tmp = this.front;
        this.front = this.right;
        this.right = this.behind;
        this.behind = this.left;
        this.left = tmp;
    }

    private void A() {
        int tmp = this.front;
        this.front = this.left;
        this.left = this.behind;
        this.behind = this.right;
        this.right = tmp;
    }

    private void transfer(String rule) {
        char[] rules = rule.toCharArray();
        for (char r: rules) {
            switch (r) {
                case 'L':
                    L();
                    break;
                case 'R':
                    R();
                    break;
                case 'F':
                    F();
                    break;
                case 'B':
                    B();
                    break;
                case 'A':
                    A();
                    break;
                case 'C':
                    C();
                    break;
            }
        }
    }


    @Override
    public String toString() {
        return left + "" + right + "" + front + "" + behind + "" + top + "" + bottom;
    }

    public static void main(String[] args) {
        Dice dice = new Dice(1, 2, 3, 4, 5, 6);
        dice.transfer("RA");
        System.out.println(dice);
    }


}
