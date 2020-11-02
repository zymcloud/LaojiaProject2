package text;

import command.Replace;

import java.io.*;

/**
 * @author zym
 * @create 2020/10/29 9:04
 * @theme
 */
public class Text {
    public String[] lines = {
                "1996年NBA选秀，科比于第1轮第13位被夏洛特黄蜂队选中，后被交易至洛杉矶湖人队，整个NBA生涯都效力于洛杉矶湖人队。",
                "1997年NBA全明星周末，科比赢得了扣篮大赛的冠军，18岁的科比也成为了NBA史上最年轻的扣篮大赛冠军。2007年12月23日，",
                "科比在麦迪逊广场花园对阵纽约尼克斯队的比赛中成为史上最年轻的达到20000分的球员（29岁122天）。",
                "2017年12月19日，湖人主场对阵勇士，中场时刻为科比的8号和24号两件球衣举行了退役仪式。"
            };
    public String FilePath;
    public Replace[] replaces = new Replace[2];
    public int current = 0;

    public Text(String FilePath) {
        this.FilePath = FilePath;
    }

    public void persist(String filePath){
        File file = new File(filePath);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            for(String string : lines){
                fileOutputStream.write(string.getBytes());
                fileOutputStream.write('\n');
            }
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Position replace(String origin,String des)
    {
        int lin = 0;
        while (lin<lines.length){
            if(lines[lin].contains(origin)){
                if(lines[lin].indexOf(origin) != -1 ){
                    int col = lines[lin].indexOf(origin);
                    lines[lin] = lines[lin].replaceFirst(origin,des);
                    return new Position(lin,col);
                }
            }
            lin++;
        }
        return null;
    }
    public void modify(String origin,String des,Position modifiedpositon){
        String temp = lines[modifiedpositon.lin].substring(0,modifiedpositon.col);
        temp += des;
        temp += lines[modifiedpositon.lin].substring(modifiedpositon.col+origin.length());
        lines[modifiedpositon.lin] = temp;
        moveReplace();
    }
    public void moveReplace(){
        replaces[current] = null;
        current = 1-current;
    }
    public void addRecentReplace(Replace replace){
        current = 1-current;
        replaces[current] = replace;
    }
}
