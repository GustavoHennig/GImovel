package gimovel.jogo;

import java.util.Random;

public class Dado {
    public Dado() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    Random r = new Random();

    public int getIntDados() {

        int ret = 0;

        ret = r.nextInt(6);

        return ret + 1;
    }

    private int getRandom() {
        int ret = 0;
        while (ret < 1 | ret > 255) {
            ret = (int) (Math.random() * 150);
        }
        return ret;
    }

    private void jbInit() throws Exception {
    }


}
