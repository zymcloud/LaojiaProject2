package command;

import text.Text;

/**
 * @author zym
 * @create 2020/10/29 9:02
 * @theme
 */
public class Save implements Command{
    Text text;
    public Save(Text text) {
        this.text = text;
    }
    @Override
    public void excute() {
        text.persist(text.FilePath);
    }
}
