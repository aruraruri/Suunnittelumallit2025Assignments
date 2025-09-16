package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor{
    private double totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSizeMB();
        System.out.println("Total size of directory structure is up to: "+totalSize+" MB");
    }

    @Override
    public void visit(Directory directory) {
        totalSize += directory.getSizeMB();
        System.out.println("Total size of directory structure is up to: "+totalSize+" MB");
    }
}
