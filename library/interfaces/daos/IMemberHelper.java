package library.interfaces.daos;

import library.interfaces.entities.IMember;

public abstract interface IMemberHelper {

    public abstract IMember makeMember(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
}
