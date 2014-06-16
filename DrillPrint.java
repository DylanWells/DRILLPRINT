import javax.swing.SwingUtilities; 

import javax.swing.JSplitPane;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.Box;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

import java.io.File;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.text.Document;

import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.FontFormatException;
import java.io.IOException;
import java.lang.NullPointerException;

import java.awt.font.LineMetrics;
import java.awt.FontMetrics;

import java.util.ArrayList;
import java.lang.StringBuilder;

import java.lang.Integer;
// maybe...
//import javax.swing.OverlayLayout;

public class DrillPrint {

    public ImageLoader img;
    public GUIbuild gui;
    public Container shift;
    public Graphics artist;
    public JLayeredPane shifter;
    
    DrillPrint() {
        img = new ImageLoader();
        shifter = new JLayeredPane();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()  {
                gui = new GUIbuild();
            }
        });        
    }
    
    private class GUIbuild extends JFrame {

        private MyCanvas canvas;
        private JPanel background;
        private JPanel logo;
        private JScrollPane textBody;
    
        private MyButton draw, clearCan;
        private MyButton save, load;
        private MyButton add, clearS;
        private MyButton point, speed;

        GUIbuild() {
            super("DRILLPRINT");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            MyEditor editor = new MyEditor();
            MyCanvas canvas = new MyCanvas();
/*
            textBody = new JScrollPane(editor);
            textBody.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            textBody.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            shift = new Container();
*/

            draw = new MyButton(img.buttons("draw"));
            clearCan = new MyButton(img.buttons("clear"));
            save = new MyButton(img.buttons("save"));
            load = new MyButton(img.buttons("load"));
            add = new MyButton(img.buttons("add"));
            clearS = new MyButton(img.buttons("clearScr"));
            point = new MyButton(img.buttons("point"));
            speed = new MyButton(img.buttons("speed"));  

            JPanel bagPanel = (new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    img.load("bground").paintIcon(this,g,0,0);
                    img.load("logoType").paintIcon(this,g,550,50);
                }
            });
            
            GridBagLayout bagStruct = new GridBagLayout();
            GridBagConstraints bagCons = new GridBagConstraints();
            bagPanel.setLayout(bagStruct);
            
            bagCons.insets = new Insets(48,50,0,0);
            bagCons.anchor = GridBagConstraints.NORTHWEST;
            bagCons.fill = GridBagConstraints.NONE;
            bagCons.gridx = 0;
            bagCons.gridy = 0;
            bagCons.weightx = 1;
            bagCons.weighty = 0;
            bagCons.gridheight = 18;
            bagCons.gridwidth = 18;
            bagStruct.setConstraints(canvas,bagCons);
            bagPanel.add(canvas);
            
            bagCons.insets = new Insets(0,50,50,0);
            bagCons.anchor = GridBagConstraints.SOUTHWEST;
            bagCons.fill = GridBagConstraints.NONE;
            bagCons.gridx = 0;
            bagCons.gridy = 2;
            bagCons.weightx = 0;
            bagCons.weighty = 1;
            bagCons.gridheight = 2;
            bagCons.gridwidth = 9;
            bagStruct.setConstraints(draw,bagCons);
            bagPanel.add(draw);
            
            bagCons.insets = new Insets(0,0,50,400);
            bagCons.anchor = GridBagConstraints.SOUTH;
            bagCons.fill = GridBagConstraints.NONE;
            bagCons.gridx = 9;
            bagCons.gridy = 2;
            bagCons.weightx = 1;
            bagCons.weighty = 1;
            bagCons.gridheight = 2;
            bagCons.gridwidth = 9;
            bagStruct.setConstraints(clearCan,bagCons);
            bagPanel.add(clearCan);
            
            bagCons.insets = new Insets(48,0,0,52);
            bagCons.anchor = GridBagConstraints.EAST;
            bagCons.fill = GridBagConstraints.NONE;
            bagCons.gridx = 9;
            bagCons.gridy = 1;
            bagCons.weightx = 1;
            bagCons.weighty = 0;
            bagCons.gridheight = 4;
            bagCons.gridwidth = 9;
            bagStruct.setConstraints(editor.getEditor(),bagCons);
            bagPanel.add(editor.getEditor());
            
            bagCons.insets = new Insets(0,0,50,200);
            bagCons.anchor = GridBagConstraints.SOUTHEAST;
            bagCons.fill = GridBagConstraints.NONE;
            bagCons.gridx = 9;
            bagCons.gridy = 2;
            bagCons.weightx = .5;
            bagCons.weighty = 1;
            bagCons.gridheight = 2;
            bagCons.gridwidth = 9;
            bagStruct.setConstraints(add,bagCons);
            bagPanel.add(add);
            
            bagCons.insets = new Insets(0,0,50,50);
            bagCons.anchor = GridBagConstraints.SOUTHEAST;
            bagCons.fill = GridBagConstraints.NONE;
            bagCons.gridx = 9;
            bagCons.gridy = 2;
            bagCons.weightx = .5;
            bagCons.weighty = 1;
            bagCons.gridheight = 2;
            bagCons.gridwidth = 9;
            bagStruct.setConstraints(clearS,bagCons);
            bagPanel.add(clearS);
            
            bagCons.insets = new Insets(100,0,0,200);
            bagCons.anchor = GridBagConstraints.NORTHEAST;
            bagCons.fill = GridBagConstraints.NONE;
            bagCons.gridx = 9;
            bagCons.gridy = 2;
            bagCons.weightx = .5;
            bagCons.weighty = 1;
            bagCons.gridheight = 2;
            bagCons.gridwidth = 9;
            bagStruct.setConstraints(save,bagCons);
            bagPanel.add(save);
            
            bagCons.insets = new Insets(100,0,0,50);
            bagCons.anchor = GridBagConstraints.NORTHEAST;
            bagCons.fill = GridBagConstraints.NONE;
            bagCons.gridx = 9;
            bagCons.gridy = 2;
            bagCons.weightx = .5;
            bagCons.weighty = 1;
            bagCons.gridheight = 2;
            bagCons.gridwidth = 9;
            bagStruct.setConstraints(load,bagCons);
            bagPanel.add(load);
     
            getContentPane().add(bagPanel);
            setGlassPane(bagPanel);
            pack();
            setMinimumSize(new Dimension(900,625));
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
            bagPanel.setFocusable(true);
            bagPanel.setVisible(true);
        }
    }
    
    private class MyCanvas extends JPanel {   
        MyCanvas() {
            setPreferredSize(new Dimension(447,449));    
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            img.load("canvas").paintIcon(this,g,0,0);
        }
    }
    
    private class MyEditor extends JTextPane 
    implements DocumentListener,CaretListener,KeyListener {
        private StyledDocument scriptDocument;
        private StyleContext scriptStyleContext;
        private Style scriptStyle;
        
        private JPanel wrap;

        private JScrollPane scriptScroll;
      
        private File fontFile;
        private Font scriptFont;
        private float lineSpace = -0.0625f;
        
        private int index;
        private int charCount;
        private int charReset;
        private int lineCount = 1;
        private int caretPos;
        private int docLenBef;
        private int countLine = 0;
        
        private boolean reWrap;
        
        private void setIndex(int i) {
            index = i;
        }
        
        MyEditor() {
            super();
            setOpaque(false);
/*            
            wrap = new JPanel(new BorderLayout());
            wrap.setPreferredSize(new Dimension(296,337));
            wrap.add(this);
*/            
            scriptScroll = new JScrollPane(this);
            scriptScroll.setPreferredSize(new Dimension(296,337));
            scriptScroll.setViewportView(this);
            
            scriptScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scriptScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            
            
            this.getDocument().addDocumentListener(this);
            addCaretListener(this);
            addKeyListener(this);
 //           setPreferredSize(new Dimension(296,337));
            String local = System.getProperty("user.dir")+"/";
            
            try {
                fontFile = new File(local+"Inconsolata.ttf");
            } catch(NullPointerException e) { e.printStackTrace(); }
            try {
                try {
scriptFont = Font.createFont(Font.TRUETYPE_FONT,fontFile).deriveFont(Font.PLAIN,19f);
// Holy shit that's a long line
                } catch(IOException e) { e.printStackTrace(); }
            } catch(FontFormatException e) { e.printStackTrace(); }

            scriptStyleContext = new StyleContext();
            scriptDocument = new DefaultStyledDocument(scriptStyleContext);
            scriptStyle = scriptStyleContext.getStyle(StyleContext.DEFAULT_STYLE);
            StyleConstants.setLeftIndent(scriptStyle,25);
            StyleConstants.setRightIndent(scriptStyle,0);
            StyleConstants.setLineSpacing(scriptStyle,lineSpace);
            
            scriptDocument.addStyle("drillscript",scriptStyle);
            setStyledDocument(scriptDocument);
           
            setFont(scriptFont);           
 /*           
            FontMetrics met = 
            System.out.println(scriptFont.LineMetrics().getHeight());
*/            
            setEditable(true);
            setVisible(true);
        }
        
        public JScrollPane getEditor() {
            return scriptScroll;
        }
        
        @Override
        protected void paintComponent(Graphics g) {
 /*         
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(scriptFont);
 */   
 //           System.out.println(docLenBef);
            Document scriptDoc = getDocument();
            int top = viewToModel(scriptScroll.getViewport().getViewPosition());
            int topLine = scriptDoc.getDefaultRootElement().getElementIndex(top);
        //    int eleIndex = scriptDoc.getDefaultRootElement().getElementIndex();
            setIndex(topLine);
            
            charCount = getText().length();
            
            //StyledDocument textReplace = new StyledDocument();
            String lineCheck = getText();
            StringBuilder forceWrap = new StringBuilder(lineCheck);
            ArrayList<Integer> eolPos = new ArrayList<Integer>();
            ArrayList<String> docLines = new ArrayList<String>();
            int docLen = lineCheck.length();
            int lineMin = 1+(docLen/25);
            char[] eol = {'\n'};
            
 //          System.out.println(lineCheck.length());
            for(int i=0; i<docLen; i++) {
                if(lineCheck.charAt(i) == '\n') {
                    lineCount++;
                    eolPos.add(i);
                }
            }
/*            
            if(eolPos.isEmpty() && charCount>=25) {
                for(int i=0; i<lineMin; i++)
                    forceWrap.insert((i*25),eol,0,1);
                 //getDocument().remove(0,charCount);
                 //textReplace.insertString(0,forceWrap.toString())
                 setText("");
                 setText(forceWrap.substring(1));
            }
*/
            
            /*
            int charReCount = 0;
            if(charCount%25==0) {
            while(charReCount<charCount) {
                int notEOL = 0;
                for(int i=charReCount;(i<charCount)||(i<26);i++) {
                    if(forceWrap.charAt(i)!='\n') {
                        notEOL++;
                        charReCount++;
                        if(i==25)
                            forceWrap.insert(charReCount,eol,0,1);
                    }
                    else {
                        charReCount++;
                        break;
                    }
                }
             }
                setText("");
                setText(forceWrap.substring(1));
             }
             */   

            docLenBef = docLen;
            
 //           charReset = charCount - (charCount*(lineCount-1));

            for(int i=0; i<=8+topLine;i++)
                img.load("textimage").paintIcon(this,g,0,0+(i*42));
            super.paintComponent(g);
                      
        }
        @Override
        public void caretUpdate(CaretEvent e) {
            caretPos = e.getDot();
  //          System.out.println(charCount);
  //          System.out.println(lineCount);
        }
        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("insert");
            repaint();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            repaint();
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
            System.out.println("change");
            repaint();
        }
        @Override 
        public void keyPressed(KeyEvent e) {

        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
              
        @Override
        public void keyTyped(KeyEvent e)
        {
            // set doclength every time key is pressed
            // check if latest key press added
            // more than 1 char
            // if it did, rewrap 
            // also account for deleting multiple
            // chars at a time
            boolean add;
            if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                add = false;
                if(countLine!=0)
                    countLine--;
            }
            else
                add = true;
            if(add) {
                if(countLine!=25)
                    countLine++;
                if(e.getKeyChar()=='\n')
                  countLine = 0;
                if(countLine==25) {
                    setText(getText()+"\n");
                    countLine = 0;
                }
           }
        }
    }

    public static void main(String args[]) {
        
        DrillPrint start = new DrillPrint();
    }
}