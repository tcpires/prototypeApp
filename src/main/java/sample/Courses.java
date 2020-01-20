package sample;

public class Courses {

    private boolean ctl = false;
    private boolean maturidade = false;
    private boolean ceifeiros = false;

    public Courses() {
    }

    public Courses(boolean ctl, boolean maturidade, boolean ceifeiros) {
        this.ctl = ctl;
        this.maturidade = maturidade;
        this.ceifeiros = ceifeiros;
    }

    public boolean isCtl() {
        return ctl;
    }

    public void setCtl(boolean ctl) {
        this.ctl = ctl;
    }

    public boolean isMaturidade() {
        return maturidade;
    }

    public void setMaturidade(boolean maturidade) {
        this.maturidade = maturidade;
    }

    public boolean isCeifeiros() {
        return ceifeiros;
    }

    public void setCeifeiros(boolean ceifeiros) {
        this.ceifeiros = ceifeiros;
    }
}
