package library.interfaces.hardware;

import javax.swing.JPanel;

public abstract interface IDisplay {

    public abstract JPanel getDisplay();

    public abstract void setDisplay(JPanel paramJPanel, String paramString);
}
