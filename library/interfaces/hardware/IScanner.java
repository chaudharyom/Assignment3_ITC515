package library.interfaces.hardware;

public abstract interface IScanner {

    public abstract void addListener(IScannerListener paramIScannerListener);

    public abstract void setEnabled(boolean paramBoolean);
}
