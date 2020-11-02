package command;

import text.Position;
import text.Text;

/**
 * @author zym
 * @create 2020/10/29 9:02
 * @theme
 */
public class Replace implements Command{
    Text text;
    String replacewords;
    String origin;
    Position positon;
    @Override
    public void excute() {
        positon = text.replace(origin,replacewords);
        text.addRecentReplace(this);
    }
    public Replace(Text text, String origin, String replace) {
        this.text = text;
        this.origin = origin;
        this.replacewords = replace;
    }
}
