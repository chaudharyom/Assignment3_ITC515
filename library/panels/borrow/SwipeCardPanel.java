package library.panels.borrow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import library.interfaces.IBorrowUIListener;

public class SwipeCardPanel
        extends ABorrowPanel {

    private static final long serialVersionUID = 1L;
    private JLabel lblErrMesg;

    public SwipeCardPanel(final IBorrowUIListener listener) {
        setLayout(null);
        setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Borrow Book - Initialized", 4, 2, null, new Color(0, 0, 0)));
        setBounds(12, 23, 460, 640);

        JLabel lblSwipeCard = new JLabel("Swipe Card Please");
        lblSwipeCard.setHorizontalAlignment(0);
        lblSwipeCard.setFont(new Font("Tahoma", 0, 42));
        lblSwipeCard.setBounds(12, 181, 436, 78);
        add(lblSwipeCard);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                listener.cancelled();
            }
        });
        btnCancel.setFont(new Font("Tahoma", 0, 14));
        btnCancel.setBounds(170, 320, 127, 35);
        add(btnCancel);

        this.lblErrMesg = new JLabel();
        this.lblErrMesg.setForeground(Color.RED);
        this.lblErrMesg.setFont(new Font("Tahoma", 1, 14));
        this.lblErrMesg.setBounds(12, 592, 434, 29);
        add(this.lblErrMesg);
    }

    public void displayErrorMessage(String errorMesg) {
        this.lblErrMesg.setText(errorMesg);
    }
}
