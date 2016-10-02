package library.interfaces.entities;

import java.util.Date;

public abstract interface ILoan {

    public static final int LOAN_PERIOD = 14;

    public abstract void commit(int paramInt);

    public abstract void complete();

    public abstract boolean isOverDue();

    public abstract boolean checkOverDue(Date paramDate);

    public abstract IMember getBorrower();

    public abstract IBook getBook();

    public abstract int getID();
}
