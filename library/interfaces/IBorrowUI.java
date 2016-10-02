package library.interfaces;

public abstract interface IBorrowUI {

    public abstract void setState(EBorrowState paramEBorrowState);

    public abstract void displayMemberDetails(int paramInt, String paramString1, String paramString2);

    public abstract void displayExistingLoan(String paramString);

    public abstract void displayOverDueMessage();

    public abstract void displayAtLoanLimitMessage();

    public abstract void displayOutstandingFineMessage(float paramFloat);

    public abstract void displayOverFineLimitMessage(float paramFloat);

    public abstract void displayScannedBookDetails(String paramString);

    public abstract void displayPendingLoan(String paramString);

    public abstract void displayConfirmingLoan(String paramString);

    public abstract void displayErrorMessage(String paramString);
}
