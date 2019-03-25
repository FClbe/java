import library.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2
{
    public static void main(String[] args)throws IOException
    {
        int i = 0;

        ArrayList<Library> libraries = new ArrayList<>();

        try(Scanner in = new Scanner(new FileInputStream("library.bib"), "UTF-8"))
        {
            /* 用@进行分段
             *然后｛    ｛和｝ ｛做分隔符断开
             *tokens赋值
             */
            String line = in.nextLine();
            while(in.hasNextLine())
            {
                line = line + in.nextLine();
            }
            String[] beforeToken = line.split("@");

            while(i<beforeToken.length)
            {

                if(readLibrary(beforeToken, i).getPublication().getYear().equals(" "));
                else
                    libraries.add(readLibrary(beforeToken, i));
                i++;
            }

        }



        Library[] Libraries = new Library[libraries.size()];
        libraries.toArray(Libraries);
        Arrays.sort(Libraries);
        //for (Library l : Libraries)
       // l.putPublication();
        try (PrintWriter out = new PrintWriter("library.txt", "UTF-8"))
        {
            for (Library l : Libraries)
                out.println(l.getPublicationDetail());
        }
        searchForName(Libraries,"Schmitz, Patric & Hildebrandt, Julian & Valdez, Andr");
        searchForTitle(Libraries, "Optimizing constrained-environment redirected walking instructions using search techniques");
        searchTowAuthors(Libraries,"Zmuda, Michael ", "Wonser, Joshua L");
        searchOneAuthor(Libraries, "Wonser, Joshua L");
    }
    public static void searchForName(Library[] l, String name)
    {
        int i = 0;
        int flag = 0;
        while(i < l.length)
        {
            if(l[i].searchInAuthorName(name))
            {
                l[i].putPublication();
                flag = 1;
            }
            i++;
        }
        if(flag == 1)
            System.out.println("以上是找到的文献。");
        else
            System.out.println("很抱歉，未能找到相关文章！");
    }
    public static void searchForTitle(Library[] l, String name)
    {
        int i = 0;
        int flag = 0;
        while(i < l.length)
        {
            if(l[i].searchInTitle(name))
            {
                l[i].putPublication();
                flag = 1;
            }
            i++;
        }
        if(flag == 1)
            System.out.println("以上是找到的文献。");
        else
            System.out.println("很抱歉，未能找到相关文章！");
    }
    public static void searchTowAuthors(Library[] l,String name1, String name2)
    {
        int i = 0;
        int flag = 0;
        while(i < l.length)
        {
            if(l[i].searchInOneAuthorName(name1) && l[i].searchInOneAuthorName(name2))
            {
                flag = 1;
                l[i].putPublication();
            }
            i++;
        }
        if(flag == 1)
            System.out.println("以上是找到的文献。");
        else
            System.out.println("很抱歉，未能找到相关文章！");

    }
    public static void searchOneAuthor(Library[] l,String name1)
    {
        int i = 0;
        int flag = 0;
        while(i < l.length)
        {
            if(l[i].searchInOneAuthorName(name1) )
            {
                flag = 1;
                l[i].putPublication();
            }
            i++;
        }
        if(flag == 1)
            System.out.println("以上是找到的文献。");
        else
            System.out.println("很抱歉，未能找到相关文章！");

    }
    public static Library readLibrary(String[] beforeToken, int i )
    {
        Artical tempArtical = new Artical();
        Author tempAuthor = new Author();
        ConferencePaper tempConferencePaper = new ConferencePaper();
        Library tempLibrary = new Library(tempArtical, tempAuthor);
        String[] tokens = beforeToken[i].split("\\{[^\\{]+\\{|\\}[^\\{]+\\{|\\}\\s\\s\\s");

        if (tokens[0].equals("article") && tokens.length > 7) {
            String[] authorName = tokens[2].split("\\sand\\s");
            int temp = authorName.length;
            if (temp == 1) {
                tempAuthor.setName(tokens[2]);
                tempArtical = new Artical(tokens[1], tokens[2], tokens[7], tokens[3], tokens[5], tokens[6]);
                return new Library(tempArtical, tempAuthor);
            } else if (temp == 2) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                tempArtical = new Artical(tokens[1], authorName[0], authorName[1], tokens[7], tokens[3], tokens[5], tokens[6]);
                return new Library(tempArtical, tempAuthor, tempAuthor1);
            } else if (temp == 3) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                tempArtical = new Artical(tokens[1], authorName[0], authorName[1], authorName[2],
                        tokens[7], tokens[3], tokens[5], tokens[6]);
                return new Library(tempArtical, tempAuthor, tempAuthor1, tempAuthor2);
            } else if (temp == 4) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                Author tempAuthor3 = new Author();
                tempAuthor3.setName(authorName[3]);
                tempArtical = new Artical(tokens[1], authorName[0], authorName[1], authorName[2], authorName[3],
                        tokens[7], tokens[3], tokens[5], tokens[6]);
                return new Library(tempArtical, tempAuthor, tempAuthor1, tempAuthor2, tempAuthor3);
            } else if (temp == 5) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                Author tempAuthor3 = new Author();
                tempAuthor3.setName(authorName[3]);
                Author tempAuthor4 = new Author();
                tempAuthor4.setName(authorName[4]);
                tempArtical = new Artical(tokens[1], authorName[0], authorName[1], authorName[2], authorName[3],
                        authorName[4], tokens[7], tokens[3], tokens[5], tokens[6]);
                return new Library(tempArtical, tempAuthor, tempAuthor1, tempAuthor2, tempAuthor3, tempAuthor4);
            } else if (temp == 6) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                Author tempAuthor3 = new Author();
                tempAuthor3.setName(authorName[3]);
                Author tempAuthor4 = new Author();
                tempAuthor4.setName(authorName[4]);
                Author tempAuthor5 = new Author();
                tempAuthor5.setName(authorName[5]);
                tempArtical = new Artical(tokens[1], authorName[0], authorName[1], authorName[2], authorName[3],
                        authorName[4], authorName[5], tokens[7], tokens[3], tokens[5], tokens[6]);
                return new Library(tempArtical, tempAuthor, tempAuthor1, tempAuthor2, tempAuthor3,
                        tempAuthor4, tempAuthor5);
            } else if (temp == 7) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                Author tempAuthor3 = new Author();
                tempAuthor3.setName(authorName[3]);
                Author tempAuthor4 = new Author();
                tempAuthor4.setName(authorName[4]);
                Author tempAuthor5 = new Author();
                tempAuthor5.setName(authorName[5]);
                Author tempAuthor6 = new Author();
                tempAuthor6.setName(authorName[6]);
                tempArtical = new Artical(tokens[1], authorName[0], authorName[1], authorName[2], authorName[3],
                        authorName[4], authorName[5], authorName[6], tokens[7], tokens[3], tokens[5], tokens[6]);
                return new Library(tempArtical, tempAuthor, tempAuthor1, tempAuthor2, tempAuthor3,
                        tempAuthor4, tempAuthor5, tempAuthor6);
            }

        } else if (tokens[0].equals("inproceedings")) {
            String[] authorName = tokens[2].split("\\sand\\s");
            int temp = authorName.length;
            if (temp == 1) {
                tempAuthor.setName(authorName[0]);
                tempConferencePaper = new ConferencePaper(tokens[1], authorName[0], tokens[5], tokens[3], tokens[4]);
                return new Library(tempConferencePaper, tempAuthor);
            } else if (temp == 2) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                tempConferencePaper = new ConferencePaper(tokens[1], authorName[0], authorName[1], tokens[5], tokens[3], tokens[4]);
                Library library = new Library(tempConferencePaper, tempAuthor, tempAuthor1);
            } else if (temp == 3) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                tempConferencePaper = new ConferencePaper(tokens[1], authorName[0], authorName[1], authorName[2],
                        tokens[5], tokens[3], tokens[4]);
                return new Library(tempConferencePaper, tempAuthor, tempAuthor1, tempAuthor2);
            } else if (temp == 4) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                Author tempAuthor3 = new Author();
                tempAuthor3.setName(authorName[3]);
                tempConferencePaper = new ConferencePaper(tokens[1], authorName[0], authorName[1], authorName[2], authorName[3],
                        tokens[5], tokens[3], tokens[4]);
                return new Library(tempConferencePaper, tempAuthor, tempAuthor1, tempAuthor2, tempAuthor3);
            } else if (temp == 5) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                Author tempAuthor3 = new Author();
                tempAuthor3.setName(authorName[3]);
                Author tempAuthor4 = new Author();
                tempAuthor4.setName(authorName[4]);
                tempConferencePaper = new ConferencePaper(tokens[1], authorName[0], authorName[1], authorName[2], authorName[3],
                        authorName[4], tokens[5], tokens[3], tokens[4]);
                return new Library(tempConferencePaper, tempAuthor, tempAuthor1, tempAuthor2, tempAuthor3, tempAuthor4);
            } else if (temp == 6) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                Author tempAuthor3 = new Author();
                tempAuthor3.setName(authorName[3]);
                Author tempAuthor4 = new Author();
                tempAuthor4.setName(authorName[4]);
                Author tempAuthor5 = new Author();
                tempAuthor5.setName(authorName[5]);
                tempConferencePaper = new ConferencePaper(tokens[1], authorName[0], authorName[1], authorName[2], authorName[3],
                        authorName[4], authorName[5], tokens[5], tokens[3], tokens[4]);
                return new Library(tempConferencePaper, tempAuthor, tempAuthor1, tempAuthor2, tempAuthor3,
                        tempAuthor4, tempAuthor5);
            } else if (temp == 7) {
                tempAuthor.setName(authorName[0]);
                Author tempAuthor1 = new Author();
                tempAuthor1.setName(authorName[1]);
                Author tempAuthor2 = new Author();
                tempAuthor2.setName(authorName[2]);
                Author tempAuthor3 = new Author();
                tempAuthor3.setName(authorName[3]);
                Author tempAuthor4 = new Author();
                tempAuthor4.setName(authorName[4]);
                Author tempAuthor5 = new Author();
                tempAuthor5.setName(authorName[5]);
                Author tempAuthor6 = new Author();
                tempAuthor6.setName(authorName[6]);
                tempConferencePaper = new ConferencePaper(tokens[1], authorName[0], authorName[1], authorName[2], authorName[3],
                        authorName[4], authorName[5], authorName[6], tokens[5], tokens[3], tokens[4]);
                return new Library(tempConferencePaper, tempAuthor, tempAuthor1, tempAuthor2, tempAuthor3,
                        tempAuthor4, tempAuthor5, tempAuthor6);
            }
        } else if (tokens[0].equals("article") && tokens.length <= 5) {
            tempArtical.setTitle(tokens[1]);
            tempArtical.setAuthor(tokens[2]);
            tempArtical.setYear(tokens[3]);
            Author tempAuthor1 = new Author();
            tempAuthor1.setName(tokens[2]);
            return new Library(tempArtical, tempAuthor1);
        }
        return tempLibrary;

    }
}
/*Publication p = new Publication();
        Author author1 = new Author("霖", "郭",
                "http://guolin.tech", "人民出版社");
        Publication publication1 = new Publication("saddsd","郭霖", 2018, 1, 2);
        Library library1 = new Library(publication1, author1);
        Artical artical1 = new Artical("asddds","郭霖", "zzt", 2018,"第一行代码",1,
                1, 2);
        ConferencePaper conferencePaper1 = new ConferencePaper("asddds", "zzt",
                2017, " ", 5, 2);
        System.out.println(artical1.getAuthors());
        library1.putPublication();
        Library library2 = new Library(artical1, author1);
        library2.putPublication();
        ArrayList<Library> libraries = new ArrayList<>();
        Library library3 = new Library(conferencePaper1, author1);
        library3.putPublication();
        libraries.add(library1);
        libraries.add(library3);
        libraries.add(library2);
        Library[] libraries1 = new Library[3];
        libraries.toArray(libraries1);
        Arrays.sort(libraries1);
        for (Library l : libraries1)
        {
            l.putPublication();
        }
      */
