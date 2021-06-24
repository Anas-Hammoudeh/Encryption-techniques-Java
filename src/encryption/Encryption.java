
package encryption;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
public class Encryption {

    
    public static void main(String[] args) {
        ClassicalEncryption c=new ClassicalEncryption ();
       
    }
    
}
 class ClassicalEncryption extends JFrame {
    JLabel ceaserKey=new JLabel("cease key");
    JLabel rowKey=new JLabel("row transposition key");
    JLabel playfairKey=new JLabel("playfair key");
    JLabel vigenereKey=new JLabel("vigenere key");
    JTextField ckey=new JTextField();
    JTextField rkey=new JTextField();
    JTextField pkey=new JTextField();
    JTextField vkey=new JTextField();
    
    JTextArea Text=new JTextArea();
    JTextArea ED=new JTextArea();
    JLabel T=new JLabel("Text");
    JLabel E=new JLabel("Encryption/Decryption");
    
    JButton showinceaser=new JButton("show in ceaser");
    JButton showinrow=new JButton("show in RowTransposition");
    JButton showinplayfair=new JButton("show in playFair");
    JButton showinvigenere=new JButton("show in Vigenere");
    
    JButton et=new JButton("Encrypt Text");
    JButton dt=new JButton("Decrypt Text");
    JButton ca=new JButton("clear all");
    
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;
    JPanel p5;
    JPanel p6;
    JPanel p7;
    String ceaserCipher="";
    String currentCipher="";
    String rowCipher="";
    String playfairCipher="";
    String vigenereCipher="";

    public ClassicalEncryption() {
        p1=new JPanel(new GridLayout(4,2,1,1));
        p1.add(ceaserKey);
        p1.add(ckey);
        p1.add(rowKey);
        p1.add(rkey);
        p1.add(playfairKey);
        p1.add(pkey);
        p1.add(vigenereKey);
        p1.add(vkey);
        
        p2=new JPanel(new BorderLayout());
        p2.add(Text,BorderLayout.CENTER);
        p2.add(T,BorderLayout.NORTH);
        
        p3=new JPanel(new BorderLayout());
        p3.add(ED,BorderLayout.CENTER);
        p3.add(E,BorderLayout.NORTH);
        
        p4=new JPanel(new GridLayout(1,2,1,1));
        p4.add(p2);
        p4.add(p3);
        
        p5=new JPanel(new GridLayout(4,1,1,1));
        p5.add(showinceaser);
        p5.add(showinrow);
        p5.add(showinplayfair);
        p5.add(showinvigenere);
        
        p6=new JPanel(new BorderLayout());
        p6.add(p4,BorderLayout.CENTER);
        p6.add(p5,BorderLayout.EAST);
        
        p7=new JPanel(new GridLayout(1,4,1,1));
        p7.add(et);
        p7.add(dt);
        p7.add(ca);
        
        et.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                currentCipher=Text.getText();
                
                ceaserCipher=ceaserEncryption(Integer.parseInt(ckey.getText()), currentCipher);
                currentCipher=ceaserCipher;
                
                rowCipher=rowTranspositonEncryption(rkey.getText(), currentCipher);
                currentCipher=rowCipher;
                
                playfairCipher=playFairEncryption(pkey.getText(), currentCipher);
                currentCipher=playfairCipher;
                
                vigenereCipher=vigenereEncryption(vkey.getText(), currentCipher);
                currentCipher=vigenereCipher;
                
                ED.setText(currentCipher);
                
            }
        });
        showinceaser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ED.setText("");
                ED.setText(ceaserCipher);
                
            }
        });
        showinrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ED.setText("");
                ED.setText(rowCipher);
            }
        });
        showinplayfair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               ED.setText("");
               ED.setText(playfairCipher);
            }
        });
        showinvigenere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ED.setText("");
                ED.setText(vigenereCipher);
            }
        });
        dt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                currentCipher=Text.getText();
                
                 vigenereCipher=vigenereDecryption(vkey.getText(), currentCipher);
                currentCipher=vigenereCipher;
                
                 playfairCipher=playFairDecryption(pkey.getText(), currentCipher);
                currentCipher=playfairCipher;
                
                rowCipher=rowTranspositionDecryption(rkey.getText(), currentCipher);
                currentCipher=rowCipher;
                
                ceaserCipher=ceaserDecryption(Integer.parseInt(ckey.getText()), currentCipher);
                currentCipher=ceaserCipher;
                System.out.println(ceaserCipher);
                
                
                
               
                
                ED.setText(currentCipher);
                
            }
        });
        ca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                currentCipher="";
                ceaserCipher="";
                rowCipher="";
                playfairCipher="";
                vigenereCipher="";
                ED.setText("");
                Text.setText("");
            }
        });
        
        
        
        
        
        add(p6,BorderLayout.CENTER);
        add(p7,BorderLayout.SOUTH);
        add(p1,BorderLayout.NORTH);
        
        setSize(700,700);
        setVisible(true);
        setTitle("classical Encryption");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
    }
    
    
            
   

    

