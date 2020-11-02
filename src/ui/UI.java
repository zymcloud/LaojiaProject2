package ui;

import command.Replace;
import command.Save;
import command.Undo;
import text.Text;

/**
 * @author zym
 * @create 2020/10/29 9:19
 * @theme
 */
public class UI {
    private Text text;

    public void setText(Text text) {
        this.text = text;
    }

    void mnuSave_click(){
        System.out.println("通过mnu执行");
        new Save(text).excute();
    };

    void mnuReplace_click(String origin,String des){
        System.out.println("通过mnu执行");
        new Replace(text,origin,des).excute();
    };

    void mnuUndo_click( ){
        System.out.println("通过mnu执行");
        new Undo(text).excute();
    };

    void toolSave_click( ){
        System.out.println("通过tool执行");
        new Save(text).excute();
    };

    void toolReplace_click(String origin,String des){
        System.out.println("通过tool执行");
        new Replace(text,origin,des).excute();
    };

    void toolUndo_click( ){
        System.out.println("通过tool执行");
        new Undo(text).excute();
    };

    void popSave_click( ){
        System.out.println("通过pop执行");
        new Save(text).excute();
    };

    void popReplace_click(String origin,String des){
        System.out.println("通过pop执行");
        new Replace(text,origin,des).excute();
    };

    void popUndo_click( ){
        System.out.println("通过pop执行");
        new Undo(text).excute();
    };

    public static void main(String[] args) {
        Text text = new Text("D:\\untitile.txt");
        UI ui = new UI();
        ui.setText(text);
        ui.toolReplace_click("科比","乔丹");
//        ui.toolSave_click();
//        ui.toolReplace_click(" 科比","乔丹");
//        ui.toolUndo_click();
        ui.toolSave_click();
        for(String string : text.lines){
            System.out.println(string);
        }
    }
}
