package library;

import java.util.Calendar;
import java.util.Date;
import javax.swing.SwingUtilities;
import library.daos.BookHelper;
import library.daos.BookMapDAO;
import library.daos.LoanHelper;
import library.daos.LoanMapDAO;
import library.daos.MemberHelper;
import library.daos.MemberMapDAO;
import library.hardware.CardReader;
import library.hardware.Display;
import library.hardware.Printer;
import library.hardware.Scanner;
import library.interfaces.IMainListener;
import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.daos.IMemberDAO;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;
import library.panels.MainPanel;

public class Main implements IMainListener {

    private CardReader reader;
    private Scanner scanner;
    private Printer printer;
    private Display display;
    private IBookDAO bookDAO;
    private ILoanDAO loanDAO;
    private IMemberDAO memberDAO;

    public Main() {
        this.bookDAO = new BookMapDAO(new BookHelper());
        this.loanDAO = new LoanMapDAO(new LoanHelper());
        this.memberDAO = new MemberMapDAO(new MemberHelper());

        this.reader = new CardReader();
        this.scanner = new Scanner();
        this.printer = new Printer();
        this.display = new Display();

        setupTestData();
    }

    public void showGUI() {
        this.reader.setVisible(true);
        this.scanner.setVisible(true);
        this.printer.setVisible(true);
        this.display.setVisible(true);
    }

    public void borrowBooks() {
        final BorrowUC_CTL ctl = new BorrowUC_CTL(this.reader, this.scanner, this.printer, this.display,
                this.bookDAO, this.loanDAO, this.memberDAO);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ctl.initialise();
            }
        });
    }

    private void setupTestData() {
        IBook[] book = new IBook[15];
        IMember[] member = new IMember[6];

        book[0] = this.bookDAO.addBook("author1", "title1", "callNo1");
        book[1] = this.bookDAO.addBook("author1", "title2", "callNo2");
        book[2] = this.bookDAO.addBook("author1", "title3", "callNo3");
        book[3] = this.bookDAO.addBook("author1", "title4", "callNo4");
        book[4] = this.bookDAO.addBook("author2", "title5", "callNo5");
        book[5] = this.bookDAO.addBook("author2", "title6", "callNo6");
        book[6] = this.bookDAO.addBook("author2", "title7", "callNo7");
        book[7] = this.bookDAO.addBook("author2", "title8", "callNo8");
        book[8] = this.bookDAO.addBook("author3", "title9", "callNo9");
        book[9] = this.bookDAO.addBook("author3", "title10", "callNo10");
        book[10] = this.bookDAO.addBook("author4", "title11", "callNo11");
        book[11] = this.bookDAO.addBook("author4", "title12", "callNo12");
        book[12] = this.bookDAO.addBook("author5", "title13", "callNo13");
        book[13] = this.bookDAO.addBook("author5", "title14", "callNo14");
        book[14] = this.bookDAO.addBook("author5", "title15", "callNo15");
        member[0] = this.memberDAO.addMember("fName0", "lName0", "0001", "email0");
        member[1] = this.memberDAO.addMember("fName1", "lName1", "0002", "email1");
        member[2] = this.memberDAO.addMember("fName2", "lName2", "0003", "email2");
        member[3] = this.memberDAO.addMember("fName3", "lName3", "0004", "email3");
        member[4] = this.memberDAO.addMember("fName4", "lName4", "0005", "email4");
        member[5] = this.memberDAO.addMember("fName5", "lName5", "0006", "email5");

        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();

        for (int i = 0; i < 2; i++) {
            ILoan loan = this.loanDAO.createLoan(member[1], book[i]);
            this.loanDAO.commitLoan(loan);
        }
        cal.setTime(now);
        cal.add(5, 15);
        Date checkDate = cal.getTime();
        this.loanDAO.updateOverDueStatus(checkDate);

        member[2].addFine(10.0F);

        for (int i = 2; i < 7; i++) {
            ILoan loan = this.loanDAO.createLoan(member[3], book[i]);
            this.loanDAO.commitLoan(loan);
        }

        member[4].addFine(5.0F);

        for (int i = 7; i < 9; i++) {
            ILoan loan = this.loanDAO.createLoan(member[5], book[i]);
            this.loanDAO.commitLoan(loan);
        }
    }

    public static void main(String[] args) {
        final Main main = new Main();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                main.display.setDisplay(new MainPanel(main), "Main Menu");
                main.showGUI();
            }
        });
    }
}
