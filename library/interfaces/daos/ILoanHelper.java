package library.interfaces.daos;

import java.util.Date;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public abstract interface ILoanHelper {

    public abstract ILoan makeLoan(IBook paramIBook, IMember paramIMember, Date paramDate1, Date paramDate2);
}
