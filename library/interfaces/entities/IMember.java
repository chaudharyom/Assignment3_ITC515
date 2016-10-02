package library.interfaces.entities;

import java.util.List;

public abstract interface IMember {

    public static final int LOAN_LIMIT = 5;
    public static final float FINE_LIMIT = 10.0F;

    public abstract boolean hasOverDueLoans();

    public abstract boolean hasReachedLoanLimit();

    public abstract boolean hasFinesPayable();

    public abstract boolean hasReachedFineLimit();

    public abstract float getFineAmount();

    public abstract void addFine(float paramFloat);

    public abstract void payFine(float paramFloat);

    public abstract void addLoan(ILoan paramILoan);

    public abstract List<ILoan> getLoans();

    public abstract void removeLoan(ILoan paramILoan);

    public abstract EMemberState getState();

    public abstract String getFirstName();

    public abstract String getLastName();

    public abstract String getContactPhone();

    public abstract String getEmailAddress();

    public abstract int getID();
}
