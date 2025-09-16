package Visitor;

public class SearchVisitor implements FileSystemVisitor{
    private String searchName;

    public SearchVisitor(String searchName) {
        this.searchName = searchName;
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(searchName)) {
            System.out.println("Found file: " + file.getName());
        }
    }

    @Override
    public void visit(Directory directory) {
        if (directory.getName().equals(searchName)) {
            System.out.println("Found directory: " + directory.getName());
        }
    }
}
