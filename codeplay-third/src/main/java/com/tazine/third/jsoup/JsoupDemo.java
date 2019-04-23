package com.tazine.third.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * <p>
 * Jsoup 是一款Java的HTML解析器，可直接解析某个URL地址、HTML文件内容 它提供一套API，可通过DOM、CSS以及类似jQuery的操作方法取出和操作数据
 * </p>
 *
 * @author frank
 * @date 2019/04/23
 */
public class JsoupDemo {

    private static String print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
        return String.format(msg, args);
    }

    private static String trim(String s, int width) {
        if (s.length() > width) { return s.substring(0, width - 1) + "."; } else { return s; }
    }

    public static void main(String[] args) throws IOException {
        String url = "https://g.alicdn.com/fudongdong/das/index.html";
        Document doc = Jsoup.connect(url).get();

        System.out.println(doc.html());
        //System.err.println(doc.outerHtml());

        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");

        for (Element src : media) {
            //System.out.println("haha");
            //if (src.tagName().equals("img"))
            //    print(" * %s: <%s> %sx%s (%s)",
            //        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
            //        trim(src.attr("alt"), 20));
            //else
            //    print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
            src.attr("src", src.attr("abs:src"));
        }

        for (Element link : imports) {
            //System.out.println(link.attr("abs:href"));
            //System.out.println(link.attr("href"));
            link.attr("href", link.attr("abs:href"));
            //print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
        }

        System.out.println(doc.html());
    }
}
