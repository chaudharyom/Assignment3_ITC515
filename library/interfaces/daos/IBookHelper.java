package library.interfaces.daos;

import library.interfaces.entities.IBook;

public abstract interface IBookHelper {

    public abstract IBook makeBook(String paramString1, String paramString2, String paramString3, int paramInt);
}