public String ceaserEncryption(int key,String plainText){
    String result="";
    int x=0;
    for(int i=0;i<plainText.length();i++){
        x=findNumber(plainText.charAt(i));
        x+=key;
        if(x>25)
            x=x-26;
        result+=findChar(x);
            
    }
return result;
}
public String ceaserDecryption(int key,String cipherText){
    String result="";
    int x=0;
    for(int i=0;i<cipherText.length();i++){
        x=findNumber(cipherText.charAt(i));
        x-=key;
        if(x<0)
            x+=25;
        result+=findChar(x);
    }
    return result;

}
public String rowTranspositonEncryption(String key,String plainText){
        String result="";
             int rowSize=plainText.length();
              int columnSize=key.length();
              
              while(rowSize%columnSize!=0){
                 
                  rowSize++;
              }
             rowSize/=columnSize;
             char[][]matrix=new char[rowSize][columnSize];
             boolean f=true;
       int position=0;
        int i=0;
        int j=0;
        for( i=0;i<rowSize;i++){
            if(f)
            for(j=0;j<columnSize;j++ ){
                
             
              if(position<plainText.length()){
                matrix[i][j]=plainText.charAt(position);
                
                position++;
           }
                    else{ f=false; break;}
                    
            }
            
          }
          char fill='z';
            for(int r=j;r<columnSize;r++){
               
                matrix[rowSize-1][r]=fill;
                
                
            }
            
      int column=0;
     for(int w=0;w<columnSize;w++)
         for(int p=0;p<rowSize;p++){
             column=Integer.parseInt(key.charAt(w)+"")-1;
             result+=matrix[p][column];
                     
         }
     return result;
        
    }
public String rowTranspositionDecryption(String key,String cipherText){
        String result="";
        int rowSize=cipherText.length()/key.length();
        char [][]matrix=new char[cipherText.length()][key.length()];
        int position=0;
        int column=0;
        
        for(int i=0;i<key.length();i++){
            
            column=Integer.parseInt(key.charAt(i)+"")-1;
            
            for(int row=0;row<rowSize;row++){
                
                if(position<cipherText.length())
                matrix[row][column]=cipherText.charAt(position);
                
                position++;
            }
        }
        
        for(int row=0;row<cipherText.length();row++){
            
            for(int columnn=0;columnn<key.length();columnn++){
                if(matrix[row][columnn]!='z')
                    result+=matrix[row][columnn];
                
            }
                
        }
        
        return result;
    }
