/**
 * A program to sort japanese verbs! For Science!
 *
 * @author Anne Farrell
 * @version 5-15-2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerbSorter2 extends JFrame
{
    private JTextField verbField;
    private JLabel answer;
    private ImageIcon icon1;
    private JLabel artLabel;
    private JPanel artPanel;

    public VerbSorter2()
    {
        //setup frame and title
        setSize(600, 400);
        setTitle("Japanese Verb Sorter - \u3044\u3044\u3067\u3059\u306d!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //cat image
        icon1 = new ImageIcon("catcomp.png");
        Image cat = icon1.getImage();
        Image modifiedCat = cat.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        ImageIcon modifiedIcon = new ImageIcon(modifiedCat);
        artLabel = new JLabel(modifiedIcon);
        artPanel = new JPanel();
        artPanel.add(artLabel);
        
        
        //create instructions (a label) and a text field to enter a verb
        JLabel label = new JLabel("\u3053\u3093\u306b\u3061\u306f! Please enter your verb in hiragana: ");
        verbField = new JTextField(20);
        
        //create an action button
        JButton button = new JButton("SUBMIT");
        ActionButtonHandler abHandler = new ActionButtonHandler();
        button.addActionListener(abHandler);
        
        //create a clear the screen button
        JButton button2 = new JButton("CLEAR");
        ClearButtonHandler clHandler = new ClearButtonHandler();
        button2.addActionListener(clHandler);
        
        //establish the space to write the answer
        answer = new JLabel("");

        //make a main panel, center justified
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 25, 25));
           
        //add components to sub-panels
        JPanel panel1 = new JPanel();
        panel1.add(label);
        JPanel panel2 = new JPanel();
        panel2.add(verbField);
        JPanel panel3 = new JPanel();
        panel3.add(button);
        panel3.add(button2);
        JPanel panel4 = new JPanel();
        panel4.add(answer);
        
        //add panels to the main panel
        mainPanel.add(artPanel);
        mainPanel.add(panel1);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        add(mainPanel);
        
        //make it so!
        setVisible(true);   
    }
    
    //class to make the button Do A Thing
    private class ActionButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //our variable is the text in the input field
            String verb = verbField.getText();
        
            if (verb.isEmpty())
            {
                //angry guy (not visible unless the user fails to enter text properly)
                ImageIcon icon2 = new ImageIcon("no.png");
                Image angy = icon2.getImage();
                Image modifiedAngy = angy.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
                ImageIcon modifiedIcon2 = new ImageIcon(modifiedAngy);
                artLabel.setIcon(modifiedIcon2);
                
                
                answer.setText("Please enter a verb, ya dingus!");
                return; // Exit the method early if the field is empty
            }
            else if (verb.matches(".*[a-zA-Z0-9].*")) 
            {
                ImageIcon icon2 = new ImageIcon("no.png");
                Image angy = icon2.getImage();
                Image modifiedAngy = angy.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
                ImageIcon modifiedIcon2 = new ImageIcon(modifiedAngy);
                artLabel.setIcon(modifiedIcon2);
                
                
                answer.setText("Please use hiragana characters only, ya dingus!");
                return;
            }
            else
            {
                //happy lady png!
                ImageIcon icon3 = new ImageIcon("yay.png");
                Image yay = icon3.getImage();
                Image modifiedYay = yay.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
                ImageIcon modifiedIcon3 = new ImageIcon(modifiedYay);
                artLabel.setIcon(modifiedIcon3);
                
                int n = verb.length();
            
                //If the verb is ã?™ã‚‹ã€€or ã??ã‚‹
                if (verb.equals("\u3059\u308B") || verb.equals("\u304F\u308B"))
                {
                    answer.setText("Your verb is IRreGulAr!");
                }
                else if (verb.endsWith("\u3059\u308B"))
                {
                    answer.setText("Your verb is a \u3059\u308B verb, friend!");
                }
                //if the verb is ã?‹ã?ˆã‚‹
                else if (verb.equals("\u304B\u3048\u308B"))
                {
                answer.setText("Your verb is an \u3046-verb!");
                }
                //if the verb is ã?¯ã?„ã‚‹
                else if (verb.equals("\u306F\u3044\u308B"))
                {
                    answer.setText("Your verb is an \u3046-verb!");
                }
                //so you have a verb that ends with -ã‚‹...
                else if (verb.endsWith("\u308B"))
                {
                    //Does it end with -eru, or -iru?
                    char precedingChar = verb.charAt(n - 2); // Get the character before "ã‚‹"
                    String eruIruBefore = "\u306D\u3081\u307E\u3078\u3079\u307A\u307D\u307C" + 
                            "\u306F\u308C\u3066\u3067\u305B\u305D\u305C\u305E\u3059" + 
                            "\u308A\u307F\u307F\u307B\u3072\u3074\u3073\u306B\u3062" + 
                            "\u3061\u3057\u3058\u304E\u304D\u304E\u304D\u3044";
                    //if so, you have a ã‚‹ verb.
                    if (eruIruBefore.contains(String.valueOf(precedingChar)))
                    {
                        answer.setText("<html>Your verb is a \u308B-verb! <br>(Note, there are some exceptions to this rule that we haven't <br>learned yet, and that won't be included in this program. Yet.)</html>");
                    }
                    //if not, you've got an ã?†ã€€verb, friend!
                    else
                    {
                        answer.setText("Your verb is an \u3046-verb!");
                    }
                }
                //doesn't end in ã‚‹? Tis an ã?† verb!
                else
                {
                    answer.setText("Your verb is an \u3046-verb!");
                }
            }
        }
    }
    
    private class ClearButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            ImageIcon icon4 = new ImageIcon("catcomp.png");
            Image cat = icon4.getImage();
            Image modifiedCat = cat.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
            ImageIcon modifiedIcon4 = new ImageIcon(modifiedCat);
            artLabel.setIcon(modifiedIcon4);
            
            verbField.setText("");
            answer.setText("");
        }
    }
    public static void main(String[] args)
    {
        VerbSorter2 verbSorter = new VerbSorter2();
    }
}
