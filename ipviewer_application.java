
/**
 * A simple viewer to look at how netmasks and ipv4 addresses work
 * 
 * @author Simon Andrews 
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.util.regex.*;
import java.awt.event.*;

public class ipviewer_application extends JFrame
{
    // instance variables - replace the example below with your own
    private JTextField ipField = new JTextField("192.168.0.1");
    private JTextField netmaskField = new JTextField("255.255.255.0");

    private NumberBox [] ipBoxes = new NumberBox[12];
    private NumberBox [] ipBinaryBoxes = new NumberBox[32];

    private NumberBox [] netmaskBoxes = new NumberBox[12];
    private NumberBox [] netmaskBinaryBoxes = new NumberBox[32];

    /**
     * Constructor for objects of class ipviewer_application
     */
    public ipviewer_application()
    {
        super("IPViewer");

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.001;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);

        JPanel ipEntryPanel = new JPanel();
        ipEntryPanel.setLayout(new BorderLayout());
        ipEntryPanel.add(new JLabel("IP Address   "),BorderLayout.WEST);
        ipEntryPanel.add(ipField,BorderLayout.CENTER);
        ipField.addKeyListener(new KeyListener () {
            public void keyPressed (KeyEvent e) {}
            public void keyReleased (KeyEvent e) {updateNumbers();}
            public void keyTyped (KeyEvent e){}
        });
        getContentPane().add(ipEntryPanel,gbc);

        gbc.gridy++;

        JPanel netmaskEntryPanel = new JPanel();
        netmaskEntryPanel.setLayout(new BorderLayout());
        netmaskEntryPanel.add(new JLabel("Netmask   "),BorderLayout.WEST);
        netmaskEntryPanel.add(netmaskField,BorderLayout.CENTER);
        netmaskField.addKeyListener(new KeyListener () {
            public void keyPressed (KeyEvent e) {}
            public void keyReleased (KeyEvent e) {updateNumbers();}
            public void keyTyped (KeyEvent e){}
        });
        getContentPane().add(netmaskEntryPanel,gbc);

        gbc.gridy++;

        getContentPane().add(new JLabel("IP Address Breakdown",JLabel.CENTER),gbc);

        gbc.gridy++;
        gbc.weighty = 0.999;
        gbc.fill = GridBagConstraints.BOTH;

        JPanel ipDecimalPanel = new JPanel();
        ipDecimalPanel.setLayout(new GridLayout(1,15));

        for (int i=0;i<ipBoxes.length;i++) {
            ipBoxes[i] = new NumberBox();
            ipBoxes[i].setNumber(i%10);
        }

        ipDecimalPanel.add(ipBoxes[0]);
        ipDecimalPanel.add(ipBoxes[1]);
        ipDecimalPanel.add(ipBoxes[2]);
        ipDecimalPanel.add(new NumberBox());
        ipDecimalPanel.add(ipBoxes[3]);
        ipDecimalPanel.add(ipBoxes[4]);
        ipDecimalPanel.add(ipBoxes[5]);
        ipDecimalPanel.add(new NumberBox());     
        ipDecimalPanel.add(ipBoxes[6]);
        ipDecimalPanel.add(ipBoxes[7]);
        ipDecimalPanel.add(ipBoxes[8]);
        ipDecimalPanel.add(new NumberBox());      
        ipDecimalPanel.add(ipBoxes[9]);
        ipDecimalPanel.add(ipBoxes[10]);
        ipDecimalPanel.add(ipBoxes[11]);

        getContentPane().add(ipDecimalPanel,gbc);

        gbc.gridy++;

        JPanel ipBinaryPanel = new JPanel();
        ipBinaryPanel.setLayout(new GridLayout(1,35));

        for (int i=0;i<ipBinaryBoxes.length;i++) {
            ipBinaryBoxes[i] = new NumberBox();
            ipBinaryBoxes[i].setNumber(i%2);
        }

        for (int i=0;i<=7;i++) {
            ipBinaryPanel.add(ipBinaryBoxes[i]);
        }
        ipBinaryPanel.add(new NumberBox());
        for (int i=8;i<=15;i++) {
            ipBinaryPanel.add(ipBinaryBoxes[i]);
        }
        ipBinaryPanel.add(new NumberBox());
        for (int i=16;i<=23;i++) {
            ipBinaryPanel.add(ipBinaryBoxes[i]);
        }
        ipBinaryPanel.add(new NumberBox());
        for (int i=24;i<=31;i++) {
            ipBinaryPanel.add(ipBinaryBoxes[i]);
        }

        getContentPane().add(ipBinaryPanel,gbc);
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        getContentPane().add(new JLabel("Netmask Address Breakdown",JLabel.CENTER),gbc);

        gbc.gridy++;
        gbc.weighty = 0.999;
        gbc.fill = GridBagConstraints.BOTH;

        JPanel netmaskDecimalPanel = new JPanel();
        netmaskDecimalPanel.setLayout(new GridLayout(1,15));

        for (int i=0;i<netmaskBoxes.length;i++) {
            netmaskBoxes[i] = new NumberBox();
            netmaskBoxes[i].setNumber(i%10);
        }

        netmaskDecimalPanel.add(netmaskBoxes[0]);
        netmaskDecimalPanel.add(netmaskBoxes[1]);
        netmaskDecimalPanel.add(netmaskBoxes[2]);
        netmaskDecimalPanel.add(new NumberBox());
        netmaskDecimalPanel.add(netmaskBoxes[3]);
        netmaskDecimalPanel.add(netmaskBoxes[4]);
        netmaskDecimalPanel.add(netmaskBoxes[5]);
        netmaskDecimalPanel.add(new NumberBox());     
        netmaskDecimalPanel.add(netmaskBoxes[6]);
        netmaskDecimalPanel.add(netmaskBoxes[7]);
        netmaskDecimalPanel.add(netmaskBoxes[8]);
        netmaskDecimalPanel.add(new NumberBox());      
        netmaskDecimalPanel.add(netmaskBoxes[9]);
        netmaskDecimalPanel.add(netmaskBoxes[10]);
        netmaskDecimalPanel.add(netmaskBoxes[11]);

        getContentPane().add(netmaskDecimalPanel,gbc);

        gbc.gridy++;

        JPanel netmaskBinaryPanel = new JPanel();
        netmaskBinaryPanel.setLayout(new GridLayout(1,35));

        for (int i=0;i<netmaskBinaryBoxes.length;i++) {
            netmaskBinaryBoxes[i] = new NumberBox();
            netmaskBinaryBoxes[i].setNumber(i%2);
        }

        for (int i=0;i<=7;i++) {
            netmaskBinaryPanel.add(netmaskBinaryBoxes[i]);
        }
        netmaskBinaryPanel.add(new NumberBox());
        for (int i=8;i<=15;i++) {
            netmaskBinaryPanel.add(netmaskBinaryBoxes[i]);
        }
        netmaskBinaryPanel.add(new NumberBox());
        for (int i=16;i<=23;i++) {
            netmaskBinaryPanel.add(netmaskBinaryBoxes[i]);
        }
        netmaskBinaryPanel.add(new NumberBox());
        for (int i=24;i<=31;i++) {
            netmaskBinaryPanel.add(netmaskBinaryBoxes[i]);
        }

        getContentPane().add(netmaskBinaryPanel,gbc);

        updateNumbers();

        setSize(800,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    /**
     * This method takes the current content of the users entries and
     * updates the main display with those numbers.
     */
    public void updateNumbers () {
        // We're going to need a regex for IP addresses so let's make that first
        Pattern ipPattern = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

        // Start with the IP address
        Matcher ipMatcher = ipPattern.matcher(ipField.getText().trim());

        if (ipMatcher.find()) {
            // Update the ip address
            String ip1 = String.format("%03d",Integer.parseInt(ipMatcher.group(1)));
            updateNumberBoxes(ip1, ipBoxes, 0);

            String bip1 = padBinaryString(Integer.toBinaryString(Integer.parseInt(ipMatcher.group(1))),8);
            updateNumberBoxes(bip1,ipBinaryBoxes,0);

            String ip2 = String.format("%03d",Integer.parseInt(ipMatcher.group(2)));
            updateNumberBoxes(ip2, ipBoxes, 3);

            String bip2 = padBinaryString(Integer.toBinaryString(Integer.parseInt(ipMatcher.group(2))),8);
            updateNumberBoxes(bip2,ipBinaryBoxes,8);

            String ip3 = String.format("%03d",Integer.parseInt(ipMatcher.group(3)));
            updateNumberBoxes(ip3, ipBoxes, 6);

            String bip3 = padBinaryString(Integer.toBinaryString(Integer.parseInt(ipMatcher.group(3))),8);
            updateNumberBoxes(bip3,ipBinaryBoxes,16);

            String ip4 = String.format("%03d",Integer.parseInt(ipMatcher.group(4)));
            updateNumberBoxes(ip4, ipBoxes, 9);

            String bip4 = padBinaryString(Integer.toBinaryString(Integer.parseInt(ipMatcher.group(4))),8);
            updateNumberBoxes(bip4,ipBinaryBoxes,24);
        }
        else {
            // Set the address to be blank
            for (int i=0;i<ipBoxes.length;i++) {
                ipBoxes[i].clearNumber();
            }
            for (int i=0;i<ipBinaryBoxes.length;i++) {
                ipBinaryBoxes[i].clearNumber();
            }
        }
        // Now do the netmask
        Matcher netMatcher = ipPattern.matcher(netmaskField.getText().trim());

        if (netMatcher.find()) {
            // Update the netmask address
            String net1 = String.format("%03d",Integer.parseInt(netMatcher.group(1)));
            updateNumberBoxes(net1, netmaskBoxes, 0);

            String bnet1 = padBinaryString(Integer.toBinaryString(Integer.parseInt(netMatcher.group(1))),8);
            updateNumberBoxes(bnet1,netmaskBinaryBoxes,0);

            String net2 = String.format("%03d",Integer.parseInt(netMatcher.group(2)));
            updateNumberBoxes(net2, netmaskBoxes, 3);

            String bnet2 = padBinaryString(Integer.toBinaryString(Integer.parseInt(netMatcher.group(2))),8);
            updateNumberBoxes(bnet2,netmaskBinaryBoxes,8);

            String net3 = String.format("%03d",Integer.parseInt(netMatcher.group(3)));
            updateNumberBoxes(net3, netmaskBoxes, 6);

            String bnet3 = padBinaryString(Integer.toBinaryString(Integer.parseInt(netMatcher.group(3))),8);
            updateNumberBoxes(bnet3,netmaskBinaryBoxes,16);

            String net4 = String.format("%03d",Integer.parseInt(netMatcher.group(4)));
            updateNumberBoxes(net4, netmaskBoxes, 9);

            String bnet4 = padBinaryString(Integer.toBinaryString(Integer.parseInt(netMatcher.group(4))),8);
            updateNumberBoxes(bnet4,netmaskBinaryBoxes,24);
    
        }
        else {
            // Set the address to be blank
            for (int i=0;i<netmaskBoxes.length;i++) {
                netmaskBoxes[i].clearNumber();
            }
            for (int i=0;i<netmaskBinaryBoxes.length;i++) {
                netmaskBinaryBoxes[i].clearNumber();
            }
        }

    }

    private String padBinaryString (String original, int length) {
        while (original.length() < length) {
            original = "0"+original;
        }

        return(original);
    }

    private void updateNumberBoxes (String formattedString, NumberBox[] boxes, int startPosition) {
        for (int i=0;i<formattedString.toCharArray().length;i++) {
            boxes[startPosition+i].setNumber(Integer.parseInt(""+formattedString.charAt(i)));
        }
    }

    public static void main (String [] args)
    {
        new ipviewer_application();
    }

}
