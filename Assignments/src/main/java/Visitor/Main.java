package Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("jaa.jpg", 2.0);
        File file2 = new File("rikun_rollit.mp4", 126.0);
        File file3 = new File("todo.txt", 0.3);
        File file4 = new File("velat.pdf", 59.0);
        List<FileSystemElement> files = new ArrayList<>(Arrays.asList(file1, file2, file3, file4));

        Directory rootDir = new Directory("jee");
        Directory dir1 = new Directory("jipii");
        Directory dir2 = new Directory("wuhu");
        Directory dir3 = new Directory("jauu");
        rootDir.addDirectory(dir1);
        rootDir.addDirectory(dir2);
        rootDir.addDirectory(dir3);

        for (FileSystemElement file : files) {
            dir3.addFile((File) file);
        }

        rootDir.accept(new SizeCalculatorVisitor());

        rootDir.accept(new SearchVisitor("jaa.jpg"));


    }
}
