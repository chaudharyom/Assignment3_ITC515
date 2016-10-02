package library.interfaces.entities;

public abstract interface IBook {

    public abstract void borrow(ILoan paramILoan);

    public abstract ILoan getLoan();

    public abstract void returnBook(boolean paramBoolean);

    public abstract void lose();

    public abstract void repair();

    public abstract void dispose();

    public abstract EBookState getState();

    public abstract String getAuthor();

    public abstract String getTitle();

    public abstract String getCallNumber();

    public abstract int getID();
}
