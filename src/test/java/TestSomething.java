import org.junit.Test;

import java.util.Random;

public class TestSomething {
    static Random random = new Random();

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getNumber(10) == 1);
        }
    }

    /**
     * 获取概率结果
     *
     * @param percent 百分比概率出现1,返回0的概率是1-percent%
     * @return
     */
    private static int getNumber(int percent) {
        return random.nextInt(100) >= percent ? 1 : 0;
    }
}
