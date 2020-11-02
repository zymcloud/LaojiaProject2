package command;

import text.Text;

/**
 * @author zym
 * @create 2020/10/29 9:03
 * @theme
 */
public class Undo implements Command{
    Text text;
    Replace replace;
    public Undo(Text text) {
        this.text = text;
        replace = text.replaces[text.current];
    }

    @Override
    public void excute() {
        if(replace == null){
            System.out.println("不能撤回！");
            return;
        }
        text.modify(replace.replacewords,replace.origin,replace.positon);
    }
}
