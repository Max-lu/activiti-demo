package cn;

import java.io.Serializable;

/**
 * Created by max.lu on 2016/3/17.
 */
public class JavaBean implements Serializable{

    private static final long serialVersionUID = 5641838728443191139L;

    private boolean right;

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
