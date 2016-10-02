package library.interfaces;

public abstract interface IBorrowUIListener {

    public abstract void cancelled();

    public abstract void scansCompleted();

    public abstract void loansConfirmed();

    public abstract void loansRejected();
}