public String playFairEncryption(String key,String plainText){
    char[][]matrix=new char[5][5];
    String result="";
    key=distinct(key);
    
    int keyposition=0;
    for(int i=0;i<5;i++)
        for(int j=0;j<5;j++){
          if(keyposition<key.length())
              matrix[i][j]=key.charAt(keyposition);
          keyposition++;
        }
    char englishLetters='a';
    for(int i=0;i<5;i++)
        for(int j=0;j<5;j++){
            if(matrix[i][j]=='\u0000'){
                while(contain(englishLetters, matrix)||englishLetters=='j')
                    englishLetters++;
                matrix[i][j]=englishLetters;
            }
        }
    String readyText=prepareText(plainText);
    
    
    for(int i=0;i<readyText.length();i++){
        if(i+1<readyText.length()){
            String pos1=findPosition(readyText.charAt(i), matrix);
            String pos2=findPosition(readyText.charAt(i+1), matrix);
            
            int row1=Integer.parseInt(pos1.charAt(0)+"");
            int column1=Integer.parseInt(pos1.charAt(1)+"");
            int row2=Integer.parseInt(pos2.charAt(0)+"");
            int column2=Integer.parseInt(pos2.charAt(1)+"");
            
            if(row1==row2){
                if(column1==4)
                    result+=matrix[row1][0];
                
                else result+=matrix[row1][column1+1];
                
                if(column2==4)
                    result+=matrix[row2][0];
                
                else result+=matrix[row2][column2+1];
                i++;
            }
            else if(column1==column2){
                    if(row1==4)
                        result+=matrix[0][column1];
                    else
                        result+=matrix[row1+1][column1];
                    if(row2==4)
                        result+=matrix[0][column2];
                    else
                        result+=matrix[row2+1][column2];
                i++;
            }
            else{
                result+=matrix[row1][column2];
                result+=matrix[row2][column1];
                i++;
            }
            
            
        }
    }
    return result;
            
}
public String playFairDecryption(String key,String cipherText){
    String result="";
    char matrix[][]=new char[5][5];
    key=distinct(key);
    int keyPosition=0;
    for(int i=0;i<5;i++)
        for(int j=0;j<5;j++){
            if(keyPosition<key.length())
                matrix[i][j]=key.charAt(keyPosition);
            keyPosition++;
        }
   char englishLetters='a';
    for(int i=0;i<5;i++)
        for(int j=0;j<5;j++){
            if(matrix[i][j]=='\u0000'){
                while(contain(englishLetters, matrix)||englishLetters=='j')
                    englishLetters++;
                matrix[i][j]=englishLetters;
            }
        }
   
   for(int i=0;i<cipherText.length();i++){
       if(i+1<cipherText.length()){
           String pos1=findPosition(cipherText.charAt(i), matrix);
           String pos2=findPosition(cipherText.charAt(i+1), matrix);
            
            int row1=Integer.parseInt(pos1.charAt(0)+"");
            int column1=Integer.parseInt(pos1.charAt(1)+"");
            int row2=Integer.parseInt(pos2.charAt(0)+"");
            int column2=Integer.parseInt(pos2.charAt(1)+"");
            
            if(row1==row2){
                if(column1==0)
                    result+=matrix[row1][4];
                else
                    result+=matrix[row1][column1-1];
                if(column2==0)
                    result+=matrix[row2][4];
                else
                    result+=matrix[row2][column2-1];
                i++;
            }
            else if(column1==column2){
                if(row1==0)
                    result+=matrix[4][column1];
                else
                    result+=matrix[row1-1][column1];
                if(row2==0)
                    result+=matrix[4][column2];
                else
                    result+=matrix[row2-1][column2];
                
                 i++;
            }
            else{
               
               result+=matrix[row1][column2];
               result+=matrix[row2][column1];
                i++;
                
            }
            
       }
   }
   String lastResult="";
   for(int i=0;i<result.length();i++){
       if(result.charAt(i)=='x')
           continue;
       else lastResult+=result.charAt(i);
   }
     
           
   
           
   
    return lastResult;
}
public String vigenereEncryption(String key,String plainText){
    String result="";
    int howManyRepeats=plainText.length()-key.length();
    
    
    String expandedKey=key;
    

    if(howManyRepeats>0){
        int position=0;
        for(int i=0;i<howManyRepeats;i++){
            if(position<key.length()){
                expandedKey+=key.charAt(position);
                position++;
            }
                
            else{
                position=0;
                expandedKey+=key.charAt(position);
                position++;
            }
            
        }
        
    }
    for(int i=0;i<plainText.length();i++){
        int keyChar=findNumber(expandedKey.charAt(i));
        int plainChar=findNumber(plainText.charAt(i));
        int sum=keyChar+plainChar;
        char curentResult='a';
        if(sum>25)
            curentResult=findChar(sum-26);
        else
            curentResult=findChar(sum);
        
        result+=curentResult;
                
    }
    return result;
}
public String vigenereDecryption(String key,String cipherText){
      String result="";
    int howManyRepeats=cipherText.length()-key.length();
    
    String expandedKey=key;
    

    if(howManyRepeats>0){
        int position=0;
        for(int i=0;i<howManyRepeats;i++){
            if(position<key.length()){
                expandedKey+=key.charAt(position);
                position++;
            }
                
            else{
                position=0;
                expandedKey+=key.charAt(position);
                position++;
            }
            
        }
    }
    for(int i=0;i<cipherText.length();i++){
        int keyChar=findNumber(expandedKey.charAt(i));
        int cipherChar=findNumber(cipherText.charAt(i));
        int sum=cipherChar-keyChar;
        char curentResult='a';
        if(sum<0)
            curentResult=findChar(sum+26);
        else
            curentResult=findChar(sum);
        
        result+=curentResult;
                
    }
    return result;
    
}

public  int findNumber(char x){
    
    char []englishLetters={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    for(int i=0;i<26;i++)
        if(englishLetters[i]==x)
            return i;
    return 0;
}
public  char findChar(int x){
    char []englishLetters={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    return englishLetters[x];
}
public String distinct(String Text){
    String result="";
    result+=Text.charAt(0);
    for(int i=1;i<Text.length();i++){
        if(result.contains(Text.charAt(i)+"")){
            continue;
        }
        else result+=Text.charAt(i);
    }
     return result;   
}
public boolean contain(char x,char[][]matrix){
    boolean y=false;
    for(int i=0;i<5;i++)
        for(int j=0;j<5;j++){
            if(matrix[i][j]==x)
                return true;
        }
    return y;
}
public String findPosition(char x,char[][]matrix){
    String result="";
    for(int i=0;i<5;i++)
        for(int j=0;j<5;j++)
            if(matrix[i][j]==x){
              result+=i+""+j;
              return result;
            }
       return result;         

}
public String prepareText(String plainText){
    String result="";
    int countX=0;
    for(int i=0;i<plainText.length();i++){
        if(i+1<plainText.length()){
            if(plainText.charAt(i)==plainText.charAt(i+1)){
                result+=plainText.charAt(i);
                result+="x";
                countX++;
            }
            else {
                result+=plainText.charAt(i);
                result+=plainText.charAt(i+1);
                i++;
            }
        }
    }
    if((plainText.length()+countX)%2 == 1)
        result+=plainText.charAt(plainText.length()-1)+"x";
    String lastResult="";
    for(int i=0;i<result.length();i++)
        if(result.charAt(i)=='j')
            lastResult+='i';
        else lastResult+=result.charAt(i);
    
  
    return lastResult;
}
}