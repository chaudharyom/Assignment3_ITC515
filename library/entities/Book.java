/*     */ package library.entities;
/*     */ 
/*     */ import library.interfaces.entities.EBookState;
/*     */ import library.interfaces.entities.IBook;
/*     */ import library.interfaces.entities.ILoan;
/*     */ 
/*     */ 
/*     */ public class Book 
/*     */   implements IBook
/*     */ {
/*     */   private String author;
/*     */   private String title;
/*     */   private String callNumber;
/*     */   private int id;
/*     */   private ILoan loan;
/*     */   private EBookState state;
/*     */   
/*     */   public Book(String author, String title, String callNumber, int bookID)
/*     */   {
/*  20 */     if (!sane(author, title, callNumber, bookID)) {
/*  21 */       throw new IllegalArgumentException("Member: constructor : bad parameters");
/*     */     }
/*  23 */     this.author = author;
/*  24 */     this.title = title;
/*  25 */     this.callNumber = callNumber;
/*  26 */     this.id = bookID;
/*  27 */     this.state = EBookState.AVAILABLE;
/*  28 */     this.loan = null;
/*     */   }
/*     */   
/*     */   private boolean sane(String author, String title, String callNumber, int bookID)
/*     */   {
/*  33 */     return (author != null) && (!author.isEmpty()) && 
/*  34 */       (title != null) && (!title.isEmpty()) && 
/*  35 */       (callNumber != null) && (!callNumber.isEmpty()) && (
/*  36 */       bookID > 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void borrow(ILoan loan)
/*     */   {
/*  43 */     if (loan == null) {
/*  44 */       throw new IllegalArgumentException(String.format("Book: borrow : Bad parameter: loan cannot be null", new Object[0]));
/*     */     }
/*  46 */     if (this.state != EBookState.AVAILABLE) {
/*  47 */       throw new RuntimeException(String.format("Illegal operation in state : %s", new Object[] { this.state }));
/*     */     }
/*  49 */     this.loan = loan;
/*  50 */     this.state = EBookState.ON_LOAN;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ILoan getLoan()
/*     */   {
/*  57 */     return this.loan;
/*     */   }
/*     */   
/*     */ 
/*     */   public void returnBook(boolean damaged)
/*     */   {
/*  63 */     if ((this.state != EBookState.ON_LOAN) && (this.state != EBookState.LOST)) {
/*  64 */       throw new RuntimeException(String.format("Illegal operation in state : %s", new Object[] { this.state }));
/*     */     }
/*  66 */     this.loan = null;
/*  67 */     if (damaged) {
/*  68 */       this.state = EBookState.DAMAGED;
/*     */     }
/*     */     else {
/*  71 */       this.state = EBookState.AVAILABLE;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void lose()
/*     */   {
/*  78 */     if (this.state != EBookState.ON_LOAN) {
/*  79 */       throw new RuntimeException(String.format("Illegal operation in state : %s", new Object[] { this.state }));
/*     */     }
/*  81 */     this.state = EBookState.LOST;
/*     */   }
/*     */   
/*     */ 
/*     */   public void repair()
/*     */   {
/*  87 */     if (this.state != EBookState.DAMAGED) {
/*  88 */       throw new RuntimeException(String.format("Illegal operation in state : %s", new Object[] { this.state }));
/*     */     }
/*  90 */     this.state = EBookState.AVAILABLE;
/*     */   }
/*     */   
/*     */ 
/*     */   public void dispose()
/*     */   {
/*  96 */     if ((this.state != EBookState.AVAILABLE) && (this.state != EBookState.DAMAGED) && (this.state != EBookState.LOST)) {
/*  97 */       throw new RuntimeException(String.format("Illegal operation in state : %s", new Object[] { this.state }));
/*     */     }
/*  99 */     this.state = EBookState.DISPOSED;
/*     */   }
/*     */   
/*     */ 
/*     */   public EBookState getState()
/*     */   {
/* 105 */     return this.state;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getAuthor()
/*     */   {
/* 111 */     return this.author;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 117 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getCallNumber()
/*     */   {
/* 123 */     return this.callNumber;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getID()
/*     */   {
/* 129 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 135 */     return String.format("Id: %d\nAuthor: %s\nTitle: %s\nCall Number %s", new Object[] {
/* 136 */       Integer.valueOf(this.id), this.author, this.title, this.callNumber });
/*     */   }
/*     */ }


