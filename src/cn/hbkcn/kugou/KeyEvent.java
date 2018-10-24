package cn.hbkcn.kugou;

import java.awt.*;
import java.io.IOException;

// Create at 2018-7-20 16:03 by 3243430237@qq.com
// TODO: 按下事件
public class KeyEvent {
    private Robot robot;

    public KeyEvent() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void runCmd(String cmd) {
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void win(int code) {
        press(KeyCode.Controls.WIN);
        press(code);
        release(code);
        release(KeyCode.Controls.WIN);
    }

    public void alt_shift(int code) {
        press(KeyCode.Controls.ALT);
        press(KeyCode.Controls.SHIFT);
        press(code);

        release(code);
        release(KeyCode.Controls.SHIFT);
        release(KeyCode.Controls.ALT);
    }

    public void ctrl_shift(int code) {
        press(KeyCode.Controls.CTRL);
        press(KeyCode.Controls.SHIFT);
        press(code);

        release(code);
        release(KeyCode.Controls.SHIFT);
        release(KeyCode.Controls.CTRL);
    }

    public void ctrl_alt(int code) {
        press(KeyCode.Controls.CTRL);
        press(KeyCode.Controls.ALT);
        press(code);

        release(code);
        release(KeyCode.Controls.ALT);
        release(KeyCode.Controls.CTRL);
    }

    public void shift(int code) {
        press(KeyCode.Controls.SHIFT);
        press(code);
        release(code);
        release(KeyCode.Controls.SHIFT);
    }

    public void alt(int code) {
        press(KeyCode.Controls.ALT);
        press(code);
        release(code);
        release(KeyCode.Controls.ALT);
    }

    public void ctrl(int code) {
        press(KeyCode.Controls.CTRL);
        press(code);
        release(code);
        release(KeyCode.Controls.CTRL);
    }

    public void press(int code){
        robot.keyPress(code);
    }

    public void release(int code) {
        robot.keyRelease(code);
    }
}
