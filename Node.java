

public class Node {
    private final String annotation;
    private final Container<Edge> edges;
    
    public Node(String annot){
        annotation=annot;
        edges = new Container<Edge>();
        
        //TODO: Implement the function
    }
    public Node(Node n)
    {
        annotation=n.annotation;
        edges=n.edges;
    }
    public void SetEdges(Edge[] n)
    {
       for(int c=0; c<n.length; c++)
       {
            edges.Add(n[c]);
       }
    }



  //  @Override
    public int compareTo(Node o) {
        return annotation.compareTo(o.annotation);
    }

    public void addEdge(Node nextNode, String annotation, int compTime)
    {

        edges.Add(new Edge(annotation, nextNode, compTime));


        //nextNode.edges.Add(new Edge(annotation, this, compTime));

        //TODO: Implement the function
    }

    public String getAnnotation(){
        return  annotation;
        //TODO: Implement the function
    }

    public Edge CorrectEdge(Node nextNode)
    {

        for(int c=0; c<edges.GetSize(); c++)
        {
            if(((Edge)edges.toArray()[c]).getNext().equals(nextNode))
                return (Edge)edges.toArray()[c];
        }
        return null;
    }
    public Edge[] getEdges(){

        Object[] z=edges.toArray();
        Edge[] r= new Edge[z.length];
        for(int c=0; c<z.length; c++)
        {
            r[c]=(Edge)z[c];
         //   System.out.println(z[c]);
        }

     //   System.out.println(z.length);
        return  r;
        //TODO: Implement the function
    }

    @Override
    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null) return false;
        if(o.getClass() != this.getClass()) return false;

        if(annotation.equals(((Node)o).annotation) )
            return true;

        return false;
    }


    public String toString(){
        //Provided function, do not alter!!!
        String res = annotation + ":\n";
        if(edges.toArray().length == 0)
            res += "\t" + "No out going edges" + "\n";
        else
            for(Object e: edges.toArray()){
                res += "\t" + e.toString() + "\n";
            } 
        return res;
    }
}
