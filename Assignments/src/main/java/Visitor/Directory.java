package Visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<File> files;
    private List<Directory> directories;


    public Directory(String name) {
        this.name = name;
        files = new ArrayList<>();
        directories = new ArrayList<>();
    }

    public void addFile(File file) {files.add(file);}
    public void addDirectory(Directory dir) {directories.add(dir);}

    public List<File> getFiles() {return files;}
    public List<Directory> getDirectories() {return directories;}

    public double getSizeMB() {
        return 0.0;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (File file : files) {
            file.accept(visitor);
        }
        for (Directory dir : directories) {
            dir.accept(visitor);
        }
    }

    public String getName() {
        return name;
    }
}
