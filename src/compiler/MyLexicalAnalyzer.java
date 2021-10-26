package compiler;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MyLexicalAnalyzer {


    //关键字
    static final String []keyWord={"private","protected","public","abstract","class","extends","final","implements",
            "interface","native","new","static","strictfp","break","continue","return","do","while","if","else","for",
            "instanceof","switch","case","default","boolean","byte","char","double","float","int","long","short",
            "String","null","true","false","void","this","goto"};
    //操作符
    static final String []operation={"+","-","*","/","%","++","--","-=","*=","/=","&","|","^","~","<<",">>",">>>","==","!=",
            ">","<","=",">=","<=","&&","||","!","."};

    //界符
    static final String []symbol={",",";",":","(",")","{","}","[","]"};

    static ArrayList<String> keyWords=null;
    static ArrayList<String> operations=null;
    static ArrayList<String> symbols=null;

    //字符串位置指针
    static int p, lines;

    //变量表
    static List<String> table = new ArrayList<>();
    //错误表
    static List<String> errTable = new ArrayList<>();


    //测试
    public static void main(String[] args) throws Exception {
        init();
        File file=new File("D:\\workspace\\Code\\src\\compiler\\test01.txt");
        lines=1;
        try(Scanner input=new Scanner(file)) {
            while (input.hasNextLine()){
                String str=input.nextLine();
                analyze(str);
                lines++;
            }
        }

        File file1 = new File("D:\\workspace\\Code\\src\\compiler\\table.txt");
        File file2 = new File("D:\\workspace\\Code\\src\\compiler\\err.log");

        FileOutputStream fos1 = new FileOutputStream(file1);
        FileOutputStream fos2 = new FileOutputStream(file2);
        BufferedOutputStream bos1 = new BufferedOutputStream(fos1);
        BufferedOutputStream bos2 = new BufferedOutputStream(fos2);

        for (String s : table) {
            bos1.write(s.getBytes());
            bos1.flush();
        }
        for (String s : errTable) {
            bos2.write(s.getBytes());
            bos2.flush();
        }
        bos1.close();
        bos2.close();
    }

    //初始化把数组转换为ArrayList
    public static void init(){
        keyWords=new ArrayList<>();
        operations=new ArrayList<>();
        symbols=new ArrayList<>();
        Collections.addAll(keyWords, keyWord);
        Collections.addAll(operations, operation);
        Collections.addAll(symbols, symbol);
    }

    public static void analyze(String str) {
        p = 0;
        char ch;
        str = str.trim();
        for (; p < str.length(); p++) {
            ch = str.charAt(p);
            if (Character.isDigit(ch)) {
                digitCheck(str);
            } else if (Character.isLetter(ch) || ch == '_') {
                letterCheck(str);
            } else if (ch == '"') {
                stringCheck(str);
            } else if (ch == ' ') {
                continue;
            } else {
                symbolCheck(str);
            }
        }
    }

    /*数字的识别
     * 1、识别退出：
     *   1.1、遇到空格符
     *   1.2、遇到运算符或者界符
     * 2、错误情况：
     *   2.1、两个及以上小数点
     *   2.2、掺杂字母
     * */
    public static void digitCheck(String str){
        //已经拿到的字符形成的串
        String token= String.valueOf(str.charAt(p++));
        //判断数字的小数点是否有且是否大于1
        int flag=0;
        boolean err=false;
        char ch;
        for (;p<str.length();p++) {
            ch = str.charAt(p);
            if (ch==' '||(!Character.isLetterOrDigit(ch)&&ch!='.')) {
                break;
            }else if (err){
                token+=ch;
            }
            else {
                token+=ch;
                if (ch == '.') {
                    if (flag == 1) {
                        err = true;
                    } else {
                        flag++;
                    }
                }else if (Character.isLetter(ch)){
                    err=true;
                }
            }
        }

        if (token.charAt(token.length()-1)=='.'){
            err=true;
        }
        if (err){
            System.out.println(lines+"line"+": "+token+" is wrong");
            errTable.add(lines+"line"+": "+token+" is wrong");
        }else {
            System.out.println("("+3+","+token+")");
            table.add("("+3+","+token+")");
        }

        if (p!=str.length()-1||(p==str.length()-1&&!Character.isDigit(str.charAt(p)))){
            p--;
        }
    }


    //标识符，关键字的识别
    public static void letterCheck(String str){
        String token= String.valueOf(str.charAt(p++));
        char ch;
        for (;p<str.length();p++){
            ch=str.charAt(p);
            if (!Character.isLetterOrDigit(ch)&&ch!='_'){
                break;
            }else{
                token+=ch;
            }
        }
        if (keyWords.contains(token)){
            System.out.println("("+1+","+token+")");
            table.add("("+1+","+token+")");
        }else {
            System.out.println("("+2+","+token+")");
            table.add("("+2+","+token+")");
        }
        if (p!=str.length()-1||(p==str.length()-1&&(!Character.isLetterOrDigit(str.charAt(p))&&str.charAt(p)!='_'))){
            p--;
        }
    }

    //符号的识别
    //界符和操作符
    //退出：长度大于字符串，遇到非操作符号或者非标识符
    public static void symbolCheck(String str){
        String token= String.valueOf(str.charAt(p++));
        char ch;
        if (symbols.contains(token)){
            System.out.println("("+5+","+token+")");
            table.add("("+5+","+token+")");
            p--;
        }else {
            if (operations.contains(token)){
                if (p<str.length()){
                    ch=str.charAt(p);
                    if (operations.contains(token+ch)){
                        token+=ch;
                        p++;
                        if (p<str.length()){
                            ch=str.charAt(p);
                            if (operations.contains(token+ch)){
                                token+=ch;
                                System.out.println("("+4+","+token+")");
                                table.add("("+4+","+token+")");
                            }else{
                                p--;
                                System.out.println("("+4+","+token+")");
                                table.add("("+4+","+token+")");
                            }
                        }else{
                            System.out.println("("+4+","+token+")");
                            table.add("("+4+","+token+")");
                        }
                    }else {
                        p--;
                        System.out.println("("+4+","+token+")");
                        table.add("("+4+","+token+")");
                    }
                }
            }else {
                p--;
                System.out.println(lines+"line"+": "+token+" is wrong");
                errTable.add(lines+"line"+": "+token+" is wrong");
            }
        }
    }

    //字符串检查
    public static void stringCheck(String str){
        String token= String.valueOf(str.charAt(p++));
        char ch;
        for (;p<str.length();p++){
            ch=str.charAt(p);
            token += ch;
            if (ch=='"'){
                break;
            }
        }
        if (token.charAt(token.length()-1)!='"'){
            System.out.println(lines+"line"+": "+token+" is wrong");
            errTable.add(lines+"line"+": "+token+" is wrong");
        }else {
            System.out.println("("+6+","+token+")");
            table.add("("+6+","+token+")");
        }
    }
}
