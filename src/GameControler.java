import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameControler {
    private int digits, times;
    private int[] answer, input;
    private HashMap<Integer,Integer> map;

    GameControler() {
        digits = 0;
        times = 0;
        map = new HashMap();
    }

    public boolean isGameOver() {
        if (digits > 0) {
            int r = 0, w = 0;
            for (int n = 0; n < digits; n++) {
                if (answer[n] == input[n])
                    r++;
                else {
                    for (int m = 0; m < digits; m++)
                        if (input[n] == answer[m]) {
                            w++;
                            break;
                        }
                }
            }
            if (r == digits) {
                GameView.showSuccess(times, answer);
                return true;
            } else {
                GameView.showFail(r, w, input);
                showTips();
                return false;
            }
        } else
            return false;
    }

    public int[] getInput() {
        return digits > 0 ? input : new int[0];
    }

    public void setInput(int put) {
        if (digits > 0) {
            for (int n = digits - 1; n >= 0; n--) {
                input[n] = put % 10;
                put /= 10;
            }
        }
    }

    public int[] getAnswer() {
        return digits > 0 ? answer : new int[0];
    }

    public void setAnswer() {
        if (digits > 0) {
            for (int n = 0; n < digits; n++) {
                answer[n] = new Random().nextInt(10);
            }
            countRepeat();
        }
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        digits = Math.min(digits, 20);
        digits = Math.max(digits, 1);
        answer = new int[digits];
        input = new int[digits];
        this.digits = digits;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes() {
        times++;
    }

    private void countRepeat() {
        int[] countArray = new int[10];
        map.clear();
        for (int i = 0; i < digits; i++) {
            countArray[answer[i]]++;
        }
        for (int n = 2; n <= digits; n++) {
            int t = 0;
            for (int m : countArray)
                if (m == n)
                    t++;
            if (t > 0) {
                GameView.showRepeat(t, n);
                map.put(t, n);
            }
        }
    }
    private void showTips(){
        if(map.isEmpty())
            return;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Object key = integerIntegerEntry.getKey();
            Object value = integerIntegerEntry.getValue();
            GameView.showRepeat((int) key, (int) value);
        }
    }
}
