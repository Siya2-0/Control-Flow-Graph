public class Edge {
    private final String annotation;
    private final Node nextNode;
    private final int computationalTime;

    public Edge(String annot, Node nextNode, int compTime){
        annotation=annot;
        this.nextNode=nextNode;
        computationalTime=compTime;
        //TODO: Implement the function
    }

    public Node getNext(){
        return nextNode;
        //TODO: Implement the function
    }

    public String getAnnotation(){
        return annotation;
        //TODO: Implement the function
    }

    public int compareTo(Edge o)
    {
        if(annotation==o.annotation  )
            return 0;

        return -1;
    }
    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null) return false;
        if(o.getClass() != this.getClass()) return false;

        if(annotation == ((Edge)o).annotation)
            return true;

        return false;
    }
    public int getCompTime(){
        return computationalTime;
        //TODO: Implement the function
    }

    public String toString(){
        //Provided function, do not alter!!!
        String res = "-> " + annotation + " -[" + computationalTime + "]-"; 
        
        if(nextNode == null)
            res += "> NULL";
        else
            res += "> " + nextNode.getAnnotation();

        return res;
    }
}
