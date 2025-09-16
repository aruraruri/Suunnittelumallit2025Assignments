package Visitor;

public class File implements FileSystemElement {
    private String name;
    private double sizeMB;

    public File(String name, double sizeMB) {
        this.name = name;
        this.sizeMB = sizeMB;
    }

    public String getName() {return name;}
    public double getSizeMB() {return sizeMB;}

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
