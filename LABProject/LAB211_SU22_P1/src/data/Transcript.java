package data;

public class Transcript {

    public Student st;
    public Subject sub;
    double labMark;
    double testMark;
    double finalMark;

    public Transcript(Student st, Subject sub, double labMark, double testMark, double finalMark) {
        this.st = st;
        this.sub = sub;
        this.labMark = labMark;
        this.testMark = testMark;
        this.finalMark = finalMark;
    }

    public double average() {
        return 0.3 * labMark + 0.3 * testMark + 0.4 * finalMark;
    }

    public Transcript(Student st, Subject sub) {
        this.st = st;
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "Lab Mark: " + labMark + ", " + "Test Mark:  " + testMark + ", " + "Final mark: " + finalMark;
    }

    @Override
    public boolean equals(Object obj) {
        Transcript t = (Transcript) obj;
        return this.st == t.st && this.sub == t.sub;
    }
}
