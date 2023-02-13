package combination.backtrack_core;

import java.util.ArrayList;

public abstract class BK_Problem extends ArrayList<Variable> {

    protected ArrayList<Proposal> solutions = null;
    protected Proposal proposal = null;
    private int nWanted = -1;

    public BK_Problem() {
        super();
    }

    public void addVar(Domain D) {
        this.add(new Variable(D));
    }

    protected void addSolution() {
        Proposal newSol = new Proposal();
        for (Object x : proposal) {
            if (x != null) {
                newSol.add(x);
            }
        }
        solutions.add(newSol);
    }

    protected abstract boolean accepted();

    protected abstract boolean accepted(int i, Object val);

    private void backtrack(int index) {
        if (solutions.size() == nWanted) {
            return;
        }
        int n = this.size();
        Variable v = this.get(index);
        Domain D = v.D;
        for (Object val : D) {
            if (solutions.size() == nWanted) {
                return;
            }
            proposal.removeFrom(index);
            if (accepted(index, val)) {
                v.val = val;
                if (index < n - 1) {
                    backtrack(index + 1);
                } else if (accepted()) {
                    addSolution();
                }
            }
        }
    }

    public ArrayList<Proposal> bkSolve(int nSolution) {
        nWanted = nSolution;
        solutions = new ArrayList();
        proposal = new Proposal();
        backtrack(0);
        return solutions;
    }

    public ArrayList<Proposal> bkSolve() {
        return bkSolve(-1);
    }
}
