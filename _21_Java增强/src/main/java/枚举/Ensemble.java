package 枚举;

import java.util.EnumSet;
import java.util.Set;

/**
 * 用实力域替代序数
 */
public enum Ensemble {
    SOLO, DUET, TRIO, QUARTET, QUINTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}

/**
 * 用EnumSet替代位域
 */
 class Text{
    public enum Style{
        BOLD,ITALIC,UNDERLINE
    }
    public void applyStyles(Set<Style> styles){}

     public static void main(String[] args) {
         Text text=new Text();
         text.applyStyles(EnumSet.of(Style.UNDERLINE));

     }
}
