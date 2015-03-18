package demo;

public class Move {

    private final long id;
    private final String content;
    

    public Move(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
    	return content;
    }

	public long getId() {
        return id;
    }
}
