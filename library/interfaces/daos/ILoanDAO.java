package library.interfaces.daos;

import java.util.Date;
import java.util.List;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public abstract interface ILoanDAO {

    public abstract ILoan createLoan(IMember paramIMember, IBook paramIBook);

    public abstract void commitLoan(ILoan paramILoan);

    public abstract ILoan getLoanByID(int paramInt);

    public abstract ILoan getLoanByBook(IBook paramIBook);

    public abstract List<ILoan> listLoans();

    public abstract List<ILoan> findLoansByBorrower(IMember paramIMember);

    public abstract List<ILoan> findLoansByBookTitle(String paramString);

    public abstract void updateOverDueStatus(Date paramDate);

    public abstract List<ILoan> findOverDueLoans();
}
