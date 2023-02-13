package combination.backtrack_core;

import java.util.ArrayList;

public class Proposal extends ArrayList {

    public void removeFrom(int index) {
        for (int i = this.size() - 1; i >= index; i--) {
            this.remove(i);
        }
    }
}
