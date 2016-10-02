package library.interfaces.hardware;

public abstract interface ICardReader {

    public abstract void addListener(ICardReaderListener paramICardReaderListener);

    public abstract void setEnabled(boolean paramBoolean);
}
